@CustomerManagement
Feature: Customer Management

  Background: 
    Given As an entity user, I am logged in
    When i navigate to the customers tab

  @NewCustomerBtn
  Scenario: As a user when I navigate to the Customers Tab I should see New customer button
    Then I should see the New Customer button displayed
    And I Click on New Customer button
    Then customer should see that a Basic info form label is present

  @NewCustomerBasicInfoField
  Scenario: As a user when I Click on new Customers button I should see Basic info Fields
    And I Click on New Customer button
    Then customer should see that a Basic info form label is present
    And I should see the Fields Display Name,  Primary Contact Name, Email, Primary Currency, Website, and Prefix

  @newCustomerTableList
  Scenario: As a user when I navigate to the Customers Tab, I should see the Customers Table List
    Then I should see the Customer List Table

  @newCustomerCreatedMessage
  Scenario: As a user when I navigate to the Customers Tab and try creating a new customer without passing any info, I should get an error
    And I Click on New Customer button
    Then I Enter a display Name
    And Click Save
    Then I should see The PopUp Message "Customer Created Succefully"
    And Delete The Customer

  @newCustomerCreatedMessageFieldIsRequired
  Scenario: As a user when I navigate to the Customers Tab and try creating new Customer without any Info
    Then I Click on New Customer button
    And Click Save
    Then I should see the error massage "Field is required" below the Name Field

  @newCustomers
  Scenario Outline: As a user, when I create a new customer I should see them in the customers table
    And I Click on New Customer button
    When I enter a valid "<Display Name>", "<Email>", "<State>", "<City>", and "<Zipcode>"
    And click save
    Then I should see the new customer in the data table
    And I delete the customer

    Examples: 
      | Display Name | Email              | State | City          | Zipcode |
      | Student1     | student1@gmail.com | VA    | Fairfax       |   12345 |
      | Student2     | student2@gmail.com | MD    | Rockville     |   00000 |
      | Student3     | student3@gmail.com | CA    | Orange County |   54321 |

  @newCustomerFormErrorMessages
  Scenario Outline: As a user when I create a new customer, I should provide a valid display name and email
    And I Click on New Customer button
    When I enter invalid informatin: display name "<name>" and email "<email>"
    Then I should see the appropriate error message

    Examples: 
      | name    | email             |
      | ab      | student@gmail.com |
      |         | student@gmail.com |
      | student | email             |
