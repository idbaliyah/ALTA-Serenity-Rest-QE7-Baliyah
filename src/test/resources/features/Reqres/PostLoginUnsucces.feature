Feature: Post login unsuccessful
  @Tugas
  Scenario: Post login user unsuccessful with valid json
    Given Post login with valid json
    When Send post login request
    Then Status code should be 400 Unsuccessful
    And Response body should by error "Missing password"
    And Validate login user unsuccessful json schema validator