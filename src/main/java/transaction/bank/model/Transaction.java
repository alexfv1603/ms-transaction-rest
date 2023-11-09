package transaction.bank.model;

import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Transaction {
	
	@DBRef
	private Account account;
	private String typeTransaction;
	private double amount;

}
