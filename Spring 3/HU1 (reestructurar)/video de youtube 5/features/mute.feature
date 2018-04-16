Feature: Pulsar el boton de mutear y silenciar el video
	Como usuario
	Yo quiero poder pulsar el boton mute
	Para dejar de escuchar el video
	Scenario: Pulsar boton like
		Given que he visitado youtube
		When yo pulso el boton mutear
		Then se silencia el video