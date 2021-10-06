Feature: Bank Account

  Scenario: Open a bank account
    Given a bank
    When I open an account with 1.00 EUR
    Then the account balance is 1.00 EUR

  Scenario: Deposit money
    Given a bank account with a balance of 1.00 EUR
    When I deposit 100.00 EUR
    Then the account balance is 101.00 EUR

  Scenario: Withdraw money
    Given a bank account with a balance of 100.00 EUR
    When I withdraw 50.00 EUR
    Then the account balance is 50.00 EUR