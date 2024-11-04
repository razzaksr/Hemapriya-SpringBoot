package middleware.spring.backend_api_basic;

public class Savings {
    private String accountHolder;
    private long accountNumber;
    private double accountBalance;
    private String ifscCode;
    private String bankName;
    @Override
    public String toString() {
        return "Savings [accountHolder=" + accountHolder + ", accountNumber=" + accountNumber + ", accountBalance="
                + accountBalance + ", ifscCode=" + ifscCode + ", bankName=" + bankName + "]";
    }
    public Savings() {
    }
    public Savings(String accountHolder, long accountNumber, double accountBalance, String ifscCode, String bankName) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.ifscCode = ifscCode;
        this.bankName = bankName;
    }
    public String getAccountHolder() {
        return accountHolder;
    }
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
    public String getIfscCode() {
        return ifscCode;
    }
    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
