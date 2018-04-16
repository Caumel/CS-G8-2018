Feature: Realizar diversas acciones al visitar un video de youtube
	Como usuario
	Yo quiero poder visitar un video de youtube
	Para poder realizar diversas acciones
    
    Background: Visitar youtube
        Given que he visitado youtube       
            
	Scenario: Pulsar boton expandir
		When yo pulso el boton expandir
		Then se amplia el video

	Scenario: Pulsar boton pause
		When yo pulso el boton pause
		Then se pausa el video
            
    Scenario: Pulsar boton play
		When yo pulso el boton play
		Then se activa el video
 
    Scenario: Pulsar boton mute
		When yo pulso el boton mutear
		Then se silencia el video
        
    Scenario: Pulsar el boton subtitulos
		When pulso el boton de subtitulos
		Then puedo leer los subtitulos