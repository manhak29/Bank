import java.util.Scanner;

public class AccountDriver {
    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Bank System!");

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Balance");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();

                System.out.print("Enter your full name: ");
                String name = scanner.nextLine();

                System.out.print("Enter account type (Savings/Checking): ");
                String accountType = scanner.nextLine();

                System.out.print("Enter initial deposit amount: ");
                double amount = scanner.nextDouble();

                bankSystem.createAccount(username, name, accountType, amount);
            } else if (choice == 2) {
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                BankAccount account = bankSystem.getAccount(username);

                if (account != null) {
                    System.out.print("Enter deposit amount: ");
                    double amount = scanner.nextDouble();
                    account.deposit(amount);
                    System.out.println("New balance: $" + account.getBalance());
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 3) {
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                BankAccount account = bankSystem.getAccount(username);

                if (account != null) {
                    System.out.print("Enter withdrawal amount: ");
                    double amount = scanner.nextDouble();
                    if (account.withdraw(amount)) {
                        System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 4) {
                System.out.print("Enter your username: ");
                String username = scanner.nextLine();
                BankAccount account = bankSystem.getAccount(username);

                if (account != null) {
                    System.out.println("Account balance: $" + account.getBalance());
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 5) {
                System.out.println("Thank you for using the Bank System!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}
