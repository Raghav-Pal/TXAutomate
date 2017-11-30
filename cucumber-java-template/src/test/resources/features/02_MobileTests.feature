Feature: Assigned Tasks Validation

  @MobileTest
  Scenario: 10002_Validate the past assigned tasks with valid credentials
    Given I login to application with username "07704263440"
    And I navigate to My Agenda screen
    When I sync the tasks on My Agenda screen
    And I navigate to available past tasks
    Then I verify all the task details and description available

  @MobileTest
  Scenario: 10003_Validate the past assigned tasks with invalid credentials
    Given I login to application with username "wrong username"
    And I navigate to My Agenda screen
    When I sync the tasks on My Agenda screen
    And I navigate to available past tasks
    Then I verify all the task details and description available

  @MobileTestSmoke
  Scenario: 10002_Validate the past assigned tasks with valid credentials
    Given I login to application with username "07704263440"
    And I navigate to My Agenda screen
    When I sync the tasks on My Agenda screen
    And I navigate to available past tasks
    Then I verify all the task details and description available

  @MobileTestAcceptance
  Scenario: 10002_Validate the past assigned tasks with valid credentials
    Given I login to application with username "07704263440"
    And I navigate to My Agenda screen
    When I sync the tasks on My Agenda screen
    And I navigate to available past tasks
    Then I verify all the task details and description available
