import java.util.Scanner;
import Accounts.Account;
import Menu.Menu;
import Accounts.Teller;

public class App {
    static void print(String s) {
        System.out.println(s);
    }

    static void menuTitle(String title) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        print("*****\tWelcome to " + Account.getBankName() + "\t*****\n");
        print("*****\t" + title + "\t*****\n");
    }
    
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Account[] accounts = new Account[4];
        accounts[0] = new Account("Fardeen", "password", 1000.0);
        accounts[1] = new Account("Ehsan", "password", 2000.0);
        accounts[2] = new Account("Shawon", "password");
        accounts[3] = new Account("Mark", 4000.0, "password", "Savings", "Inactive");

        Teller[] tellers = new Teller[2];
        tellers[0] = new Teller("Teller", "admin", "admin");
        tellers[1] = new Teller("Teller Two", "admin2", "admin2");
        Menu menu = new Menu();
        while (true) {
            menuTitle("Main Menu");
            print("1. Create a new Account");
            print("2. Login as Existing Customer");
            print("3. Login as teller");
            print("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    accounts = menu.CreateAccount(accounts);
                    print("Account Successfully Created");
                    print("Your user ID is: " + accounts[accounts.length - 1].getAccountNumber());
                    print("Enter any key to continue");
                    scan.next();
                    continue;
                case 2:
                    int accountNumber = menu.Login(accounts);
                    if (accountNumber > -1) {
                        accounts = menu.AccountMenu(accounts, accountNumber);
                        scan.next();
                        continue;
                    } else {
                        print("Login Failed");
                        print("Enter any key to continue");
                        scan.next();
                        continue;
                    }
                case 3:
                    int tellerLoggedIn = menu.LoginTeller(tellers);
                    if (tellerLoggedIn == 1) {
                        accounts = menu.TellerMenu(accounts);
                        print("1. Continue\n2. Exit");
                        System.out.print("Enter your choice: ");
                        int tellerChoice = scan.nextInt();
                        switch (tellerChoice) {
                            case 1:
                                continue;
                            default:
                                menuTitle("Thank you for using our system.");
                                return;
                        }
                        
                    } else {
                        print("Login Failed");
                        print("Enter any key to continue");
                        scan.next();
                        continue;
                    }
                case 4:
                    menuTitle("Thank you for using our system.");
                    return;
                default:
                    print("Invalid choice. Enter again");
                    continue;
            }
        }

    }    
}
