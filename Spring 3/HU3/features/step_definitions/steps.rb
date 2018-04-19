require 'calabash-android/calabash_steps'
Given("the bat") do
    sleep(1)
end

When("game start") do
    sleep(2)
end

Then("I can move the bat up from {int}:{int} to {int}:{int}") do |int, int2, int3, int4|
    perform_action('drag', int , int3 , int2 , int4 , 20)
    sleep(2)
end

Then("I can move the bat down {int}:{int} to {int}:{int}") do |int, int2, int3, int4|
    perform_action('drag', int , int3 , int2 , int4 , 20)
    sleep(2)
end

Then("the bat doesn't move by its own") do
    sleep(5)
end

Then("I can't move the bat to the left {int}:{int} to {int}:{int}") do |int, int2, int3, int4|
    perform_action('drag', int , int3 , int2 , int4 , 20)
    sleep(2)
end

Then("I can't move the bat to the right {int}:{int} to {int}:{int}") do |int, int2, int3, int4|
    perform_action('drag', int , int3 , int2 , int4 , 20)
    sleep(2)
end