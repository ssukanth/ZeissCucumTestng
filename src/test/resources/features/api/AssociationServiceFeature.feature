
Feature: Testing The Endpoints  For The Assoication Service


  @api
  Scenario: CreateAssociation With Valid Data
    And Service Authorized With The App token
    And Valid Association Payload Created
    When Association Posted
    Then Verify The Status Code for 200
    And Assciation Id Not Null
    
      @api
  Scenario: CreateAssociation With Valid Dat
    And Service Authorized With The App token
    And Valid Association Payload Created
    When Association Posted
    Then Verify The Status Code for 200
    And Assciation Id Not Null


 