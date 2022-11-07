Feature: Reqres Feature
  @Latihan
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with parameter page <page>
    When Send get list user request
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate user json schema validator
    Examples:
      | page |
      | 1    |
      | 2    |

    @Latihan
    Scenario: Post create new user with valid json
      Given Post create user with valid json
      When Send post create user request
      Then Status code should be 201 Created
      And Response body should contain name "Baliyah" and job "QA Engineer"

    @Latihan
    Scenario Outline: Put update user with valid json
      Given Put update user with valid json <id>
      When Send put update user request
      Then Status code should be 200 OK
      And Response body should contain name "idbaliyah" and job "QA Engineer"
      Examples:
        | id |
        | 1  |
        | 2  |

  @Latihan
  Scenario Outline: Delete user with valid id
    Given Delete user with id <id>
    When Send delete user request
    Then Status code should be 204 no content
    Examples:
      | id |
      | 1  |
      | 2  |