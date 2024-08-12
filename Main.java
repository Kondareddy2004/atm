package atm.banking.com;

public class Main {
	public static void main(String[] args) {
        // Create an account holder
        AccountHolder accountHolder = new AccountHolder("user123", "1234");

        // Create an account
        Account account = new Account("123456789", 1000.0);

        // Create an ATM
        ATM atm = new ATM(accountHolder, account);

        // Start ATM operations
        atm.start();
    }
}
