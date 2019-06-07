package homework_3;

/**
 *
 * @author Mario Bolivar - Mjb160330
*
*/

//Checking account class
public class CheckingAccountClass
                extends BaseAccountClass{
    
    //Overlaoded constructor
    public CheckingAccountClass(double annualInterest,double balance){
        super(annualInterest,balance);
    }            
    
    //Method that checks to apply a fee if the withdrawn amount
    //makes the balance negative
    @Override
    public void withdraw(double amount){
        if((balance - amount) < 0){
            balance -= 15;
        }else{
            super.withdraw(amount);
        }
    }
    
    //Method that calculates the monthly interest based on the amount of times the account
    //was withdrawn from
    @Override
    public void monthlyProc(){
        monthlyServiceCharge += 5 + (.10 * numWithdrawals);
        super.monthlyProc();
    }
}
