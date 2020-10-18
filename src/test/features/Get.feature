Feature: Get feature
  @SmokeTest
  Scenario: Get customer first name and last name from customers service successfully
    When the client calls customer "belemir"
    Then the user receives status code of 200
    And the response body should contain customer name
