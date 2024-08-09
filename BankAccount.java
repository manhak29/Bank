public abstract class BankAccount {
   protected static int numberOfAccounts = 100001;
   private double balance;
   private Person owner;
   private String accountNumber;

   public BankAccount(Person owner, double amount) {
       this.owner = owner;
       this.balance = amount;
       this.accountNumber = numberOfAccounts + "";
       numberOfAccounts++;
   }

   public void deposit(double amount) {
       balance = balance + amount;
   }

   public boolean withdraw(double amount) {
       if (amount <= balance) {
           balance = balance - amount;
           return true;
       } else {
           return false;
       }
   }

   public double getBalance() {
       return balance;
   }

   public Person getOwner() {
       return owner;
   }

   public String getAccountNumber() {
       return accountNumber;
   }
}
