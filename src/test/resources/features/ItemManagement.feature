@ItemManagement
Feature: Item Management
 
@createItem
  Scenario: As a user I am able to create an item or a service
    Given As an entity user, I am logged in
    And I navigate to Items tab
    When I click on the Add Item button
    And I should be on item input page
    When I provide item information name "White Coffee"  price "1500"  unit "pc"  and description "a good Coffee"
    And I click Save Item button
    Then The Item is added to the Item list table
    And I delete the item
    
    
    @editItem
    Scenario: As a user I am able to update an item or a service
    Given As an entity user, I am logged in
    And I navigate to Items tab
    When I click on the Add Item button
    And I should be on item input page
    When I provide item information name "White Coffee"  price "1500"  unit "pc"  and description "a good Coffee"
    And I click Save Item button
    Then The Item is added to the Item list table
    Then I click on Edit button
    
    And I delete the item