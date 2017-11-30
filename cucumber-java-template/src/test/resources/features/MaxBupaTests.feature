Feature: Get a new Quote on Max Bupa

  @MaxBupaWebTest
  Scenario Outline: 10202_Create a new Quote on Max Bupa
    Given Read "<TestData>" from excel file
    And I open the Website
    And I fill the calculate your premium form
    And I buy health companiion plan
    And I fill in the personal details
    When I click on continue
    Then Verify that the user gets navigated to dashboard page

    Examples: 
      | TestData  |
      | Testdata1 |