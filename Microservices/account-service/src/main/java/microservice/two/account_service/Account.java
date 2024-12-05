package microservice.two.account_service;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    private int customer;
    private String accountType;
    @Column(unique = true)
    private long accountNumber;
    private boolean accountStatus;
    private double accountBalance;
    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", customer=" + customer + ", accountType=" + accountType
                + ", accountNumber=" + accountNumber + ", accountStatus=" + accountStatus + ", accountBalance="
                + accountBalance + "]";
    }
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public int getCustomer() {
        return customer;
    }
    public void setCustomer(int customer) {
        this.customer = customer;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    public boolean isAccountStatus() {
        return accountStatus;
    }
    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
