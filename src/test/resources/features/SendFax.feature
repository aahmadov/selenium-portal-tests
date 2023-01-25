Feature:I want validate Send Fax functionality

  @testCase3
  Scenario Outline: I should be able send fax after successfully Login

    Given Given I navigate to portal Login page
    When user enter "<usernameData>" username and "<passwordData>" password
    Then i click to Login button

    Examples:
      | usernameData         | passwordData       |
      |  faxsending@acme1    |    Softlinx1!      |