package microservice.one.customer_service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    @Autowired
    FeignToAccount feignToAccount;

    public Optional<Customer> readCustomerById(int customerId){
        return repository.findById(customerId);
    }

    // CRUD implementations of Customer
    public Customer createCustomer(Customer customer){
        return repository.save(customer);
    }
    public List<Customer> listAllCustomers(){
        List<Customer> fetched = repository.findAll();
        fetched.stream().map(obj->{
            obj.setMyAccounts(feignToAccount.receiveAccount(obj.getCustomerId()));
            return obj;
        }).collect(Collectors.toList());
        return fetched;
    }
    public Optional<Customer> readOneCustomer(String username){
        Optional<Customer> fetched = repository.findByUsername(username);
        fetched.stream().map(obj->{
            obj.setMyAccounts(feignToAccount.receiveAccount(obj.getCustomerId()));
            return obj;
        }).collect(Collectors.toList());
        return fetched;
    }
    public void deleteCustomer(Customer customer){
        repository.delete(customer);
    }
}
