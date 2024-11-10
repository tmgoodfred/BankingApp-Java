public class BankService {

    public boolean transfer(Account source, Account target, double amount) {
        synchronized (source) {
            synchronized (target) {
                if (source.withdraw(amount)) {
                    if (target.deposit(amount)) {
                        System.out.printf("Transferred %.2f from %s to %s%n", amount, source.getAccountId(), target.getAccountId());
                        return true;
                    } else {
                        System.out.println("Deposit to target account failed. Rolling back transfer.");
                        // Attempt rollback if deposit fails
                        source.deposit(amount);  // Rollback by re-depositing to source
                    }
                } else {
                    System.out.println("Transfer failed due to insufficient funds or other issues.");
                }
            }
        }
        return false;
    }
}
