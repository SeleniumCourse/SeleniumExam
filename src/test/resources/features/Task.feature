Feature: Tasks

  Scenario: Add a Quick Task
    Given I login as Primary User
    When I create a Quick Task :
      | task_name | Testing |
      | priority  | 3       |
      | project   | Errands |