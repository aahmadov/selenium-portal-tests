Feature: Signup into the Php travels

As a user 
I should be able to signup for the PHP travels

Scenario: Signup into the Php travels website
	Given I navigate to the php travels portal
	When I navigate to the signup page
	And I enter required information
	And I click on register button
	Then I should be registered successfully
	