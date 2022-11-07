Feature: Task put update user
  @Tugas
  Scenario Outline: Task Put update user with valid json
    Given Task put update user with valid json <id>
    When Send put update user request
    Then Status code should be 200 OK
    And Response body should contain name "morpheus" and job "zion resident"
    And Validate task put json schema validator
    Examples:
      | id |
      | 20 |
      | 40 |