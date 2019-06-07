package homework_1_part_3;

import java.util.Scanner;

/**
 *
 * @author Mario Bolivar - mjb160330
 * 
 * This program uses a recursive method that converts an integer to hexadecimal
 * user is prompted for an integer and the program prints the hexadecimal equivalent
 * of the integer inputted.
 */

public class Homework_1_Part_3 {
    
    //Recursive method that converts inputted int
    public static String convertToHex(int num){
        
        //variables
        int remainder = num % 16;
        String hex = "";
       
        //if remainder is less than 10, add it to the string
        if(remainder < 10){
            hex += remainder;
        }
       
        //if remainder is greater than 9, check if it is 10-15 to check for hex value
        if(remainder > 9){
            switch(remainder){
                case 10:    hex  = "A"; break;
                case 11:    hex  = "B"; break;
                case 12:    hex  = "C"; break;
                case 13:    hex  = "D"; break;
                case 14:    hex  = "E"; break;
                case 15:    hex  = "F"; break;
            }
            
        }
        
        //if number inputted is greater than 0, recursion
        if(num > 0){
            System.out.print(convertToHex((num - remainder) / 16) + hex);
        }
        
        return "";
    }
    
    
    public static void main(String[] args) {
        
        
        //input scanner object + number to convert
        Scanner input  = new Scanner(System.in);
        int numberToConvert;
        
        //gathering user input
        System.out.println("Please enter an integer to convert: ");
        numberToConvert = input.nextInt();
        
        //calling recursive method
        convertToHex(numberToConvert);
        
        
    }
}
