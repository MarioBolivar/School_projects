package calculator;


import java.util.Scanner;
/*
 *
 * @author Mario Bolivar - Mjb160330
 *
 */

public class ComplexNumberClass extends NumberClass{
    
    double imaginaryNumber;
    
    //Constructor - also calls super constructor
    ComplexNumberClass(double realNumber,double imaginaryNumber){
        super(realNumber);
        this.imaginaryNumber = imaginaryNumber;
    }

    //Setter method for imaginaryNumber variable
    public void setImaginaryNumber(double imaginaryNumber){
        this.imaginaryNumber = imaginaryNumber;
    }
    
    //Getter method for imaginaryNumber variable
    public double getImaginaryNumber(){
        return imaginaryNumber;
    }
    
    //Overriden toString method that returns imaginaryNummber variable as a string
   @Override
   public String toString(){
       return Double.toString(imaginaryNumber);
   }
    
   //Method to check if a number equals imaginaryNumber
   public boolean equals(double x){
       if(this.imaginaryNumber == x)
           return true;
       else
           return false;
   }
    
}
