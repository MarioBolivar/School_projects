package homework_3;

/**
 *
 * @author Mario Bolivar - mjb160330
 * This program holds bank account information for a user 
 * and calculates bank account information
 * 
 */
public class Homework_3 {

    public static void main(String[] args) {
        
        //Beginning balance variables
        double beginningBalanceSavings, beginningBalanceChecking;
        
        //Creating the two account objects
        SavingsAccountClass testUserSavings = new SavingsAccountClass(1, 50000);
        CheckingAccountClass   testUserChecking = new CheckingAccountClass(1, 4000);

        //Saving the beginning balances
        beginningBalanceSavings = testUserSavings.balance;
        beginningBalanceChecking = testUserChecking.balance;

        
        //Making some test deposits
        testUserChecking.deposit(400);
        testUserSavings.deposit(1000);
        testUserSavings.deposit(9000);
        testUserChecking.deposit(100);
        testUserChecking.deposit(400);
        testUserChecking.deposit(350);
        testUserSavings.deposit(6500);
        
        //Making some test withdrawals
        testUserChecking.withdraw(7000);
        testUserChecking.withdraw(9000);
        testUserSavings.withdraw(11000);
        testUserSavings.withdraw(1000);
        testUserSavings.withdraw(6000);
        testUserSavings.withdraw(2000);
        testUserSavings.withdraw(11000);
        testUserSavings.withdraw(2700);
        
     
        //Outputting account information
        System.out.println("Beginning Balance for Savings Account: " + beginningBalanceSavings);
        System.out.println("Amount of deposits into Savings account for the month: " + testUserSavings.getNumDeposits());
        System.out.println("Amount of withdrawals from Savings account for the month: " + testUserSavings.getNumWithdrawals());
        testUserSavings.monthlyProc();
        System.out.println("Savings account ending balance: " + testUserSavings.balance);
        System.out.println("Beginning Balance for Savings Account: " + beginningBalanceChecking);
        System.out.println("Amount of deposits into Savings account for the month: " + testUserChecking.getNumDeposits());
        System.out.println("Amount of withdrawals from Savings account for the month: " + testUserChecking.getNumWithdrawals());
        testUserChecking.monthlyProc();
        System.out.println("Checking account ending balance: " + testUserChecking.balance);
        
        
       
        
    }
    
}
