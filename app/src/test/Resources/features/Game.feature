Feature: As a player I wanna play the game

	Scenario:  Stop the game
	    Given the game
        When I quit the game
    	Then The game stops

	Scenario: Created the ball
		Given the game
		When game start
		Then The ball is created

	Scenario: Created the bullet
    	Given the game
    	When game start
    	Then The bullet is created

    Scenario: Print a message when you lose
        Given the game
        When I lose the game
        Then Print that you have lost

    Scenario: Resume the game
        Given the game stopped
        When I start the game
        Then the game resumes
