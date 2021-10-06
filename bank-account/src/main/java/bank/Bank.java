package bank;

public class Bank {
    public BankAccount openBankAccount(Double double1) {
        return BankAccount.withOpeningBalance(double1);
    }
}
