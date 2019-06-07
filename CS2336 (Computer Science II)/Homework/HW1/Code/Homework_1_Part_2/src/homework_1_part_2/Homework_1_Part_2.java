package Homework_1_part_2;

import java.util.Scanner;
/**
 *
 * @author Mario Bolivar - mjb160330
 * 
 * This program prompts the user for ten numbers and displays
 * the mean and standard deviation of these numbers
 * 
 */
public class Homework_1_Part_2 {
    
    public static void main(String[] args) {
        //input Scanner object
        Scanner input  = new Scanner(System.in);
        
        //Variables used to store information
        int numbers = 10;
        double currentNumber = 0, sum1 = 0, sum2 = 0, mean, standardDeviation;
        
        //Getting the 10 numbers from user input
        for(int i = 0;i < 10; i++){
            System.out.print("Please enter a value for number{" + (i + 1) + "}: " );
            
            currentNumber = input.nextDouble();
            
            //Calculating running sums that will be used to 
            //calculate mean and standard deviation
            sum1 += currentNumber;
            sum2 += currentNumber * currentNumber;
        }
        
        //Calculating mean and Standard Deviation
        mean = sum1 / numbers;
        standardDeviation = Math.sqrt(((numbers * sum2) - (sum1 * sum1)) / (numbers * numbers));

        //outputting calculations to the console
        System.out.println("The mean for the numbers inputted is: " + mean);
        System.out.println("The Standard Deviation for the numbers inputted is: " + standardDeviation);        
    }    
}
