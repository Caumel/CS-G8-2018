Given("i have visited youtube") do
    visit 'https://www.youtube.com/watch?v=0ohR6IvezOU' 
    sleep(3)
end

When("i press the expand button") do
    click_on(class: 'ytp-fullscreen-button ytp-button')
end

Then("the video is expanded") do
    sleep (3)
end

When("i press the pause button") do
    click_on(class: 'ytp-play-button ytp-button')
end

Then("the video pauses") do
    sleep (3)
end

When("i press the play button") do
    click_on(class: 'ytp-play-button ytp-button')
    sleep(3)
    click_on(class: 'ytp-play-button ytp-button')
end

Then("the video turn on") do
    sleep (3)
end

When("i press the mute button") do
    click_on(class: 'ytp-mute-button ytp-button')
end

Then("the video is silenced") do
    sleep (5)
end

When("press the settings button") do
    click_on(class: 'ytp-button ytp-settings-button')
end

Then("i can read the settings") do
    sleep (5)
end
