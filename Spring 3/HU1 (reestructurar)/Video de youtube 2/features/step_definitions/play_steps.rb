Given("que he visitado youtube") do
  visit 'https://www.youtube.com/watch?v=0ohR6IvezOU' 
  sleep(3)
end

When("yo pulso el boton play") do
  click_on(class: 'ytp-play-button ytp-button')
    sleep(3)
  click_on(class: 'ytp-play-button ytp-button')
end

Then("se activa el video") do
  sleep (3)
end