package transaction.bank.service;

import transaction.bank.bean.TransactionRQ;
import transaction.bank.bean.TransactionRS;

public interface TransactionService {
	
	TransactionRS insert(TransactionRQ transactionRQ);

}
