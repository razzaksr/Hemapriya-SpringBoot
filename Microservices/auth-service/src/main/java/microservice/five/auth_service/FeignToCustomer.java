package microservice.five.auth_service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="CUSTOMER-SERVICE")
public interface FeignToCustomer {
    // login call to customer> findByUsername>> getmapping
    @GetMapping("/customer/{username}")
    Optional<Customer> connectCustomerGetMapping(@PathVariable("username") String username);
    // signup call to customer> post mapping> post mapping
    @PostMapping("/customer/")
    Customer connectCustomerPostMapping(@RequestBody Customer customer);
}
