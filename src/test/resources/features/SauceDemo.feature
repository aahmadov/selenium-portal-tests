Feature: SauceDemos

  Scenario Outline: Login to Sauce demo
    Given I have sauce demo application
    When I login with <username> and <password>
    Then login should be successful

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
#      | performance_glitch_user | secret_sauce |