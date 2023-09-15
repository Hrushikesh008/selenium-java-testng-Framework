Feature: Verify selenium easy simple form demo page features

  Background: User navigates and verifys title
    Given I navigate to the "http://demo.seleniumeasy.com/" page
    And user is on selenium easy homePage verifying page title
    When user navigate to Simple Form Demo page
    And user verifys simple form demo page title

  @Test
  Scenario: Verify single input fild in selenium easy simple form demo page features
    Then user enters "TCS" in single input field text box
    And user clicks on single input field show message button
    And user verifys single input field sucess message is equal to "TCS"

  @Test
  Scenario Outline: Verify two input fild in selenium easy simple form demo page features
    Then user enters <valueA> and <valueB> in two input field text box
    And user clicks on two input field get total button
    And user verifys two input field total message is equal to "<result>"

    Examples: 
      | valueA | valueB | result |
      |     10 |     15 |     25 |
      |   5845 |   3783 |   9628 |
