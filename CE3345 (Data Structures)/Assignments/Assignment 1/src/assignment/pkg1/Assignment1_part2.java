package assignment.pkg1;
import java.util.Scanner;

/**
 *
 * @author mario
 * 
 * Given an array of n integers,  compute for each index i, 
 * the length of the longest alternating subarray starting at i.
 * 
 */
public class Assignment1_part2 {
    
     public static void main(String[] args) {
        int a [] = {-5,-1,-1,2,-2,-3};

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an index: ");
        int i = input.nextInt(), counter = 1;
        
        boolean flag = false; //True == > 0 : False == < 0
        
        //Looping through array starting from index i
        for(int x = i; x < a.length;x++){
            //Checking if first element is pos/neg
            if(x == i){
                if(a[x] > 0)
                    flag = true;
                else
                    flag = false;
            }
            else{
                if(a[x] > 0 && flag == true)
                    break;
                else if(a[x] < 0 && flag == false)
                    break;
                else{
                    counter++;
                    if(a[x] > 0)
                        flag = true;
                    else
                        flag = false;
                }
                    
            }
        }
        
        System.out.println("The longest substring of alternating elements at index '" + i + "' is: " + counter);
     }     
}
