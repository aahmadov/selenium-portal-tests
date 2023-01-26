Feature:I want validate Login functionality

  @testCase1
  Scenario: I should be able to Login ReplixFax portal with valid credentials
    Given I navigate to portal Login page
    When i enter valid "admin@auto1" username
    Then i enter valid "softlinx" password
    Then i click to Login button
    And login should be successfully land on Portal homepage
    And I should able successfully send Fax with cover page

 @testCase2
  Scenario: I should not be able to Login ReplixFax portal with Invalid credentilas
    Given I navigate to portal Login page
    When i enter invalid "Invalid username" username
    Then i enter invalid "Invalid Password" password
    Then i click to Login button
    And I should verify "Please include organization name." error message

  @testCase
  Scenario Outline: I should be able to Login ReplixFax portal with valid credentials

    Given Given I navigate to portal Login page
    When user enter "<usernameData>" username and "<passwordData>" password
    Then i click to Login button

    Examples:
      | usernameData         | passwordData       |
      |  faxsending@acme1    |    Softlinx1!      |
