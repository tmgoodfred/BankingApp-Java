import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountId;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public synchronized boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return false;
        }
        balance += amount;
        transactionHistory.add(new Transaction("DEPOSIT", amount, accountId));
        System.out.printf("Deposited %.2f. New balance: %.2f%n", amount, balance);
        return true;
    }

    public synchronized boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("WITHDRAWAL", amount, accountId));
            System.out.printf("Withdrew %.2f. New balance: %.2f%n", amount, balance);
            return true;
        } else {
            System.out.println("Insufficient funds or invalid amount.");
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public String getAccountId() {
        return accountId;
    }
}
