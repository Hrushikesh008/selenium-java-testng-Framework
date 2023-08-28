Feature: Verify selenium easy radio buttons page features

  @Test
  Scenario Outline: Verify selenium easy radio buttons page features
    Given I navigate to the "http://demo.seleniumeasy.com/" page
    Given user is on selenium easy homePage verifying page title
    When user navigate to radio buttons page
    And user verifys radio buttons page title
    Then user clicks "<ageGroup>" and "<sex>" in radio buttons page
    And user clicks on get value button
    And user verifys "<sucessMessageForSex>" and "<sucessMessageForAgeGroup>"

    Examples: 
      | ageGroup | sex  | sucessMessageForSex | sucessMessageForAgeGroup |
      | 0 - 5    | Male | Sex : Male          | Age group: 0 - 5         |
