Feature: Definir los atributos ancho, largo y velocidad en los ejes X e Y de la clase bola
	As a player I wanna move the ball
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
				