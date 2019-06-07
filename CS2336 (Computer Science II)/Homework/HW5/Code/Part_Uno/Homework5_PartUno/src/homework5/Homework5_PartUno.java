package homework5;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Mario Bolivar - Mjb160330
 *
 */

//This Program reads characters from a file, stores them in a node, pushes the node into a stack, 
//And pops the nodes from the stack to then display the characters in the nodes.
public class Homework5_PartUno {

    public static void main(String[] args) {
        
        
        int David_Tennant;
        double Matt_Smith;
        Double eleventh = 11.50;
David_Tennant = eleventh.intValue();

        
        System.out.println(David_Tennant);
        
        
        //Try to open the files and catch exception if thrown
        try{
            
            //Create stack object
            StackClass stack = new StackClass();
            
            //File to read from
            File inputFile = new File("input.txt");
            
            //Initialize Scanner connection with file
            Scanner input = new Scanner(inputFile);
            
            //Call method to fill the stack with file input
           fillStack(input,stack);
           
           //File to output to
           File outputFile = new File("output.txt");
           
           //Printwriter object to write to file
           PrintWriter output = new PrintWriter(outputFile);
           
           //Call method to display stack contents
           displayStack(output,stack);
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }

    public static void fillStack(Scanner input,StackClass stack){
        
        //Fill the stack with file characters
        while(input.hasNext()){
            char [] arr = input.next().toCharArray();
            
            for(char c : arr){
                Node n = new Node(c);
                stack.push(n);
            }
        }
        
        //Close input stream
        input.close();
    }
    
    public static void displayStack(PrintWriter output,StackClass stack){
        
        
        Node n = null;
        do{
            n = stack.pop();
            if(n == null){
                System.out.println("\nThe stack is empty");
            }else{
                output.print(n.getChar());
                System.out.print(n.getChar());
            }
        }while(n != null);
        
        output.close();
        
   }
}
