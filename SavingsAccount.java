public class SavingsAccount extends BankAccount {
    private static final double rate = 0.025;
    private int savingsNumber = 0;
    private String accountNumber;

    public SavingsAccount(Person owner, double initialBalance) {
        super(owner, initialBalance);
        this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    public void postInterest() {
        double monthlyInterest = (getBalance() * rate) / 12;
        deposit(monthlyInterest);
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    public SavingsAccount(SavingsAccount original, double initialBalance) {
        super(original.getOwner(), initialBalance);
        this.savingsNumber = original.savingsNumber + 1;
        this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }
}
