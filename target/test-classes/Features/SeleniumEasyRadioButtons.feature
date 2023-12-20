Feature: Verify selenium easy radio buttons page features

  Background: User navigates and verifys title
    Given user navigate to the "http://demo.seleniumeasy.com/" page
    And user is on selenium easy homePage verifying page title
    And user clicks on dropdown "Input Forms" to click sub dropdown "Radio Buttons Demo"
    And user verifys radio buttons page title

  @Test
  Scenario Outline: Verify radio buttons demo in selenium easy radio buttons page features
    When user clicks on "Female" in radio button page
    And user clicks on get checked value button
    Then user verifys if "Radio button 'Female' is checked"

  @Test
  Scenario Outline: Verify group radio buttons demo in selenium easy radio buttons page features
    When user clicks "<ageGroup>" and "<sex>" in radio buttons page
    And user clicks on get value button
    Then user verifys "<sucessMessageForSex>" and "<sucessMessageForAgeGroup>"

    Examples: 
      | ageGroup | sex    | sucessMessageForSex | sucessMessageForAgeGroup |
      | 0 - 5    | Male   | Sex : Male          | Age group: 0 - 5         |
      | 15 - 50  | Female | Sex : Female        | Age group: 15 - 50       |
