Feature: Make diverse actions when i visit a video on youtube
	As user
	I want to be able to visit a video on youtube
	So that
    
  Background: Visit youtube
    Given i have visited youtube       
            
	Scenario: Press the expand button
		When i press the expand button
		Then the video is expanded

	Scenario: Press the pause button
		When i press the pause button
		Then the video pauses
            
  Scenario: Press the play button
		When i press the play button
		Then the video turn on
 
  Scenario: Press the mute button
		When i press the mute button
		Then the video is silenced
        
  Scenario: Press the subtitles button
		When press the subtitles button
		Then i can read the subtitles
        
        
