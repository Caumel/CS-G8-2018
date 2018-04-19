Feature: Move the ball properly in diferent situations
    As a player
    I wanna move the ball properly
    So that
    
    Background: game start
        Given the ball
		When game start
        
	Scenario: Move ball up
		Then I can move the ball up

	Scenario: Move ball down
		Then I can move the ball down

	Scenario: Ball doesn't do what it wants
		Then the ball doesn't move by its own

	Scenario: Move ball to the left
		Then I can't move the ball to the left

	Scenario: Move ball to the right
		Then I can't move the ball to the right
				