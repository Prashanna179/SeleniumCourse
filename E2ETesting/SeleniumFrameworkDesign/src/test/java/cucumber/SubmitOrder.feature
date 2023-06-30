
@tag
Feature: Purchase the order from Ecommerce Website 
  I want to use this template for my feature file

	Background: 
	Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive test of Submitting Order
   
    Given Logged in with username <username> and password <password>
    When I add product <productName> to cart 
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed in Confirmation Page

    Examples: 
      | username              | password         | productName  |
      | prashannarg@gmail.com | Password@179     | zara coat 3  |
   		
