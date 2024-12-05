package microservice.two.account_service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    // findAllByProperty
    List<Account> findAllByCustomer(int customerId);
}
