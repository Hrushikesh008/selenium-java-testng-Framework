Feature: Verify selenium easy range slider page features

  Background: User navigates and verifys title
    Given I navigate to the "http://demo.seleniumeasy.com/" page
    And user is on selenium easy homePage verifying page title
    And user navigate to "Progress Bars" page by clicking "Drag & Drop Sliders" dropdown
    And user verifys range slider page title

  @Test
  Scenario: Verify selenium easy range slider page features
    When user drages slider from position 0 to 50
    Then user verifys range slider position "50"
