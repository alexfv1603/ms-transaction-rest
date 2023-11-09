package transaction.bank.bean;

import lombok.Getter;

@Getter
public class TransactionRQ {

	private String numberAccount;
	private String numberAccountDestination;
	private String typeTransaction;
	private double amount;
	
}
