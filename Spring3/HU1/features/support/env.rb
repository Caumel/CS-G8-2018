require 'capybara/cucumber'
require 'capybara'
require 'capybara/dsl'

Capybara.run_server = false
Capybara.default_driver = :selenium
Capybara.javascript_driver = :selenium
Capybara.default_selector = :css
Capybara.default_max_wait_time = 10
Capybara.ignore_hidden_elements = false
Capybara.exact = true

Capybara.register_driver :selenium do |app|
Capybara::Selenium::Driver.new(app, :browser => :chrome)
    #,:driver_path => 'C:\Users\Luisc\Downloads\chromedriver.exe'
end

 
#Syncronization related settings
module Helpers
  def without_resynchronize
    page.driver.options[:resynchronize] = false
    yield
    page.driver.options[:resynchronize] = true
  end
end
World(Capybara::DSL, Helpers)