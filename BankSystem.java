import java.util.HashMap;

public class BankSystem {
    private HashMap<String, BankAccount> accounts;

    public BankSystem() {
        accounts = new HashMap<>();
    }

    public void createAccount(String username, String name, String accountType, double initialBalance) {
        Person person = new Person(username, name);
        BankAccount account;

        switch (accountType.toLowerCase()) {
            case "savings":
                account = new SavingsAccount(person, initialBalance);
                break;
            case "checking":
                account = new CheckingAccount(person, initialBalance);
                break;
            default:
                System.out.println("Invalid account type.");
                return;
        }

        accounts.put(username, account);
        System.out.println("Account created for " + name + " with account number " + account.getAccountNumber());
    }

    public BankAccount getAccount(String username) {
        return accounts.get(username);
    }
}
