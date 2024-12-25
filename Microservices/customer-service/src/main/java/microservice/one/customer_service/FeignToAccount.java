package microservice.one.customer_service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @FeignClient(name="feign",url = "http://localhost:8092")
@FeignClient(name = "ACCOUNT-SERVICE")
public interface FeignToAccount {
    @GetMapping("/account/{customerId}")
    List<Account> receiveAccount(@PathVariable("customerId") int customerId);
}
