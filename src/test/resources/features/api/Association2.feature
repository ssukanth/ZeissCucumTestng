Feature: Testing The Endpoints  For The Assoication Service2


  @flat
  Scenario: CreateAssociation With Valid Data2
    And Service Authorized With The App token
    And Valid Association Payload Created
    When Association Posted
    Then Verify The Status Code for 200
    And Assciation Id Not Null
    
      @flat
  Scenario: CreateAssociation With Valid Da2
    And Valid Association Payload Created
    When Association Posted
    Then Verify The Status Code for 200
    And Assciation Id Not Null
