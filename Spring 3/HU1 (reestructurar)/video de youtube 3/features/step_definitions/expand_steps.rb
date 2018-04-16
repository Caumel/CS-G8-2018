#Visit the video in youtube
Given("que he visitado youtube") do
  visit 'https://www.youtube.com/watch?v=0ohR6IvezOU' 
end

When("yo pulso el boton expandir") do
  click_on(class: 'ytp-fullscreen-button ytp-button')
end

Then("se amplia el video") do
  sleep (5)
end
