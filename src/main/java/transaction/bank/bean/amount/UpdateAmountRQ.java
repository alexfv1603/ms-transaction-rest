package transaction.bank.bean.amount;

public class UpdateAmountRQ {

	private String numberAccount;
	private String numberAccountDestination;
	private String transaction;
	private double amount;
	
	public String getNumberAccount() {
		return numberAccount;
	}
	public void setNumberAccount(String numberAccount) {
		this.numberAccount = numberAccount;
	}
	public String getNumberAccountDestination() {
		return numberAccountDestination;
	}
	public void setNumberAccountDestination(String numberAccountDestination) {
		this.numberAccountDestination = numberAccountDestination;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
