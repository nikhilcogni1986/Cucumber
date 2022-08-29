Feature: Place a order in the the Flipkart
  As a end user I want to
  add a product to the cart
  and place the order

  Scenario: Add a product to the cart
    Given I'm on store page
    When I add Blue Shoes to the cart
    Then I should see 1 Blue Shoes in the cart

  Scenario Outline: Add products to the cart using examples
    Given I'm on store page
    When I add "<ProductName>" to the cart
    Then I should see 1 "<ProductName>" in the cart

    Examples:
      | ProductName      |
      | Anchor Bracelet  |
      | Basic Blue Jeans |