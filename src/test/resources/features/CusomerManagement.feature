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

  @CreateandDeleteCustomers
  Scenario Outline: As a User Able to Create and Delete Customer Data
    Then I Click on New Customer button
    And I enter a valid display name "<name>", Email "<email>", Billing Address "<billing_address>", and Shipping Address "<shipping_address>"
    Then Click Save
    Then I should view the saved customer in the Customers Table
    And Delete The Customer

    Examples: 
      | name  | email                                           | billing_address | shipping_address |
      | Bijan   | customer1@company.com | 111 Billing St.     | 456 Shipping St. |
      | Shav    | customer2@company.com | 444 Billing St.      | 789 Shipping St. |
      | Sam     | customer3@company.com | 777 Billing St.      | 123 Shipping St. |
