package bfsi.core.zealous_bank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bfsi.core.zealous_bank.entities.Customer;
import bfsi.core.zealous_bank.repositories.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;

    public Optional<Customer> readCustomerById(int customerId){
        return repository.findById(customerId);
    }

    // CRUD implementations of Customer
    public Customer createCustomer(Customer customer){
        return repository.save(customer);
    }
    public List<Customer> listAllCustomers(){
        return repository.findAll();
    }
    public Optional<Customer> readOneCustomer(String username){
        return repository.findByUsername(username);
    }
    public void deleteCustomer(Customer customer){
        repository.delete(customer);
    }
}
