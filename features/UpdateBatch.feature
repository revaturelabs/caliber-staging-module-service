Feature: Update batch
  As a user, I wish to manually assign an associate to a specific batch

  Scenario Outline: Manually updating batch id for associate
  	Given User is at the login page
	When user inputs their email "<email>"
	And user inputs their password "<password>"
	And user clicks log in
    When a user is on the home page
    And clicks update batch button 
    Then inputs the new "<newBatchNum>"
    And submits the changes
    Then the user should see the updated batch id

    Examples:
      | email             | password    | newBatchNum |
      | test@revature.com | password    | 2           |
