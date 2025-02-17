# new feature
# Tags: optional
@Ui

Feature: Login scenarios with self healing locator capability with dom and image parse.

    Scenario: Login with valid credentials
        Given Open Browser and navigate to application
        When Enter Username and password and hit login button
        Then Home page should be displayed with correct title
