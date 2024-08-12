package atm.banking.com;

import java.util.Scanner;

public class ATM {
	private AccountHolder accountHolder;
    private Account account;

    // Constructor
    public ATM(AccountHolder accountHolder, Account account) {
        this.accountHolder = accountHolder;
        this.account = account;
    }

    // Method to start ATM operations
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (accountHolder.authenticate(userId, pin)) {
            System.out.println("Authentication successful");
            showOptions();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Your balance is: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful");
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful");
                    }
                    break;
                case 4:
                    System.out.print("Enter recipient's account number: ");
                    String recipientAccountNumber = scanner.next();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    // Assuming recipient's account is in the same bank for simplicity
                    Account recipientAccount = new Account(recipientAccountNumber, 0);
                    if (account.transfer(recipientAccount, transferAmount)) {
                        System.out.println("Transfer successful");
                    }
                    break;
                case 5:
                    account.displayTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        } else {
            System.out.println("Authentication failed");
        }
        scanner.close();
    }

    // Method to display ATM options
    private void showOptions() {
        System.out.println("\nOptions:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Show Transaction History");
        System.out.println("6. Quit");
        System.out.print("Enter your choice: ");
    }
}
