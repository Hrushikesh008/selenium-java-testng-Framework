Feature: Verify selenium easy range slider page features

  @Test
  Scenario: Verify selenium easy range slider page features
    Given I navigate to the "http://demo.seleniumeasy.com/" page
    Given user is on selenium easy homePage verifying page title
    And user navigate to range slider page
    Then user verifys range slider page title
    And user drages slider from position 0 to 50
    Then user verifys range slider position "50"
