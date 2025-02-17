package com.automation.selfhealing.core;

import com.automation.selfhealing.models.AnalysisData;
import com.automation.selfhealing.utils.ImageProcessor;
import org.imgscalr.Scalr;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.opencv.core.Mat;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MultimodalAnalyzer {
    private final WebDriver driver;

    public MultimodalAnalyzer(WebDriver driver) {
        this.driver = driver;
    }

    // Capture DOM and screenshot
    public AnalysisData captureAnalysisData(By failedLocator) throws IOException {
        String dom = driver.getPageSource();
        // Prune irrelevant nodes
        Document doc = Jsoup.parse(dom);
        doc.select("script,style").remove();
        String cleanDOM = doc.body().html(); // Limit to 2KB
        Mat screenshot = captureElementScreenshot(failedLocator);
        return new AnalysisData(cleanDOM, screenshot);
    }

    private Mat captureElementScreenshot(By locator) {
        try {
            // 1. Try normal element capture first
            WebElement element = driver.findElement(locator);
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            return ImageProcessor.cropToElement(screenshot, element);
        } catch (NoSuchElementException e) {
            // 2. Fallback: Capture entire viewport and estimate position
            try {
                return captureFallbackScreenshot(locator);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Mat captureFallbackScreenshot(By locator) throws IOException {
        // Capture full page screenshot
        File fullScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        BufferedImage resized = Scalr.resize(ImageIO.read(fullScreenshot), 256);
        File tempFile = File.createTempFile("resized_image", ".png");
        ImageIO.write(resized, "PNG", tempFile);
        Mat fullImage = ImageProcessor.loadImage(tempFile);

        // Get element position via JavaScript (even if not visible)
        try {
            String script =
                    "var e = document.evaluate(arguments[0], document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;" +
                            "if (!e) return null;" +
                            "var rect = e.getBoundingClientRect();" +
                            "return [rect.left, rect.top, rect.width, rect.height];";

            Object result = ((JavascriptExecutor)driver).executeScript(script, getLocatorExpression(locator));

            if (result != null) {
                List<Long> coords = (List<Long>) result;
                return ImageProcessor.cropToRegion(
                        fullImage,
                        coords.get(0).intValue(),
                        coords.get(1).intValue(),
                        coords.get(2).intValue(),
                        coords.get(3).intValue()
                );
            }
        } catch (Exception jsEx) {
            return fullImage;
        }
        // Final fallback: Return entire screenshot
        return fullImage;
    }

    private String getLocatorExpression(By locator) {
        // Convert By object to XPath/CSS expression
        String locatorStr = locator.toString();
        return locatorStr.substring(locatorStr.indexOf(":") + 1).trim();
    }
}
