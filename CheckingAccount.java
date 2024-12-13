
/**
 * Checking-specific Account with overdraft fee.
 *
 * @author Kailyn Lau
 * @version v1.0
 */
public class CheckingAccount extends Account
{
    protected final double MINBALANCE = 100; // currently fixed (can expand later; would remove final keyword and would add getter/setter)
    protected final double OVERDRAFTFEE = 25; // 0.5%, currently fixed (can expand later; would remove final keyword and would add getter/setter)
    
    /**
     * Constructs a CheckingAccount
     * 
     * @param accountNum an integer account number
     * @param balance the initial balance in the account
     */
    public CheckingAccount(int accountNum, double balance) {
        super.accountNumber = accountNum;
        super.balance = balance;
    }
    
    /**
     * CheckingAccount version of withdraw. Will withdraw as normal. Additional check - if lower than MINBALANCE, will charge an overdraft fee.
     * 
     * @param amount the amount attempted to withdraw
     * @return String letting the user know whether the withdrawal was successful or not + whether overdraft was charged or not
     */
    @Override
    public String withdraw (double amount) {
        double tempBalance = super.balance;
        String s = super.withdraw(amount);
        if (tempBalance > super.balance && super.balance < MINBALANCE) { // if withdraw was successful, check for overdraft fee
            balance -= OVERDRAFTFEE;
            s += " **Low balance. Overdraft fee was charged.**";
        }
        return s;
    }
    
    /**
     * @return String representation of the checking account
     */
    @Override
    public String toString() {
        return "Checking " + super.toString() + "\tMinimum balance: " + currencyFormatter.format(MINBALANCE) + " Overdraft fee: " + currencyFormatter.format(OVERDRAFTFEE);
    }
}
