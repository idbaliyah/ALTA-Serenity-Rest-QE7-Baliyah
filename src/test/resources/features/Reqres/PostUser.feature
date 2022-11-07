Feature: Post user
  @Tugas
  Scenario: Post create new user with valid json
    Given Post task create user with valid json
    When Send post create user request
    Then Status code should be 201 Created
    And Response body should contain name "morpheus" and job "leader"
    And Validate post task json schema validator