package calculator;

/*
 *
 * @author Mario Bolivar - Mjb160330
 *
 */


//Base number class
public class NumberClass {
    
    //Real number variable
    double realNumber;
    
    //Constructor
    NumberClass(double realNumber){
        this.realNumber = realNumber;
    }
    
    //Setter method for realNumber variable
    public void setNumber(double realNumber){
        this.realNumber = realNumber;
    }
    
    //Getter method for realNumber variable
    public double getNumber(){
        return this.realNumber;
    }
    
    //Overriden toString method that returns realNumber variable as a string
    @Override
    public String toString(){
      return Double.toString(realNumber);
    }
    
    //Method to check if a number equals realNumber
    public boolean equals(double x){
    if(this.realNumber == x)
        return true;
    else
        return false;
   }
    
    
    
    
    
}
