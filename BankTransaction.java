package atm.banking.com;

public class BankTransaction {
	private String type;
    private double amount;

    // Constructor
    public BankTransaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + ": $" + amount;
    }
}
