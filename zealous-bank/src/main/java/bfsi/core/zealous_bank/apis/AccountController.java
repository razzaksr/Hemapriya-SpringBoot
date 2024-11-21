package bfsi.core.zealous_bank.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bfsi.core.zealous_bank.entities.Account;
import bfsi.core.zealous_bank.services.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService service;

    @GetMapping("/{customerId}")
    public List<Account> apiReadCustomer(@PathVariable("customerId") int customerId){
        return service.readAccountsByCustomer(customerId);
    }

    @GetMapping("/")
    public List<Account> apiReadAll(){
        return service.readAccounts();
    }

    @PostMapping("/{customer}")
    public Account apiCreate(@PathVariable("customer") int customer,@RequestBody Account account){
        System.out.println("REceived Customer "+customer+" "+account.getAccountNumber());
        return service.createAccount(customer,account);
    }
}
