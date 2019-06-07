package homework_3;

/**
 *
 * @author Mario Bolivar - Mjb160330
 *
 */

//Base account class
public class BaseAccountClass {
   protected double annualInterest, balance, monthlyServiceCharge;
    protected int numDeposits, numWithdrawals;
    
    //Default Constructor
    BaseAccountClass(){
        this(0,0);
    }
    
    //Overloaded Constructor
    BaseAccountClass(double annualInterest, double balance) {
        this.annualInterest = annualInterest;
        this.balance = balance;
    }
    
    //Base Class method to make a deposit to the account
    public void deposit(double deposit){
        balance += deposit;
        numDeposits++;    
    }
    
    //Base Class method to make a withdrawal from the account
    public void withdraw(double withdrawal){
            balance -= withdrawal;
            numWithdrawals++;
        }
    
    //Base Class method to calculate the interest rates
    public void calcInt(){
        double monthlyInterestRate = (annualInterest/12);
        double MonthlyInterest = (balance * monthlyInterestRate);
        balance = balance + MonthlyInterest;
    }
    
    //Base Class method to calculate the monthly service charge
    public void monthlyProc(){
        System.out.println("The monthly service charge is: $" + monthlyServiceCharge);
        balance -= monthlyServiceCharge;
        calcInt();
        numWithdrawals = 0;
        numDeposits = 0;
        monthlyServiceCharge = 0;
    }
    
    public double getNumWithdrawals(){
        return numWithdrawals;
    }
    
    public double getNumDeposits(){
        return numDeposits;
    }
}
