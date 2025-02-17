package com.automation.utility;

import org.openqa.selenium.By;

public class ElementExtractor {
    public static By getElement(String element) {
        String[] controller = element.split("~");
        switch (controller[1].toLowerCase()) {
            case "xpath":
                return By.xpath(controller[0]);
            case "css":
                return By.cssSelector(controller[0]);
            case "id":
                return By.id(controller[0]);
            case "name":
                return By.name(controller[0]);
            case "tag":
                return By.tagName(controller[0]);
            case "class":
                return By.className(controller[0]);
            default:
                System.out.println("Provider locator type is not valid..");
        }
        return null;
    }
}
