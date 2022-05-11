package Menu;

import java.util.Scanner;
import Accounts.Account;
import Accounts.Teller;
public class Menu {
    static Scanner scan = new Scanner(System.in);
    static void print(String s) {
        System.out.println(s);
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void menuTitle(String title) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        print("*****\tWelcome to " + Account.getBankName()+"\t*****\n");
        print("*****\t"+title+"\t*****\n");
    }

    public void mainMenu() {
        menuTitle("Main Menu");
        print("1. Create a new Account");
        print("2. Login as Existing Customer");
        print("3. Login as teller");
        print("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public Account[] CreateAccount(Account[] accounts) {
        menuTitle("Create a new Account");
        print("Enter your name: ");
        String name = scan.next();
        print("Enter a password: ");
        String password = scan.next();
        Account newAccount = new Account(name, password);
        Account[] newAccounts = new Account[accounts.length + 1];
        for (int i = 0; i < accounts.length; i++) {
            newAccounts[i] = accounts[i];
        }
        newAccounts[accounts.length] = newAccount;
        return newAccounts;
    }

    public int Login(Account[] accounts) {
        menuTitle("Login as Existing Customer");
        print("Enter your Account Number: ");
        int accountNumber = scan.nextInt();
        print("Enter your password: ");
        String password = scan.next();
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber && account.getPassword().equals(password)) {
                return accountNumber;
            }
        }
        return -1;
    }

    public int LoginTeller(Teller[] tellers) {
        menuTitle("Login as teller");
        print("Enter username: ");
        String username = scan.next();
        print("Enter your password: ");
        String password = scan.next();
        for (Teller teller : tellers) {
            if (teller.getUsername().equals(username) && teller.getPassword().equals(password)) {
                return 1;
            }
        }
        return 0;
    }
    
    public Account[] AccountMenu(Account[] allAccounts, int AccountNumber) {
        while (true) {
            Account myAccount = Account.getAccount(allAccounts, AccountNumber);
            menuTitle("Account Menu");
            print("1. View Details");
            print("2. Check Balance");
            print("3. Transfer");
            print("4. Change Password");
            print("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    menuTitle("");
                    Account myAcc = Account.getAccount(allAccounts, AccountNumber);
                    myAcc.printAccountDetails();
                    print("Press any key to continue");
                    scan.next();
                    break;
                case 2:
                    menuTitle("");
                    print("\nYour Account Balance is " + myAccount.getBalance() + "taka\n");
                    print("Press any key to continue");
                    scan.next();
                    break;
                case 3:
                    System.out.print("Enter Reciever Account Number: ");
                    int reciever = scan.nextInt();
                    System.out.print("Enter Amount: ");
                    int amount = scan.nextInt();
                    print("\nTransfering " + amount + " taka to Account Number " + reciever + "\n");
                    print("1. Confirm\n2. Exit");
                    System.out.print("Enter your choice: ");
                    int choice2 = scan.nextInt();
                    switch (choice2) {
                        case 1:
                            allAccounts = Account.transfer(allAccounts, AccountNumber, reciever, amount);
                            return allAccounts;
                        default:
                            return allAccounts;
                    }
                case 4:
                    print("Enter old password: ");
                    String oldPass = scan.next();
                    print("Enter new password: ");
                    String newPass = scan.next();
                    allAccounts = Account.changePassword(allAccounts, AccountNumber, oldPass, newPass);
                    print("1. Continue\n2. Exit");
                    System.out.print("Enter your choice: ");
                    int choiceChangePass = scan.nextInt();
                    switch (choiceChangePass) {
                        case 1:
                            break;
                        default:
                            return allAccounts;
                    }
                default:
                    return allAccounts;
            }
        }

    }
    
    private static Account[] CreateAccountbyTeller(Account[] accounts) {
        menuTitle("Create a new Account");
        print("Enter customer name: ");
        String name = scan.next();
        print("Enter a password: ");
        String password = scan.next();
        print("Intial balance: ");
        double balance = scan.nextDouble();
        Account newAccount = new Account(name, password, balance);
        Account[] newAccounts = new Account[accounts.length + 1];
        for (int i = 0; i < accounts.length; i++) {
            newAccounts[i] = accounts[i];
        }
        newAccounts[accounts.length] = newAccount;
        print("Account Created Successfully");
        print("Press any key to continue");
        scan.next();
        return newAccounts;
    }

    public static Account[] updateDetails(Account[] accounts, int accountNumber) {
        print("Choose information to update\n\n1. Accountholder's name: \n2. Account Status\n3. Account Type");
        print("\nEnter your choice: ");
        int choice = scan.nextInt();
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                switch (choice) {
                    case 1:
                        print("Old Name: " + accounts[i].getAccountHolder());
                        print("Enter New Name: ");
                        String name = scan.next();
                        accounts[i].setAccountHolder(name);
                        return accounts;
                    case 2:
                        print("Current account status: " + accounts[i].getAccountStatus());
                        System.out.print("Enter new status: ");
                        String status = scan.next();
                        accounts[i].setAccountStatus(status);
                        return accounts;
                    case 3:
                        print("Current account type: " + accounts[i].getAccountType());
                        System.out.print("Enter new type: ");
                        String type = scan.next();
                        accounts[i].setAccountType(type);
                        return accounts;
                    default:
                        break;
                }
                break;
            }
        }
        return accounts;
    }

    public Account[] TellerMenu(Account[] accounts) {
        while (true) {
            menuTitle("Teller Menu");
            print("1. Create New Account");
            print("2. View Customer Details");
            print("3. Update Customer Details");
            print("4. Deposit Cash");
            print("5. Withdraw Cash");
            print("6. Logout");
            print("Enter your choice: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    accounts = Menu.CreateAccountbyTeller(accounts);
                case 2:
                    //View Customer Details;
                    System.out.print("Enter Account number: ");
                    int acct = scan.nextInt();
                    Account a = Account.getAccount(accounts, acct);
                    a.printAccountDetails();
                    print("Press any key to continue");
                    scan.next();
                    break;
                case 3:
                    //Update Customer Details;
                    System.out.print("Enter Account number: ");
                    int account = scan.nextInt();
                    accounts = Menu.updateDetails(accounts, account);
                    print("Press any key to continue");
                    scan.next();
                    break;
                case 4:
                    //Deposit Cash;
                    System.out.print("Enter Account number: ");
                    int acc = scan.nextInt();
                    System.out.print("Enter amount: ");
                    int amount = scan.nextInt();
                    print("Deposit " + amount + " to account number " + acc);
                    System.out.print("1. Confirm\n2. Cancel\n\nEnter your choice: ");
                    int choiceDeposit = scan.nextInt();
                    switch (choiceDeposit) {
                        case 1:
                            Account a1 = Account.getAccount(accounts, acc);
                            a1.deposit(amount);
                            menuTitle("Deposit successful");
                            print("Press any key to continue");
                            scan.next();
                            break;
                        case 2:
                            break;
                    }
                case 5:
                    //Withdraw Cash
                    System.out.print("Enter Account number: ");
                    int acc2 = scan.nextInt();
                    System.out.print("Enter amount: ");
                    int amount2 = scan.nextInt();
                    print("Withdraw " + amount2 + " from account number " + acc2);
                    System.out.print("1. Confirm\n2. Cancel\n\nEnter your choice: ");
                    int choiceWithdraw = scan.nextInt();
                    switch (choiceWithdraw) {
                        case 1:
                            Account a1 = Account.getAccount(accounts, acc2);
                            a1.withdraw(amount2);
                            menuTitle("Withdraw successful");
                            print("Press any key to continue");
                            scan.next();
                            break;
                        case 2:
                            break;
                    }
                case 6:
                    return accounts;
                
            }
        }
    }

}
