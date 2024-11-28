package bfsi.core.zealous_bank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bfsi.core.zealous_bank.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> findAllByTransactionFrom(long transactionFrom);
    List<Transaction> findAllByTransactionTo(long transactionTo);
}
