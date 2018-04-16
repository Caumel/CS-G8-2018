#Visit the video in youtube
Given("que he visitado youtube") do
  visit 'https://www.youtube.com/watch?v=0ohR6IvezOU' 
  sleep(3)
end

When("yo pulso el boton mutear") do
  click_on(class: 'ytp-mute-button ytp-button')
end

Then("se silencia el video") do
  sleep (5)
end