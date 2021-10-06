package bank;

public class BankAccount {
    private double balance;

    private BankAccount(Double amount) {
        this.balance = amount;
    }

    public static BankAccount withOpeningBalance(Double amount) {
        return new BankAccount(amount);
    }

    public double balance() {
        return this.balance;
    }

    public void deposit(Double amount) {
        this.balance += amount;
    }

    public void withdraw(Double amount) {
        this.balance -= amount;
    }
}
