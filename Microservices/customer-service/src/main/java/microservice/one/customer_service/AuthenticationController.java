package microservice.one.customer_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    CustomerService service;
    @Autowired
    JwtUtility utility;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public String login(@RequestBody Customer customer){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customer.getUsername(), customer.getPassword()));
        if (authenticate.isAuthenticated()) {
            return utility.generateToken(customer.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }
    }
    @PostMapping("/register")
    public Customer addNewUser(@RequestBody Customer user) {
        return service.createCustomer(user);
    }
}
