package microservice.two.account_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository repository;
    
    public Account createAccount(Account account){
        return repository.save(account);
    }
    public List<Account> readAccounts(){
        return repository.findAll();
    }
    public List<Account> readAccountsByCustomer(int customerId){
        return repository.findAllByCustomer(customerId);
    }
}
