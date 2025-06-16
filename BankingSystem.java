

abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    // Constructor to initialize account number and balance
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ". New balance: " + balance);
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". New balance: " + balance);
        }
    }

    // Abstract method to calculate interest
    public abstract void calculateInterest();
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor to initialize Savings Account with interest rate
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    // Override the calculateInterest method to calculate interest for savings account
    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        System.out.println("Interest on Savings Account: " + interest);
    }
}

// CurrentAccount subclass
class CurrentAccount extends BankAccount {
    private double minimumBalance;

    // Constructor to initialize Current Account with a minimum balance
    public CurrentAccount(String accountNumber, double balance, double minimumBalance) {
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;
    }

    // Override the calculateInterest method for current account (no interest)
    @Override
    public void calculateInterest() {
        System.out.println("No interest for Current Accounts.");
    }

    // Override the withdraw method to check for minimum balance
    @Override
    public void withdraw(double amount) {
        if (balance - amount < minimumBalance) {
            System.out.println("Cannot withdraw! Minimum balance of " + minimumBalance + " must be maintained.");
        } else {
            super.withdraw(amount);
        }
    }
}

// Main class to test the banking system
public class BankingSystem {
    public static void main(String[] args) {
        // Create a Savings Account
        SavingsAccount savingsAccount = new SavingsAccount("12345", 5000, 0.05);
        savingsAccount.deposit(2000);
        savingsAccount.withdraw(1000);
        savingsAccount.calculateInterest();

        // Create a Current Account
        CurrentAccount currentAccount = new CurrentAccount("67890", 2000, 1000);
        currentAccount.deposit(500);
        currentAccount.withdraw(1500);  // Should work
        currentAccount.withdraw(2000);  // Should fail due to minimum balance check
        currentAccount.calculateInterest();
    }
}