Feature: Wizarding World WebSite Tests

  Background:
    Given browser is open

  Scenario: Navigate to Wizarding World site from Google Search
    When user enters text in google search box
    And hits Enter
    Then user navigate to the Wizarding World

  Scenario Outline: Login to Wizarding World
    When user is on Wizarding World page
    And user is on login page
    When user enters "<email>" and "<password>"
    And clicks on continue button
    Then user is navigated to the home page

    Examples:
    | email | password |
    | begumsuozsu@hotmail.com | Begum94+ |

  Scenario Outline: Unsuccessful Login to Wizarding World
    When user is on Wizarding World page
    And user is on login page
    When user enters "<email>" and "<password>"
    And clicks on continue button
    Then user see the fail message

    Examples:
    | email | password |
    | test@gmail.com | Cdeb0207 |
