@B33G2-42
Feature: As a user, I should be access to the Oroinc Documentation page

  #@B33G2-57
  Background: User is already in the log in page
    Given user is on the login page

  @B33G2-55
  Scenario Outline: Verify that every user type can access the documentation page
    Given user logged in as "<userType>"
    And user clicks the get help link
    Then user should see the documentation page open
    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |
