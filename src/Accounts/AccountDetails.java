package Accounts;

public class AccountDetails {
    public static void SearchAccount(Account[] accounts, int AccountNumber) {
        for (Account account : accounts) {
            if (account.AccountNumber == AccountNumber) {
                System.out.println("Account Number: " + account.AccountNumber);
                System.out.println("Account Holder: " + account.AccountHolder);
                System.out.println("Balance: " + account.Balance);
                System.out.println("Password: " + account.Password);
                System.out.println("Account Type: " + account.AccountType);
                System.out.println("Account Status: " + account.AccountStatus);
            }
        }
    }

    public static Account getAccount(Account[] accounts, int AccountNumber) {
        for (Account account : accounts) {
            if (account.AccountNumber == AccountNumber) {
                return account;
            }
        }
        return new Account();
    }

    
    public static Account[] transfer(Account[] allAccounts, int senderAccount, int recieverAccount, double amount) {
        for (int i = 0; i < allAccounts.length; i++) {
            if (allAccounts[i].getAccountNumber() == senderAccount && allAccounts[i].getBalance() >= amount) {
                for (int j = 0; j < allAccounts.length; j++) {
                    if (allAccounts[j].getAccountNumber() == recieverAccount
                            && allAccounts[j].getAccountStatus().equals("Active")) {
                        allAccounts[i].withdraw(amount);
                        allAccounts[j].deposit(amount);
                        System.out.println("Fund Transfer Successful");
                        System.out.println("Press any key to continue...");         
                        return allAccounts;
                    }
                }
            }

        }
        System.out.println("This fund Transfer can not be completed.");
        return allAccounts;
    }

    public static Account[] changePassword(Account[] accounts, int accountNumber, String oldPass, String newPass) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                if (accounts[i].getPassword().equals(oldPass)) {
                    accounts[i].setPassword(newPass);
                    System.out.println("Password Changed Successfully");
                } else {
                    System.out.print("Error! Password change unsuccessful.");
                }
                break;
            }
        }
        return accounts;
    }
}
