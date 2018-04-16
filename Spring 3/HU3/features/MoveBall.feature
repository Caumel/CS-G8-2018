Feature: As a player I wanna move the ball properly
	Scenario: Move ball up
		Given the ball
		When game start
		Then I can move the ball up

	Scenario: Move ball down
		Given the ball
		When game start
		Then I can move the ball down

	Scenario: Ball doesn't do what it wants
		Given the ball
		When game start
		Then the ball doesn't move by its own

	Scenario: Move ball to the left
		Given the ball
		When game start
		Then I can't move the ball to the left

	Scenario: Move ball to the right
		Given the ball
		When game start
		Then I can't move the ball to the right
				