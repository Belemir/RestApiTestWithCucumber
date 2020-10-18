Feature: Patch feature
  Scenario: Update customer surname successfully
    Given content type is JSON
    When the user "belemir" sends a patch request with last name "mynewlastname"
    Then the user receives status code of 204 after patch request
    Then the user perform get operation
    And the user should see updated surname as "cilingir"