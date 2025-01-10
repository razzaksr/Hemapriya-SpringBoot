package microservice.five.auth_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenService implements UserDetailsService{
    @Autowired
    FeignToCustomer feignToCustomer;

    public Customer register(Customer customer){
        return feignToCustomer.connectCustomerPostMapping(customer);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Customer customer = feignToCustomer.connectCustomerGetMapping(username).get();
        if(customer==null)
            throw new UsernameNotFoundException(username);
        return customer;
    }
}
