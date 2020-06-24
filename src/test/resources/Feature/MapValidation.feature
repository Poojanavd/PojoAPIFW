Feature: Validating Place API

  @tag1
  Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI
    Given Add place payload with "<name>"
    When user call "AddPlaceAPI" with "POST" http request
    Then the api call got success with status code "200"
    And "status" in response body is "OK"
#    And Verify place_Id created maps to "<name>" using "GetPlaceAPI"
    
    Examples:
    |name| AAHouse|
 