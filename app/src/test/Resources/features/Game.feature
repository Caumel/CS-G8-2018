Feature: As a player I wanna play the game
	Scenario:  Stop the game
	    Given the game
        When I quit the game
    	Then The game stops

	Scenario: Play the game
		Given the game
		When game start
		Then The ball is created


