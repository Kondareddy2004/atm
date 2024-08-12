package atm.banking.com;

public class AccountHolder {
	private String userId;
    private String pin;
	public AccountHolder(String userId, String pin) {
		super();
		this.userId = userId;
		this.pin = pin;
	}
	// Method to check if provided user ID and PIN are correct
    public boolean authenticate(String userId, String pin) {
        return this.userId.equals(userId) && this.pin.equals(pin);
    }
}
