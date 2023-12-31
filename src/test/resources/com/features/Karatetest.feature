
Feature: Testing Reqres.in Endpoints

 Scenario: Get a single user
    Given path '/users/2'
    When method GET
    Then status 200
    And match response.data.id == 2
    And match response.data.first_name == 'Janet'
    And match response.data.last_name == 'Weaver'
    
    
Scenario: Get a single user not found
    Given path '/users/23'
    When method GET
    Then status 404
   
    
 Scenario: Create a new user
    Given path '/users'
    And request { "name": "morpheus" ,"job": "leader","id": "149", }
    When method POST
    Then status 201
    And match response.name == 'morpheus'
    And match response.job == 'leader'
    And match response.id == '149'
    
    Scenario: Update user's job
    Given path '/users/2'   
    And request { "name": "morpheus" }
    When method PUT
    Then status 200
    And match response.name == 'morpheus'

  Scenario: Delete a user
    Given path '/users/2'
    When method DELETE
    Then status 204


