@B33G2-54
Feature: As a user, I want to manage filters on the Marketing page.

  #@B33G2-57
  Background: User is already in the log in page
    Given user is on the login page

  @B33G2-73
  Scenario Outline: Verify that Store and Sales managers see all 5 filter options as checked by default.
    Given user logged in as "<userType>"
    And user navigates to campaigns page
    Then user clicks the filters link
    Then user presses the manage filters button
    Then user should see that the five filter options are checked by default

    Examples:
      | userType      |
      | store manager |
      | sales manager |

  @B33G2-74
  Scenario Outline: Verify that any amount of boxes can be unchecked. (Can check only 1 or multiple)
    Given user logged in as "<userType>"
    And user navigates to campaigns page
    Then user clicks the filters link
    Then user presses the manage filters button
    Then user should be able to unselect the five filter options separately

    Examples:
      | userType      |
      | sales manager |
      | store manager |
