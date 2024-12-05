package microservice.one.customer_service;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String customerName;
    private String customerAddress;
    private boolean customerStatus;
    private long customerContact;
    private transient List<Account> myAccounts;// logical bonding
    public List<Account> getMyAccounts() {
        return myAccounts;
    }
    public void setMyAccounts(List<Account> myAccounts) {
        this.myAccounts = myAccounts;
    }
    @Column(unique = true)
    private String username;
    private String password;
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public boolean isCustomerStatus() {
        return customerStatus;
    }
    public void setCustomerStatus(boolean customerStatus) {
        this.customerStatus = customerStatus;
    }
    public long getCustomerContact() {
        return customerContact;
    }
    public void setCustomerContact(long customerContact) {
        this.customerContact = customerContact;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
