package transaction.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import transaction.bank.bean.TransactionRQ;
import transaction.bank.bean.TransactionRS;
import transaction.bank.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionRS> insert(@RequestBody TransactionRQ transactionRQ) {
		TransactionRS transactionRS = transactionService.insert(transactionRQ);
		return new ResponseEntity<>(transactionRS, HttpStatus.OK);
	}
}
