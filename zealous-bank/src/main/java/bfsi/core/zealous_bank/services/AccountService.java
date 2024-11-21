package bfsi.core.zealous_bank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bfsi.core.zealous_bank.entities.Account;
import bfsi.core.zealous_bank.entities.Customer;
import bfsi.core.zealous_bank.repositories.AccountRepository;
import bfsi.core.zealous_bank.repositories.CustomerRepository;

@Service
public class AccountService {
    @Autowired
    AccountRepository repository;
    @Autowired
    CustomerRepository repository2;
    public Account createAccount(int customerId,Account account){
        Customer customer = repository2.findById(customerId).orElseThrow(()->new RuntimeException("Customer Not Found"));
        System.out.println(customer.getCustomerName()+" found");
        account.setCustomer(customer);
        System.out.println(account);
        return repository.save(account);
    }
    public List<Account> readAccounts(){
        return repository.findAll();
    }
    public List<Account> readAccountsByCustomer(int customerId){
        return repository.findAllByCustomerCustomerId(customerId);
    }
}
