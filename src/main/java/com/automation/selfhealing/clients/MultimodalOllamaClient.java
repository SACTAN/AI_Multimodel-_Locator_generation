package com.automation.selfhealing.clients;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.By;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class MultimodalOllamaClient {

    private static final String OLLAMA_URL = "http://localhost:11434/api/generate";
    private static final Gson gson = new Gson();
    StringBuilder fullResponse = new StringBuilder();
    private static final Cache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(1, TimeUnit.HOURS)
            .build();


    public String generateLocator(String domSnippet, String base64Image, By failedLocator, Exception e) throws Exception {
        // Cache frequent requests
        JsonObject options = new JsonObject();
        String cacheKey = domSnippet.hashCode() + "|" + base64Image.hashCode();
        String cached = cache.getIfPresent(cacheKey);
        if (cached != null) return cached;

        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(30_0000)
                .setSocketTimeout(120_0000)
                .build();

        try (CloseableHttpClient client = HttpClients.custom()
                .setDefaultRequestConfig(config)
                .build()) {

            HttpPost post = new HttpPost(OLLAMA_URL);
            JsonObject payload = new JsonObject();
            payload.addProperty("model", "llava:7b");
            String prompt = String.format(
                    "As a QA automation expert, I wanted to verify the dom snippet and identified the change in " +
                            "failed xpath and suggest 3 best alternative Selenium xpath locators for failed element " +
                            "Original locator '%s' failed with error: '%s'. HTML snippet: '''%s''' " +
                            "Respond with valid and working 3 xpath locator for failed element only in format: '//tag[@attribute = 'value']'",
                    failedLocator, e.getMessage().substring(1,100), domSnippet);
            payload.addProperty("prompt", prompt);
            payload.addProperty("stream", true);
            JsonArray imagesArray = new JsonArray();
            imagesArray.add(base64Image);
            payload.add("images", imagesArray);
            options.addProperty("temperature", 0.9); // Reduce randomness
            options.addProperty("num_predict", 200); // Limit response length
            options.addProperty("num_gpu", 1); // Force GPU usage
            options.addProperty("num_ctx", 512); // Smaller context window

            payload.add("options", options);

            post.setEntity(new StringEntity(gson.toJson(payload)));
            post.setHeader("Content-Type", "application/json");

            try (CloseableHttpResponse response = client.execute(post)) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent())
                );

                String line;
                while ((line = reader.readLine()) != null) {
                    JsonObject chunk = gson.fromJson(line, JsonObject.class);
                    if (chunk.has("response")) {
                        fullResponse.append(chunk.get("response").getAsString());
                    }
                    if (chunk.has("done") && chunk.get("done").getAsBoolean()) {
                        break; // End of stream
                    }
                }
            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            } finally {
                client.close();
            }
        }
        System.out.println("response is : " + fullResponse.toString());
        return fullResponse.toString();
    }
}
