Feature: Move the bat properly in diferent situations
    As a player
    I wanna move the bat properly
    So that

    Background: game start
        Given I can see the game
		Given I wait for the "PongActivity" screen to appear
		Then I click on screen 50% from the left and 50% from the top
        
	Scenario: Move bat up
		Then I click on screen 50% from the left and 25% from the top
		Then I drag from 740:897 to 540:897 moving with 100 steps
		Then I wait

	Scenario: Move bat down
		Then I click on screen 50% from the left and 75% from the top
		Then I drag from 340:897 to 540:897 moving with 100 steps
		Then I wait

	Scenario: shoot until lost the game
		Then I click on screen 50% from the left and 7% from the top
		Then I click on screen 50% from the left and 5% from the top
		Then I click on screen 50% from the left and 5% from the top
		Then I click on screen 50% from the left and 5% from the top
		Then I click on screen 50% from the left and 5% from the top
		Then I click on screen 50% from the left and 5% from the top
		Then the bat doesn't move by its own because we lost
		Then I wait

	Scenario: Move bat to the left
		Then I click on screen 25% from the left and 50% from the top
		Then I drag from 540:1197 to 540:897 moving with 100 steps
		Then I wait

	Scenario: Move bat to the right
		Then I click on screen 75% from the left and 50% from the top
		Then I drag from 540:697 to 540:897 moving with 100 steps
		Then I wait
        

