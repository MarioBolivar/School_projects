package Paradox;

/**
 *
 * @author Mario Bolivar - Mjb160330
 */

//Payload class to store coefficient and exponent of integrand
public class Payload {
    int coefficient;
    int exponent;
    
    //Overloaded constructor
    public Payload(int coefficient, int exponent){
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    
    //Accessors
    public int getCoefficient(){
        return coefficient;
    }
    
    public int getExponent(){
        return exponent;
    }
    
    //Mutators
    public void setCoefficient(int coefficient){
        this.coefficient = coefficient;
    }
    
    public void setExponent(int exponent){
        this.exponent = exponent;
    }
    
    //ToString
    @Override
    public String toString(){
        return "Coefficient: " + coefficient + " Exponent: " + exponent + "\n";
    }
}
