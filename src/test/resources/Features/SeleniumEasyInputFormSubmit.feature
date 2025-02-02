Feature: Verify selenium easy InputFormSubmitPage features

  Background: User navigates and verifys title
    Given user navigate to the "http://demo.seleniumeasy.com/" page
    And user is on selenium easy homePage verifying page title
    And user clicks on dropdown "Input Forms" to click sub dropdown "Input Form Submit"
    And user verifys input form submit page title

  @Test
  Scenario: Verify selenium easy input form submitPage features property file
    When user fills input text box from property file
      | fieldName  | inputValue |
      | First Name | FirstName  |
      | Last Name  | LastName   |
      | E-Mail     | EMail      |
      | Phone #    | Phone      |
      | Address    | Address    |
      | City       | City       |
      | Zip Code   | ZipCode    |
    And user clicks send button
    Then user verifys if input box are filled

  @Test
  Scenario: Verify selenium easy input form submit page features CSV file
    When user fills input text box from CSV files
      | fieldName  | inputValueCSV |
      | First Name | FirstName     |
      | Last Name  | LastName      |
      | E-Mail     | EMail         |
      | Phone #    | Phone         |
      | Address    | Address       |
      | City       | City          |
      | Zip Code   | ZipCode       |
    And user clicks send button
    Then user verifys if input box are filled

  @Test
  Scenario: Verify selenium easy input form submit page features cucumber data table
    When user fills input in text box from data table
      | fieldName  | inputValue       |
      | First Name | Muhammad         |
      | Last Name  | Ali              |
      | E-Mail     | Muhammad@abc.com |
      | Phone #    |       0987654321 |
      | Address    | Street24         |
      | City       | G-City           |
      | Zip Code   |            00000 |
    And user clicks send button
    Then user verifys if input box are filled

  @Test
  Scenario Outline: Verify error message in selenium easy input form submit page features cucumber data table
    When user fills input in text box from data table
      | fieldName  | inputValue |
      | First Name | M          |
      | Phone #    | 0987654321 |
      | Address    | Street24   |
      | City       | G-City     |
      | Zip Code   |      00000 |
    And user clicks send button
    Then user verifys if error message is visible
      | ErrorMessage                        |
      | Please enter more than 2 characters |
      | Please supply your last name        |
      | Please supply your email address    |
