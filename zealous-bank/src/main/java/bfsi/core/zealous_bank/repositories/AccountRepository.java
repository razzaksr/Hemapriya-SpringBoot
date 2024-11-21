package bfsi.core.zealous_bank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bfsi.core.zealous_bank.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    List<Account> findAllByCustomerCustomerId(int customerId);
}
