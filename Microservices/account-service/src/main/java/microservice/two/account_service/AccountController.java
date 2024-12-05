package microservice.two.account_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/")
    public Account apiCreate(@RequestBody Account account){
        return service.createAccount(account);
    }
}
