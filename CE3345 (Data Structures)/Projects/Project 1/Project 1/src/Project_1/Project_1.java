package Project_1;

import java.util.Scanner;

/**
 *
 * @author Mario Bolivar - Mjb160330
 *  Class: CE 3345.001
 *  Semester: Fall 2018
 *  Project #1: This program prompts the user to give a positive integer value N 
 *  and prints all primes up until N using the  “Sieve of Erotosthenes” algorithm.
 * 
 */

public class Project_1 {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
       
        
        //Validating input
        while(true){
            try{
                
                //Prompt user for input
                System.out.print("Please enter a positive integer value: ");
                int input = scan.nextInt();
                
                //If input is negative
                if(input < 0){
                   throw new Exception("Number cannot be negative!"); //Throw an exception
                }else{ //If input is valid, proceed.
                    
                    System.out.println("The following are prime numbers of '" + input + "'");
                    
                    //Method call to begin prime number calculation.
                    sieveOfEratosthenes(input);
                    break;
                }
            }catch(Exception e){ //Catching any exceptions thrown and retrying user input retrieval.
                System.out.println("\n  >Invalid input, please try again.");
                System.out.println();
                scan.nextLine();
                        
            }
        }
    }

    //Sieve of Eratosthenes method to calculate the Prime #s of a given number 
    public static void sieveOfEratosthenes(int number){
        
        //Create a boolean array of number + 1
        boolean primeArray[] = new boolean[number+1];
        
        //Initialize all elements to true
        for(int i = 0; i < number+1; i++){
            primeArray[i] = true;
        }
        
        //Begin from 2nd element and check all multiples of itself starting at its square for optimization
        for(int j = 2; j*j <= number; j++){
            
            //If element has not already been marked as not prime
            if(primeArray[j] == true){
                
                //Eliminate all its multiples of 2
                for(int k = j*2; k <= number; k += j){
                    primeArray[k] = false;
                }
            }  
        }
        
        //Output all prime #'s
        int count = 0;
        for(int i = 2; i <= number; i++){
           
            if(primeArray[i] == true){
                count++;
                System.out.print(i + " ");
                
            //Every 10 elements, output a new line for visual aid.
            if(count % 10 == 0)
                System.out.println();
            }
        }
        
        //If no primer numbers, output message.
        if(count == 0){
            System.out.println("\nThere are no prime numbers for '" + number + "'");
        }
    }
}
