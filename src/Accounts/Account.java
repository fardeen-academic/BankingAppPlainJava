package Accounts;

public class Account extends AccountDetails {
    static String BankName = "Bank of Stamford";
    static int totalAccounts = 0;
    int AccountNumber;
    String AccountHolder;
    double Balance;
    String Password;
    String AccountType;
    String AccountStatus;

    public Account() {
        this.AccountNumber = 0;
        this.AccountHolder = "";
        this.Balance = 0.0;
        this.Password = "";
        this.AccountType = "";
        this.AccountStatus = "";
    }

    public Account(String AccountHolder, String Password) {
        this.AccountNumber = ++totalAccounts;
        this.AccountHolder = AccountHolder;
        this.Balance = 0.0;
        this.Password = Password;
        this.AccountType = "Savings";
        this.AccountStatus = "Active";
    }
    public Account(int AccountNumber, String AccountHolder, String Password) {
        this.AccountNumber = AccountNumber;
        this.AccountHolder = AccountHolder;
        this.Balance = 0.0;
        this.Password = Password;
        this.AccountType = "Savings";
        this.AccountStatus = "Active";
        totalAccounts++;
    }

    public Account(String AccountHolder, String Password, String AccountType,
            String AccountStatus) {
        this.AccountNumber = ++totalAccounts;
        this.AccountHolder = AccountHolder;
        this.Balance = 0.0;
        this.Password = Password;
        this.AccountType = AccountType;
        this.AccountStatus = AccountStatus;
    }

    public Account(String AccountHolder, double Balance, String Password, String AccountType,
            String AccountStatus) {
        this.AccountNumber = ++totalAccounts;
        this.AccountHolder = AccountHolder;
        this.Balance = Balance;
        this.Password = Password;
        this.AccountType = AccountType;
        this.AccountStatus = AccountStatus;
    }
    
    public Account(String AccountHolder, String Password, double Balance) {
        this.AccountNumber = ++totalAccounts;
        this.AccountHolder = AccountHolder;
        this.Balance = Balance;
        this.Password = Password;
        this.AccountType = "Savings";
        this.AccountStatus = "Active";
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public String getAccountHolder() {
        return AccountHolder;
    }

    public void setAccountHolder(String AccountHolder) {
        this.AccountHolder = AccountHolder;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String AccountType) {
        this.AccountType = AccountType;
    }

    public String getAccountStatus() {
        return AccountStatus;
    }

    public void setAccountStatus(String AccountStatus) {
        this.AccountStatus = AccountStatus;
    }

    public static String getBankName() {
        return BankName;
    }

    public static void setBankName(String BankName) {
        Account.BankName = BankName;
    }

    public void deposit(double amount) {
        this.Balance += amount;
    }

    public void withdraw(double amount) {
        this.Balance -= amount;
    }

    public void printAccountDetails() {
        System.out.println("Account Number: " + this.AccountNumber);
        System.out.println("Account Holder: " + this.AccountHolder);
        System.out.println("Balance: " + this.Balance);
        System.out.println("Account Type: " + this.AccountType);
        System.out.println("Account Status: " + this.AccountStatus);
    }    
}