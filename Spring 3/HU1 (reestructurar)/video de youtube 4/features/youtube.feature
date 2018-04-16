Feature: Pulsar el boton de subtitulos y activar los subtitulos para poder leerlos
	Como usuario
	Yo quiero poder pulsar el boton de subtitulos
	Para asi poder leer los subtitulos
	Scenario: Pulsar el boton subtitulos
		Given que he visitado youtube
		When pulso el boton de subtitulos
		Then puedo leer los subtitulos
