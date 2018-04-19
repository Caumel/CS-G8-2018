Feature: Move the bat properly in diferent situations
    As a player
    I wanna move the bat properly
    So that
    
    Background: game start
        Given the bat
		When game start
        
	Scenario: Move bat up
		Then I can move the bat up from 540:897 to 740:897

	Scenario: Move bat down
		Then I can move the bat down 540:897 to 340:897

	Scenario: Bat doesn't do what it wants
		Then the bat doesn't move by its own

	Scenario: Move bat to the left
		Then I can't move the bat to the left 540:897 to 540:1197

	Scenario: Move bat to the right
		Then I can't move the bat to the right 540:897 to 540:697
				