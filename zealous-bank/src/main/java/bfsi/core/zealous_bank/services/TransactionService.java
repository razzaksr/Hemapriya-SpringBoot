package bfsi.core.zealous_bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bfsi.core.zealous_bank.entities.Transaction;
import bfsi.core.zealous_bank.repositories.AccountRepository;
import bfsi.core.zealous_bank.repositories.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    @Autowired
    private AccountRepository accountRepository;
    boolean isDone=false;

    public Transaction logTransaction(Transaction transaction){
        accountRepository.findAll().forEach(v->{
            if(transaction.getTransactionFrom()==v.getAccountNumber()&&
            transaction.getTransactionFrom()!=transaction.getTransactionTo()){
                if(transaction.getTransactionAmount()<=v.getAccountBalance()){
                    transaction.setTransactionStatus("Success");
                    repository.save(transaction);
                    isDone=true;
                }
                else{
                    throw new RuntimeException("Transaction failed due to insufficient balance");
                }
            }
        });
        if(isDone)
            return transaction;
        else
            throw new RuntimeException("Transaction Failed due to account was not present");
    }
}
