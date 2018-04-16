Given("que he visitado youtube") do
  visit 'https://www.youtube.com/watch?v=0ohR6IvezOU' 
  sleep(3)
end

When("pulso el boton de subtitulos") do
    click_on(class: 'ytp-subtitles-button ytp-button')
end

Then("puedo leer los subtitulos") do
  sleep (5)
end