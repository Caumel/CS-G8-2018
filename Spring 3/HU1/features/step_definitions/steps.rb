Given("que he visitado youtube") do
  visit 'https://www.youtube.com/watch?v=0ohR6IvezOU' 
  sleep(3)
end

When("yo pulso el boton expandir") do
  click_on(class: 'ytp-fullscreen-button ytp-button')
end

Then("se amplia el video") do
  sleep (5)
end

When("yo pulso el boton pause") do
  click_on(class: 'ytp-play-button ytp-button')
end

Then("se pausa el video") do
  sleep (5)
end

When("yo pulso el boton play") do
  click_on(class: 'ytp-play-button ytp-button')
end

Then("se activa el video") do
  sleep (5)
end

When("yo pulso el boton mutear") do
  click_on(class: 'ytp-mute-button ytp-button')
end

Then("se silencia el video") do
  sleep (5)
end

When("pulso el boton de subtitulos") do
  click_on(class: 'ytp-subtitles-button ytp-button')
end

Then("puedo leer los subtitulos") do
  sleep (5)
end
