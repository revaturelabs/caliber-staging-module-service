Feature: Toast Message
	
	#As a user I wish to interact with the page without first clicking on the message
	Scenario Outline: Interacting with the page with active message
	Given User is at the login page
	When user inputs their email <"email">
	And user inputs their password <"password">
	And user clicks log in
	And user clicks view swots
	And user clicks add new item
	And user selects type opportunity
	And user submits item name <"text">
	And user clicks add item
	Then user can click add new item again without clearing the message
	
	Examples:
	| email             | password | text          |
	| test@revature.com | password | just checking |
	| test@revature.com | password | checking again|
	| test@revature.com | password | last time     |
	
	#As a user I wish to see all toasts clearly if there are more than one
	Scenario Outline: Ensuring toasts are clearly visible
	Given User is at the login page
	When user inputs their email <"email">
	And user inputs their password <"password">
	And user clicks log in
	And user clicks view swots
	And user clicks add new item
	And user selects type opportunity
	And user submits item name <"text">
	And user clicks add item
	And user clicks update for recently created item
	And user changes type to strength
	And user clicks delete for the same item
	Then the three messages should occupy separate locations on the screen
	
	Examples:
	| email             | password | text          |
	| test@revature.com | password | just checking |
	| test@revature.com | password | checking again|
	| test@revature.com | password | last time     |
	
	# Test ensuring nothing that used to cause alerts brings up alerts
	# (create swot on home page; add new item, update, and delete on view page)
	
	# Could also "then" this by having the user return to the home page and asserting
	# That they reached there safely alerts would not allow the page to page navigation
	# As a user I don't want my page frozen by a javascript alert 
	Scenario Outline: Test ensuring page contains no javascript alerts
	Given User is at the login page
	When user inputs their email <"email">
	And user inputs their password <"password">
	And user clicks log in
	And user clicks create swot
	And user selects type threat
	And user submits item name <"text">
	And user clicks view swots
	And user clicks add new item
	And user selects type weakness
	And user submits item name <"textTwo">
	And user clicks add item
	And user clicks update for recently created item
	And user changes type to strength
	And user clicks delete for the same item
	Then the user should have four toast messages
	
	Examples:
	| email             | password | text          | textTwo     |
	| test@revature.com | password | just checking | more checks |
	| test@revature.com | password | checking again| testing     |
	| test@revature.com | password | better safe   | than sorry  |
	
	