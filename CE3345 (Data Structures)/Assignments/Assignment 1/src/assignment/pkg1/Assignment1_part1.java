
package assignment.pkg1;

import java.util.Scanner;

/**
 *
 * @author Mario Bolivar - Mjb160330
 *  Problem 1 - Finding the number of 1's in the binary representation of a number.
 */
public class Assignment1_part1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter a number to find out how many 1's are in its binary representation: ");
        int num = input.nextInt();
        
        recBinary(num);
    }
    
    
    public static void recBinary(int n){
        
        recBinaryHelper(n,0);
    
    }

    public static void recBinaryHelper(int n,int sum){
        
        if(n % 2 != 0){
             System.out.println("The number of 1's in the binary representation of '" + n + "' are: " + sum);
        }else{
            
            sum++;
            recBinaryHelper(n/2,sum);
        }
    }
}
