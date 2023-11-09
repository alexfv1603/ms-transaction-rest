package transaction.bank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import transaction.bank.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String>{

}
