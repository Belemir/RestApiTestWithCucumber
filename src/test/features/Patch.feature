Feature: Patch feature

  Scenario: Update customer surname successfully
    Given content type is JSON
    When the user "belemir" sends a patch request with last name "mysurname"
    Then the user receives status code of 204 after patch request
    Then the user perform get operation for customer "belemir"
    And the user should see updated surname as "mysurname"

  Scenario: Response body should display not found message when non existing customer entered
    Given content type is JSON
    When the user "belenay" sends a patch request with last name "mysurname"
    Then the user receives status code of 404 after patch request
    And the response body should contain code "Customer_not_found_with_given_first_name"
