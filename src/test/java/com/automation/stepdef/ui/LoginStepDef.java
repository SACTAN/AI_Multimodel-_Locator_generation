package com.automation.stepdef.ui;

import com.automation.framework.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.automation.utility.PageActionLibrary;


import static com.automation.locators.Login.homePage.*;

public class LoginStepDef extends BaseTest {

    @Given("Open Browser and navigate to application")
    public void open_Browser_and_navigate_to_application() {
        getDriver();
    }

    /*
    This method is used to enter username and password and click on the login button
    */
    @When("Enter Username and password and hit login button")
    public void enter_Username_and_password_and_hit_login_button() throws Exception {

        PageActionLibrary.sendText(LOGIN_EMAIL,"testuser");
        PageActionLibrary.sendText(LOGIN_PASSWORD,"testuser");
        PageActionLibrary.clickElement(LOGIN_BUTTON);
        Thread.sleep(2000);
    }

    /*
    This method is used for verifying the home page title
    */
    @Then("Home page should be displayed with correct title")
    public void home_page_should_be_displayed_with_correct_title() {
        String expectedTitle = "Home - Sachin Bhute";
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Test Failed: Home page title mismatch", expectedTitle, actualTitle);
        driver.quit();
    }
}

