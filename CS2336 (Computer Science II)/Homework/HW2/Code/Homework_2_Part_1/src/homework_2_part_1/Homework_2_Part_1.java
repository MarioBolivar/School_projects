package homework_2_part_1;

import java.util.Scanner;


/**
 *
 * @author Mario Bolivar - mjb160330
 *  This program calculates the dollars and coins to return to a customer
 * 
 * 
 */
public class Homework_2_Part_1 {

    public static void main(String[] args) {
        changeAmount();
    }
    
    public static void changeAmount(){
        //Scanner object for input
        Scanner input = new Scanner(System.in);
        
        //String that will hold change amount from user input
        String changeAmount;
        
        //Getting data
        System.out.print("Please enter the change amount: $");
        changeAmount = input.next();
        
        //Getting index of the '.' delimiter
        int index = changeAmount.indexOf('.');
        
        //Extracting the dollar amount
        String temp = changeAmount.substring(0, index);
        
        //Converting the extracted dollar amount to Int
        int dollars = Integer.parseInt(temp);
        
        //Extracting the cent amount
        temp = changeAmount.substring(index + 1);
        
        //Converting the extracted cent amount to Int
        int cents = Integer.parseInt(temp);
        
        
        //Getting the change information
        int quarters = (cents / 25);
        
        cents -= (quarters*25);
        
        int dimes = (cents / 10);
        
        cents -= (dimes*10);
        
        int nickels = (cents /5);
        
        cents -= (nickels*5);
        
        int pennies = cents;
        
        
        
        //Outputting a formatted table with the information calculated.
        System.out.printf("%15s%15s\n","Change Type","Amount");
        System.out.printf("%15s%15d\n", "Dollars:",dollars);
        System.out.printf("%15s%15d\n", "Quarters:",quarters);
        System.out.printf("%15s%15d\n", "Dimes:",dimes);
        System.out.printf("%15s%15d\n", "Nickels:",nickels);
        System.out.printf("%15s%15d\n", "Pennies:",pennies);

    }
    
}
