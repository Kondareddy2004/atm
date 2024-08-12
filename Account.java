package atm.banking.com;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private String accountNumber;
    private double balance;
    private List<BankTransaction> transactionHistory;
    
 // Constructor
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    // Method to get account balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new BankTransaction("Deposit", amount));
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
            return false;
        }
        balance -= amount;
        transactionHistory.add(new BankTransaction("Withdrawal", -amount));
        return true;
    }

    // Method to transfer money from this account to another
    public boolean transfer(Account recipient, double amount) {
        if (withdraw(amount)) {
            recipient.deposit(amount);
            transactionHistory.add(new BankTransaction("Transfer", -amount));
            return true;
        }
        return false;
    }

    // Method to display transaction history
    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (BankTransaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}
