package transaction.bank.model;

import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
	
	private String id;
	@DBRef
	private Client client;
	@DBRef
	private Product product;
	private String numberAccount;
	private double balance;

}
