
@tag
Feature: Error validation
  I want to use this template for my feature file

	
	Background:
	Given I landed on Ecommerce Page
	
  @ErrorValidation
  Scenario Outline: Title of your scenario outline
   
    Given Logged in with username <username> and password <password>
    Then "Incorrect email or password." is displayed

   Examples: 
      | username              | password         | 
      | prashannarg@gmail.com | Password@17    	 |
