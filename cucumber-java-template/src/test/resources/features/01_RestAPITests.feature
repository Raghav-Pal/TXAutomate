Feature: Organisation SignUp API Test

  @APItests
  Scenario: 10000_Create a new user with valid data
    Given Read "Testcase1" from Testdata file required to create a user
    And I set the content type and body
    When I post the create user data to the api
    Then I verify the status as "200"
    And I verify the json response

  @APItests
  Scenario: 10001_Create a new user with invalid data
    Given Read "Testcase2" from Testdata file required to create a user
    And I set the content type and body
    When I post the create user data to the api
    Then I verify the status as "400"
    And I verify the json response

  @APItestsSmoke
  Scenario: 10000_Create a new user with valid data
    Given Read "Testcase1" from Testdata file required to create a user
    And I set the content type and body
    When I post the create user data to the api
    Then I verify the status as "200"
    And I verify the json response

  @APItestsAcceptance
  Scenario: 10000_Create a new user with valid data
    Given Read "Testcase1" from Testdata file required to create a user
    And I set the content type and body
    When I post the create user data to the api
    Then I verify the status as "200"
    And I verify the json response
