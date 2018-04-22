require 'capybara/cucumber'
require 'capybara'
require 'capybara/dsl'
require 'capybara/poltergeist'

Capybara.default_driver = :poltergeist #Install poltergeist
Capybara.register_driver :poltergeist do |app|
    options = {
        :js_errors => false,
        :timeout => 120,
        :debug => false,
        :phantomjs_options => ['--load-images=no','--disk-cache=false'],
        :inspector => true,
    }
    Capybara::Poltergeist::Driver.new(app,options)
end
Capybara.run_server = false
Capybara.default_selector = :css
Capybara.default_max_wait_time = 10
Capybara.ignore_hidden_elements = false
Capybara.exact = true
 
#Syncronization related settings
module Helpers
  def without_resynchronize
    page.driver.options[:resynchronize] = false
    yield
    page.driver.options[:resynchronize] = true
  end
end
World(Capybara::DSL, Helpers)