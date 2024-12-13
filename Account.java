import java.text.NumberFormat;

/**
 * Account with double balance and unique accountNumber.
 *
 * @author Kailyn Lau
 * @version v1.0
 */
public abstract class Account
{
    protected int accountNumber;
    protected double balance;
    
    protected NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    
    /**
     * @return the unique account number
     */
    public int getAccountNum() {
        return accountNumber;
    }
    
    /**
     * @return the balance in the account, formatted for standard currency
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * @param new balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    /**
     * Adds money to the balance in the Account
     * 
     * @param amount the amount to deposit
     * @return String letting the user know the deposit was successful
     */
    public String deposit(double amount) {
        balance += amount;
        return "Deposit SUCCESSFUL.";
    }
    
    /**
     * Withdrawing money from the Account.
     * 
     * @param amount the amount to withdraw
     * @return String letting the user know whether the withdrawal was successful or not
     */
    public String withdraw(double amount) {
        if (amount < balance) {
            balance -= amount;
            return "Withdrawal SUCCESSFUL";
        } else {
            return "Withdrawal DENIED";
        }
    }
    
    /**
     * @return String representation of the account
     */
    public String toString() {
        return "account #" + accountNumber + "\tBalance: " + currencyFormatter.format(getBalance());
    }
}
