package features;

import bank.Bank;
import bank.BankAccount;
import io.cucumber.java8.En;
import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.*;

public class StepDefinitions implements En {
    private BankAccount bankAccount;
    private Bank bank;

    public StepDefinitions() {
        Given("a bank", () -> {
            bank = new Bank();
        });

        When("I open an account with {double} EUR", (Double amount) -> {
            bankAccount = bank.openBankAccount(amount);
        });

        Then("the account balance is {double} EUR", (Double amount) -> {
            assertThat(bankAccount.balance()).isEqualTo(amount);
        });

        Given("a bank account with a balance of {double} EUR", (Double amount) -> {
            bankAccount = BankAccount.withOpeningBalance(amount);
        });

        When("I deposit {double} EUR", (Double amount) -> {
            bankAccount.deposit(amount);
        });

        When("I withdraw {double} EUR", (Double amount) -> {
            bankAccount.withdraw(amount);
        });
    }
}