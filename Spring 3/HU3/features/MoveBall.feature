Feature: As a player I wanna move the ball properly
	Scenario: Definir atributos de la clase bola
		Given the ball
		When game start
		Then I can move the ball up

	Scenario: Definir atributos de la clase bola
		Given the ball
		When game start
		Then I can move the ball down

	Scenario: Definir atributos de la clase bola
		Given the ball
		When game start
		Then the ball doesn't move by its own

	Scenario: Definir atributos de la clase bola
		Given the ball
		When game start
		Then I can't move the ball to the left

	Scenario: Definir atributos de la clase bola
		Given the ball
		When game start
		Then I can't move the ball to the right
				