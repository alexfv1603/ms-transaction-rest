package transaction.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transaction.bank.bean.TransactionRQ;
import transaction.bank.bean.TransactionRS;
import transaction.bank.bean.amount.UpdateAmountRQ;
import transaction.bank.bean.amount.UpdateAmountRS;
import transaction.bank.model.Account;
import transaction.bank.model.Transaction;
import transaction.bank.repository.TransactionRepository;
import transaction.bank.rest.AccountRest;
import transaction.bank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountRest accountRest;

	@Override
	public TransactionRS insert(TransactionRQ transactionRQ) {
		TransactionRS transactionRS = new TransactionRS();
		
		try {
			UpdateAmountRQ updateAmountRQ = new UpdateAmountRQ();
			updateAmountRQ.setNumberAccount(transactionRQ.getNumberAccount());
			updateAmountRQ.setNumberAccountDestination(transactionRQ.getNumberAccountDestination());
			updateAmountRQ.setAmount(transactionRQ.getAmount());
			updateAmountRQ.setTransaction(transactionRQ.getTypeTransaction());
			
			UpdateAmountRS updateAmountRS = accountRest.updateAmount(updateAmountRQ);
			
			if(updateAmountRS != null) {
				if(updateAmountRS.isStatus()) {
					Transaction transaction = new Transaction();
					transaction.setAccount(new Account());
					transaction.getAccount().setId(updateAmountRS.getAccountId());
					transaction.setTypeTransaction(transactionRQ.getTypeTransaction());
					transaction.setAmount(transactionRQ.getAmount());
					
					transactionRepository.save(transaction);
					
					transactionRS.setStatus(true);
					transactionRS.setMessage("Se registró la transacción");
					
					return transactionRS;
				}
			}
			transactionRS.setStatus(false);
			transactionRS.setMessage("No se registró la transacción");
			
		} catch (Exception e) {
			transactionRS.setStatus(false);
			transactionRS.setMessage(e.getMessage());
		}
		
		return transactionRS;
	}

}
