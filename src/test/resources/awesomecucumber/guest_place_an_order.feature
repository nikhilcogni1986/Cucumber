Feature: Place an order as a guest user
  As a end user I want to
  add a product to the cart
  and place the order as a guest user

  Scenario: Place an order as a guest user
    Given I'm a guest customer
    And my billing details are
      | firstname | lastname | country            | address_line1     | city  | state | zip   | email         |
      | demo      | user     | United States (US) | 6300 Spring Creek | Plano | Texas | 75024 | demo@test.com |
    When I have a product in the cart
    And I'm on the checkout page
    When I provide the billing details
    And I place an order
    Then order should be placed successfully