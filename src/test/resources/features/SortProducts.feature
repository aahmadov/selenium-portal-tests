Feature: Sort Products

Feature to test the Sauce demo web app functionality

  Scenario Outline: SauceDemo - Sort products by price from low to High
    Given I have sauce demo application
    When I login with <username> and <password>
    And I select  product sort option
      | sortOption          |
      | Price (low to high) |
    Then I verify products are sorted by price from low to high

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |