#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Checking Login feature
  
  Background: Webdriver is Initialized
  Given WebDriver type
  When Intilialised driver
  

  @group1
  Scenario: Check reset button
    Given details of username and password
    |learn|ittools|
     When clicked on reset button with details
     Then fields are check for emptiness
    When clicked on Reset button
   Then fields are check for emptiness

@group2
Scenario Outline: check for submit button
Given <username> and <password>
When clicked on submit
Then validation is <status>

Examples:
|username         |password                   |status|
|"learn"          |"learnit@gmail.com"        |"true"|
|"123456"         |"learnit@gmail.com"        |"true"|
|"learn"          |"learn"                    |"true"|
|"learnnnnnnnnnnn"|"larn@gmail.commmmmmmmmmmm"|"true"|
|"LearnSelenium"  |"LearnSelenium"            |"false"|
 
