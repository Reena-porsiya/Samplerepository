public class BankAccount {
    private String accountNumber;
    private double balance;
    
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid amount. Deposit amount must be greater than 0.");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Invalid amount. Withdrawal amount must be greater than 0 and less than or equal to the balance.");
        }
    }
}

public class DataHidingExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("1234567890", 1000);
        
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: $" + account.getBalance());
        
        account.deposit(500);
        account.withdraw(200);
        
        System.out.println("Balance after transactions: $" + account.getBalance());
    }
}