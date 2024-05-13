@Elif
Feature:As a user, (Store and Sales managers) I want to manage filters on the
  Vehicle Costs page. (Web table and checkbox)

  Background: Users should be able to login
  When user is on the login page

    Scenario Outline: Verify that Store manager and Sales manager see 3 columns on the Vehicle Costs page.
      When user logged in as "<userType>"
      When user go to Fleet menu and Vehicle Odometer submenu
      Then user can see "TYPE, TOTAL PRICE, DATE" columns.
      Examples:
        | userType      |
        | sales manager |
        | store manager |

  Scenario Outline: Verify that Store manager and Sales manager can check the first checkbox to select All Vehicle Costs.
      When user logged in as "<userType>"
      When user go to Fleet menu and Vehicle Odometer submenu
      When user can check the first checkbox
      Then user see that all Vehicle Costs is selected on the Vehicle Costs page
    Examples:
      | userType      |
      | sales manager |
      | store manager |

  Scenario Outline: Verify that Store manager and Sales manager can check the first checkbox to select All Vehicle Costs.
    When user logged in as "<userType>"
    When user go to Fleet menu and Vehicle Odometer submenu
    When user can uncheck the first checkbox
    Then user see that all Vehicle Costs is not selected on the Vehicle Costs page
    Examples:
      | userType      |
      | sales manager |
      | store manager |
