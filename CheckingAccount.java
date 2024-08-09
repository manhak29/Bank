public class CheckingAccount extends BankAccount {
    private static final double FEE = 0.15;

    public CheckingAccount(Person owner, double amount) {
        super(owner, amount);
        setAccountNumber(getAccountNumber() + "-10");
    }

    @Override
    public boolean withdraw(double amount) {
        amount += FEE;
        return super.withdraw(amount);
    }

    private void setAccountNumber(String accountNumber) {
        setAccountNumber(accountNumber); // Calls the public method in the superclass
    }    
}
