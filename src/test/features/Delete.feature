Feature: Delete feature

  Scenario: Delete customer successfully
    Given the user sends delete request for customer "belemir"
    Then the user receives status code of 204 after deleting