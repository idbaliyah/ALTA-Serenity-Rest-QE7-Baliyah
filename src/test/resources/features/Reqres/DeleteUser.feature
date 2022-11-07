Feature: Get single user
  @Tugas
  Scenario Outline: Delete user with valid id
  Given Task delete user with id <id>
  When Send task delete user request
  Then Status code should be 204 no content
  Examples:
    | id |
    | 9  |
    | 10 |