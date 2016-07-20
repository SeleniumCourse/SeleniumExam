Feature: Tasks

  Scenario: Add a Quick Task
    Given I login as Primary User
    When I create a Quick Task :
      | task_name | Testing |
      | project   | Errands |
#      | priority  | 3       |
#    Then I verify all fields
    Then I verify fields:
      | task_name | Testing |
      | project   | Errands |