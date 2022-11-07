Feature: Post register success
  @Tugas
  Scenario: Post register user success with valid json
    Given Post register with valid json
    When Send post register request
    Then Status code should be 200 Success
    And Response body should by token "QpwL5tke4Pnpja7X4"
    And Validate register success json schema validator

