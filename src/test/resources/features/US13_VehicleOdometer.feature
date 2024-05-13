@Elif
Feature: Users should be able to view car odometer info on the Vehicles Odometer page.

  Background: Users should be able to login
    When user is on the login page

    Scenario Outline: Verify that Store and Sales managers see the error message on the Vehicles Odometer page.
      When user logged in as "<userType>"
      When user go to Fleet menu and Vehicle Odometer submenu
      Then user see the error message "You do not have permission to perform this action."
      Examples:
        | userType      |
        | sales manager |
        | store manager |

  Scenario Outline: Verify that Drivers see car odometer info on the Vehicles Odometer page.
    When user logged in as "<userType>"
    When user go to Fleet menu and Vehicle Odometer submenu
    Then user see the default page as "1".
    Examples:
      | userType      |
      | driver        |

  Scenario Outline: Verify that Drivers see car odometer info on the Vehicles Odometer page.
    When user logged in as "<userType>"
    When user go to Fleet menu and Vehicle Odometer submenu
    Then user see the View Per Page as "25" by default.

    Examples:
      | userType      |
      | driver        |
