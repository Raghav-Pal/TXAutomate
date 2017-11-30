Feature: Buy a product on Barneys

  @BarneysWebTest
  Scenario: Buy a pair of shoes from Barneys
    Given I open Barneys Staging website
    And I Login on the Website
    And I select the Men Category
    And I select the Product and Size
    And I enter the quantity
    When I click on Add to cart
    Then I logout from the application
