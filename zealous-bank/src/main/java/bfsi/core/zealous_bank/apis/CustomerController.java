package bfsi.core.zealous_bank.apis;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.Base64.Encoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bfsi.core.zealous_bank.entities.Customer;
import bfsi.core.zealous_bank.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService service;

    @DeleteMapping("/")
    public void apiDelete(@RequestBody Customer customer){
        service.deleteCustomer(customer);
    }

    @PutMapping("/")
    public Customer apiUpdate(@RequestBody Customer customer){
        return service.createCustomer(customer);
    }

    @GetMapping("/")
    public List<Customer> apiReadAll(){
        return service.listAllCustomers();
    }

    @GetMapping("/{username}")
    public Optional<Customer> apiReadOne(@PathVariable("username") String username){
        return service.readOneCustomer(username);
    }

    @PostMapping("/")
    public Customer apiCreate(@RequestBody Customer customer){
        String temp = Base64.getEncoder().encodeToString(customer.getPassword().getBytes());
        customer.setPassword(temp);
        return service.createCustomer(customer);
    }
}
