package com.automation.utility;

import com.automation.framework.BaseTest;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class PageActionLibrary extends BaseTest{
    private static final Logger logger = LogManager.getLogger(PageActionLibrary.class);

    /**
     * To get first visible element
     *
     * @param locator     Identifier of element
     * @return WebElement     *
     */
    public static WebElement getElementByVisibility(String locator) {
        By byElement = ElementExtractor.getElement(locator);
        WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(5));
        logger.info("Checking visibility of element:"+locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
    }

    /**
     * To click on element
     *
     * @param locator
     */
    public static void clickElement(String locator) throws Exception {
        WebElement element = getElementByVisibility(locator);
        if (element != null) {
            try {
                logger.info("Clicking on element:"+locator);
                element.click();
            } catch (Exception e) {
                WebElement alterElement = getFinder().findElementWithHealing(ElementExtractor.getElement(locator), e);
                if (alterElement != null) {
                    alterElement.click();
                }else {
                    logger.info(e);
                    System.out.println(e);
                }
            }
        }
    }


    /**
     * To wait for provided milliseconds
     *
     * @param milliSeconds *
     */
    public static void waitForMilliSeconds(int milliSeconds) {
        try {
            logger.info("Waiting for " + milliSeconds + " Miliseconds..");
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            logger.info(e);
            e.printStackTrace();
        }
    }


    /**
     * To send text to element
     *
     * @param locator
     * @return
     */
    public static boolean sendText(String locator, String text) throws Exception {
            try {
                WebElement element = getElementByVisibility( locator);
                logger.info("Send keys on element:"+element+text);
                element.sendKeys(text);
                return true;
            } catch (Exception ex) {
                WebElement alterElement = getFinder().findElementWithHealing(ElementExtractor.getElement(locator), ex);
                if (alterElement != null) {
                    alterElement.sendKeys(text);
                    return true;
                }else {
                    logger.info(ex);
                    System.out.println(ex);
                }
            }
        return false;
    }

    /**
     * To scroll down
     *
     */
    public static void scrollToThePoint(int point) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,"+ point +")");
    }
    /**
     * To scroll down
     *
     */
    public static void scrollToTheEnd() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
    }

    public static List<String> getElementNameList(String locator) {
        List<String> elementText = new ArrayList<>();
        By byElement = ElementExtractor.getElement(locator);
        List<WebElement> myElements = driver.findElements(byElement);
        for(WebElement e : myElements) {
            elementText.add(e.getText());
        }
        return elementText;
    }

    public static void openLinkInNewTab(String locator) {
        String selectLinkToOpenInNewTab = Keys.chord(Keys.CONTROL,"t");
        WebElement element = getElementByVisibility( locator);
        if (element != null) {
            try {
                element.sendKeys(selectLinkToOpenInNewTab);
            } catch (Exception e) {
                logger.info(e);
                System.out.println(e);
            }
        }
       // driver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpeninNewTab);
    }

    public static void SwitchToNewTab() {

    }

    public static void performMouseOverOnMainMenu(String locator) {
        WebElement element = getElementByVisibility( locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void performMouseOverAndClickOnSUbMenu(String locator) {
        WebElement element = getElementByVisibility(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click().build().perform();
    }

    public static void handledSmartLoad() {
        waitForMilliSeconds(3000);
        scrollToThePoint(950);
        waitForMilliSeconds(5000);
        scrollToThePoint(950);
        waitForMilliSeconds(5000);
        scrollToThePoint(950);
        waitForMilliSeconds(5000);
        scrollToTheEnd();
        waitForMilliSeconds(5000);
    }

    public static void scrollToTheTop() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.HOME).perform();

    }

    public static String getText(String locator) {
        WebElement element = getElementByVisibility(locator);
        String value = null;
        if (element != null) {
            try {
                logger.info("Extracting Text from Locator:"+locator);
               value = element.getText();
            } catch (Exception e) {
                logger.info(e);
                System.out.println(e);
                return "";
            }
        }
        return value;
    }
}
