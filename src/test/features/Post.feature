Feature: Post feature

  @SmokeTest
  Scenario: Post first name and last name to customers successfully
    Given content type is JSON
    When the user post firstname "belemir" and lastname "cilingir"
    Then the user receives status code of 201 after posting
    And the response body should contain customer firstname "belemir" and lastname "cilingir"

  Scenario: Post existing customer to receive conflict
    Given content type is JSON
    When the user post firstname "belemir" and lastname "cilingir"
    Then the user receives status code of 409 after posting