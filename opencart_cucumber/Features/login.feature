Feature: Login with valid credentials

  @sanity
  Scenario: Successful login with valid credentials
    Given user is on the login page
    When user enters email as "johndoe@gmail.com" and password "123@abc"
    And the user clicks on the login button
    Then user is redirected to the my account page
  #Scenario Outline: Login Data Driven
    #Given user is on the login page
    #When user enters email as "<email>" and password "<password>"
    #And the user clicks on the login button
    #Then user is redirected to the my account page
    #And user clicks logout
#
    #Examples: 
      #| email                | password |
      #| johndoe@gmail.com    | 123@abc  |
      #| cdeue39939@gmail.com | test@123 |
