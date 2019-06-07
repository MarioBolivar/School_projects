package homework_3;

/**
 *
 * @author Mario Bolivar - mjb160330
 */


//Savings account class
public class SavingsAccountClass 
        extends BaseAccountClass {

    //boolean variable to determine whether the account is inactive
    boolean status;
    
    //Overloaded constructor
    public SavingsAccountClass(double annualInterest, double balance) {
        super(annualInterest,balance);
        getStatus();
    }
    
    //Method that determines whether the account is inactive
    public boolean getStatus(){
        if(balance < 25)
            status = true;
        else
            status = false;
        
        return status;
    }
    
    //Method that checks if savings account is inactive and withdraws if not inactive
    @Override
    public void withdraw(double amount){
        if(getStatus())
            System.out.println("Account is inactive.");
        else
            super.withdraw(amount);
    }
    
    //Method that deposits an amount and sets the status of the account
    @Override
    public void deposit(double amount){
        
        super.deposit(amount);
        getStatus();
    }
    
    //Method that calculates the monthly fees for the account
    @Override
    public void monthlyProc(){
        if(numWithdrawals > 4){
            int temp = numWithdrawals - 4;
            monthlyServiceCharge += temp;
        }
        
        super.monthlyProc();
        getStatus();
        
    }
}
