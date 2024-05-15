@B33G2-52
Feature: As a user, I should be access to the Oroinc Documentation page

  #@B33G2-57
  Background: User is already in the log in page
    Given user is on the login page

  @B33G2-59
  Scenario Outline: Verify that users see 8 filter items on the Accounts page
    Given user logged in as "<userType>"
    And user navigates to accounts page
    Then user sees the eight filter items
      | Account name  |
      | Contact name  |
      | Contact email |
      | Contact phone |
      | Owner         |
      | Business Unit |
      | Created At    |
      | Updated At    |

    Examples:
      | userType      |
      | sales manager |
      | store manager |
