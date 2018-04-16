#Visit the video in youtube
Given("que he visitado youtube") do
  visit 'https://www.youtube.com/watch?v=0ohR6IvezOU' 
  sleep(3)
end

When("yo pulso el boton pause") do
  click_on(class: 'ytp-play-button ytp-button')
end

Then("se pausa el video") do
  sleep (5)
end
