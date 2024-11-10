import java.time.LocalDateTime;

public class Transaction {
    private String transactionType;
    private double amount;
    private String accountId;
    private LocalDateTime timestamp;

    public Transaction(String transactionType, double amount, String accountId) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.accountId = accountId;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("Transaction type=%s, amount=%.2f, account=%s, timestamp=%s]",
                transactionType, amount, accountId, timestamp);
    }
}
