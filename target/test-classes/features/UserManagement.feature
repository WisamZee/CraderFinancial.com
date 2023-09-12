@UserManagement
Feature: User Management
  I want to use this feature for my Invalid Test file

  @InvalidPasswordLogin
  Scenario: The User should be Unable to Login with Invalid Credentials.
    Given There are Tow "Field is required" Messages Display.
    When I enter a Valid Email and an Invalid Password.
    And Click on the login button
    Then I can see that an Error Message "These credentials do not match our records." Displays
    
   @invalidEmailLogin
  Scenario: Invalid email login attempts
    Given As a user, I am on the login page
    When I enter invalid username and valid password
    And Click on login button
    Then I should see an error message "These credentials do not match our records." displays
    And I should not be logged in
    
    