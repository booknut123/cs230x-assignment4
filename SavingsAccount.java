
/**
 * Savings-specific Account with overdraft fee.
 *
 * @author Kailyn Lau
 * @version v1.0
 */
public class SavingsAccount extends Account
{
    protected final double INTEREST = 0.005; // currently fixed (can expand later; would remove final keyword and would add getter/setter)
    
    /**
     * Constructs a SavingsAccount
     * 
     * @param accountNum an integer account number
     * @param balance the initial balance in the account
     */
    public SavingsAccount(int accountNum, double balance) {
        super.accountNumber = accountNum;
        super.balance = balance;
    }
    
    /**
     * There should be an addInterest method of some sort that was never specified... something like the following?
     * Track date of creation of the account
     * Once a year, add interest (balance += balance * INTEREST)
     * 
     * public void addInterest() {
     *     super.balance += super.balance * INTEREST
     * }
     */
    
    /**
     * @return String representation of the checking account
     */
    @Override
    public String toString() {
        return "Savings " + super.toString() + "\tInterest rate: " + INTEREST*100 + "%";
    }
}
