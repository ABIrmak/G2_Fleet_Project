@login
Feature: Users should be able to login

  Background: User is already in the log in page
    Given user is on the login page

  Scenario Outline: Verify login with different user types
    Given user logged in as "<userType>"
    Then user should be able to see the dashboard
    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |

  Scenario: Verify that the login fails with invalid username
    And user logs in with "asdf" as the username and "UserUser123" as the password
    Then user should fail to log in

  Scenario: Verify that the login fails with invalid password
    And user logs in with "user1" as the username and "asdf" as the password
    Then user should fail to log in
