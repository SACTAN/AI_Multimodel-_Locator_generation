package com.automation.locators;

public class Web {
    public static class homePage {
        public static final String LOGIN_BUTTON = "//button[text()='Log In']~xpath";
        public static final String LOGIN_EMAIL_ADDRESS_TEXT_BOX = "//input[@placeholder='Enter your email address...']~xpath";
        public static final String LOGIN_EMAIL_PASSWORD_TEXT_BOX = "//input[@placeholder='Enter your password...']~xpath";
        public static final String LOG_IN_BUTTON = "(//button[text()='Log In'])[2]~xpath";
        public static final String SHOW_ROWS_OPTION1="//div[@class='sc-16r8icm-0 tu1guj-0 cSTqvK'][normalize-space()='100']~xpath";
        public static final String SHOW_ROWS_OPTION ="//button[normalize-space()='view_option']~xpath";
        public static final String COINS_VIEW_LIST_NAMES ="//td//div[contains(@class,'dNOTPP')]/p~xpath";
        public static final String COINS_STAR_ICON_ADD_WATCH_LIST ="//p[normalize-space()='coin_name']/ancestor::tr/td//span[@class='icon-Star']~xpath";
        public static final String WATCH_LIST_TAB_LINK ="//a[@href='/watchlist/']~xpath";
        public static final String WATCH_LIST_ADDED_COINS_NAME = "//span[@class='icon-Star-Filled']/ancestor::tr//td//div[contains(@class,'dNOTPP')]/p~xpath";
        public static final String CRYPTOCURRENCY_SUBMENU_OPTION = "//div[contains(@class,'submenu')]/a[normalize-space()='submenu_option']~xpath";
        public static final String FILTER_TAB_NAME = "//a[normalize-space()='tab_name']~xpath";

        //my locator
        public static final String LANGUAGE_SELECT = "//*[@id='translation-btn']~xpath";
        public static final String COUNTRY_LIST_BUTTON = "//span[@id='country-name']~xpath";
        public static final String selectCountry(String country)
        {
            return "//span[contains(text(),'"+country+"')]~xpath";
        }

        public static final String getPackage(String packageName)
        {
            return "//strong[@id='name-"+packageName.toLowerCase()+"']~xpath";
        }

        public static final String getPrice(String packageName)
        {
            return "//div[@id='currency-"+packageName.toLowerCase()+"']/b~xpath";
        }

        public static final String getCurrency(String packageName)
        {
            return "//div[@id='currency-"+packageName.toLowerCase()+"']/i~xpath";
        }

        public static final String getCurrenyforKSA(String packageName)
        {
            return "//div[@id='currency-"+packageName.toLowerCase()+"']/i[2]~xpath";
        }




    }
}
