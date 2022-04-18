@wip
Feature: Shopping cart shopping functionality

  Scenario: Shopping cart functionality test
    Given user on SwagLabs home page
    And  user sorts the items lowest price to highest price
    And user adds two or more items to the shopping cart
    When user visits the shopping cart
    Then user should be able to remove item from shopping cart
    And user should be able to continue shopping
    And user should be able to add another item to shopping cart
    And user should be able to checkout