Feature:I want validate Send Fax functionality

  @testCaseSenFax
  Scenario Outline: I should be able send fax after successfully Login

    Given Given I navigate to portal Login page
    When user enter "<usernameData>" username and "<passwordData>" password
    Then i click to Login button
    Then landing the HomePage
    And i add "<number>",coverPage and "<PageSize>" to send fax

    Examples:
      | usernameData    | passwordData|     number        | PageSize |
      |  admin@auto1    |    softlinx |    2222222222     |  2       |


