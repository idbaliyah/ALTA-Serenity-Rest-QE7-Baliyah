Feature: Get single user
  @Tugas
  Scenario Outline: Get single user with valid id
    Given Get single user with valid id <id>
    When Send get single user request
    Then Status code should be 200 OK
    And Response body page single user should be <id>
    And Validate single user json schema validator
    Examples:
      | id |
      | 2  |
      | 3  |
      | 4  |

  @Tugas
  Scenario Outline: Get single user invalid ida/not found
    Given Get single user with valid id <id>
    When Send get single user request
    Then Status code should be 404 Not Found
    And Validate unknown user json schema validator
    Examples:
      | id |
      | 23 |
      | 20 |
      | 15 |