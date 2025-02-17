package com.automation.selfhealing.core;

import com.automation.selfhealing.clients.MultimodalOllamaClient;
import com.automation.selfhealing.models.AnalysisData;
import com.automation.selfhealing.utils.ImageProcessor;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelfHealingFinder {
    private final WebDriver driver;
    private final MultimodalAnalyzer analyzer;

    private final MultimodalOllamaClient ollama;

    public MultimodalOllamaClient getOllama() {
        return ollama;
    }

    public SelfHealingFinder(WebDriver driver) {
        this.driver = driver;
        this.analyzer = new MultimodalAnalyzer(driver);
        this.ollama = new MultimodalOllamaClient();
    }

    public WebElement findElementWithHealing(By originalLocator, Exception exception) throws Exception {
        try {
            return attemptHealing(originalLocator, exception);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    private WebElement attemptHealing(By failedLocator, Exception e) throws Exception {
        AnalysisData data = analyzer.captureAnalysisData(failedLocator);
        WebElement element = null;

        // Convert image to base64
        String base64Image = ImageProcessor.matToBase64(data.visualData());

        // Get AI suggestions
        String locators = Arrays.toString(new String[]{ollama.generateLocator(
                Jsoup.parse(data.dom()).body().html(),
                base64Image, failedLocator, e
        )});

        // Try suggested locators
        if (!locators.isEmpty()) {
            try {
                List<String> parsedLocator = parseLocator(locators);
                for (String xpath : parsedLocator) {
                    try {
                        element = driver.findElement(By.xpath(xpath));
                        System.out.println("Element found using XPath: " + xpath);
                        break;
                    } catch (Exception exp) {
                        System.out.println("XPath not found: " + xpath);
                    }
                }

                return element;
            } catch (NoSuchElementException retryEx) {
                retryEx.getMessage();
            }
        }
        throw new NoSuchElementException("All healing attempts failed");
    }


    public static List<String> parseLocator(String locator) {
        List<String> xpaths = new ArrayList<>();
        // Regular expression to match XPath expressions
        String xpathRegex = "//(?:[a-zA-Z0-9_-]+)(?:\\[[^]]+\\])?(?:/[a-zA-Z0-9_-]+(?:\\[[^]]+\\])?)*";

        Pattern pattern = Pattern.compile(xpathRegex);
        Matcher matcher = pattern.matcher(locator);

        while (matcher.find()) {
            xpaths.add(matcher.group());
        }
        return xpaths;
    }
}
