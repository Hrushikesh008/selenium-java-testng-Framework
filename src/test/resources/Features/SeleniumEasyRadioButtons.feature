Feature: Verify selenium easy radio buttons page features

  Background: User navigates and verifys title
    Given I navigate to the "http://demo.seleniumeasy.com/" page
    And user is on selenium easy homePage verifying page title
    And user navigate to "Input Forms" page by clicking "Radio Buttons Demo" dropdown
    And user verifys radio buttons page title

  @Test
  Scenario Outline: Verify selenium easy radio buttons page features
    When user clicks "<ageGroup>" and "<sex>" in radio buttons page
    And user clicks on get value button
    Then user verifys "<sucessMessageForSex>" and "<sucessMessageForAgeGroup>"

    Examples: 
      | ageGroup | sex  | sucessMessageForSex | sucessMessageForAgeGroup |
      | 0 - 5    | Male | Sex : Male          | Age group: 0 - 5         |