import java.text.NumberFormat;

/**
 * Bank class with collection of Accounts
 *
 * @author Kailyn Lau
 * @version v1.0
 */
public class Bank
{
    private Account[] accounts;
    private int count;
    
    /**
     * Creates a Bank with a collection of Accounts
     */
    public Bank() {
        accounts = new Account[4]; // hard-code to capacity of 4
        count = 0;
    }
    
    /**
     * Adds either a CheckingAccount or a SavingsAccount to the collection
     * 
     * @param type the type of account (checking or savings) // assumes input will be either "checking" or "saving". Can expand.
     * @balance the initial balance of the new account
     */
    public void addAccount(String type, double balance) {
        Account newAccount = new SavingsAccount(count, 0); // base case
        
        // Currently assuming the account's unique num is based on count (1st account = 0, 2nd account = 1, etc.)...
        // Can change later to generate a random number with an array of previously used numbers to ensure uniqueness.
        if (type.equalsIgnoreCase("checking")) {
            newAccount = new CheckingAccount(count, balance);
        } else if (type.equalsIgnoreCase("savings")) {
            newAccount = new SavingsAccount(count, balance);
        }
 
        try {
            accounts[count] = newAccount;
        } catch (Exception e) {}
        count++;
    }
    
    /**
     * Finds the Account with the requested accountNum (null if not found)
     * 
     * @param num the requested account number
     * @return the account with that number, null if not found
     */
    public Account findAccount(int num) {
        for (int i = 0; i < count; i++) {
            if (num == accounts[i].getAccountNum()) {
                return accounts[i];
            }
        }
        return null;
    }
    
    /**
     * Returns the total amount of funds this bank has
     * 
     * @return total funds from all Accounts
     */
    public double getTotalFunds() {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += (double)accounts[i].getBalance();
        }
        return sum;
    }
    
    /**
     * @return String representation of the Bank
     */
    public String toString() {
        String s = "This bank has " + count + " accounts.\n";
        for (int i = 0; i < count; i++) {
            s += accounts[i] + "\n";
        }
        return s;
    }
    
    /**
     * Main method to test this class
     */
    public static void main(String[] args) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        
        Bank bank = new Bank();
        
        bank.addAccount("checking", 1000);
        bank.addAccount("savings", 1000);
        bank.addAccount("checking", 500);
        bank.addAccount("savings", 500);
        
        System.out.println(bank);
        System.out.println("Total funds: " + currencyFormatter.format(bank.getTotalFunds()));
        
        System.out.println("\nDepositing 4000 into #0: ");
        bank.findAccount(0).deposit(4000);
        System.out.println("Expected: Checking Account #0 \tBalance: $5,000.00 \tMinimum balance: $100.00 Overdraft fee: $25.00");
        System.out.println("Result: " + bank.findAccount(0));
        
        System.out.println("\nDepositing 2000 into #1: ");
        bank.findAccount(1).deposit(2000);
        System.out.println("Expected: Checking Account #1 \tBalance: $3,000.00 \tInterest rate: 0.5%");
        System.out.println("Result: " + bank.findAccount(1));
        
        System.out.println("\nWithdrawing 6000 from #0: ");
        System.out.println("Expected: Withdrawal DENIED");
        System.out.println("Result: " + bank.findAccount(0).withdraw(6000));
        
        System.out.println("\nWithdrawing 6000 from #1: ");
        System.out.println("Expected: Withdrawal DENIED");
        System.out.println("Result: " + bank.findAccount(1).withdraw(6000));
        
        System.out.println("\nWithdrawing 4901 from #0: ");
        System.out.println("Expected: Withdrawal SUCCESSFUL **Low balance. Overdraft fee was charged.**");
        System.out.println("Result: " + bank.findAccount(0).withdraw(4901));
        System.out.println(bank.findAccount(0));
        
        System.out.println("\nWithdrawing 70 from #0: ");
        System.out.println("Expected: Withdrawal SUCCESSFUL **Low balance. Overdraft fee was charged.**");
        System.out.println("Result: " + bank.findAccount(0).withdraw(70));
        System.out.println(bank.findAccount(0));
        
        System.out.println("\nWithdrawing 10 from #0: ");
        System.out.println("Expected: Withdrawal DENIED");
        System.out.println("Result: " + bank.findAccount(0).withdraw(10));
        
        System.out.println("\nBank update: \n" + bank);
        System.out.println("Total funds: " + currencyFormatter.format(bank.getTotalFunds()));
    }
}
