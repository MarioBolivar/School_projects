package homework5;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author mario
 * 
 */

//This program reads a file and stores the information as characters in node objects.
//Then, the nodes are added to a queue and then removed and displayed.
public class Homework5_PartDos {
     public static void main(String[] args) {
        
        //Try to open the files and catch exception if thrown
        try{
            
            //Create a queue object
            QueueClass queue = new QueueClass();
            
            //File to read from
            File inputFile = new File("input.txt");
            
            //Initialize Scanner connection with file
            Scanner input = new Scanner(inputFile);
            
            //Call method to fill the stack with file input
           fillQueue(input,queue);
           
           //File to output to
           File outputFile = new File("output.txt");
           
           //Printwriter object to write to file
           PrintWriter output = new PrintWriter(outputFile);
           
           //Call method to display stack contents
           displayQueue(output,queue);
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }

    public static void fillQueue(Scanner input,QueueClass queue){
        
        //Fill the queue with file characters
        while(input.hasNext()){
            
            //Create the current file input to a char array
            char [] arr = input.next().toCharArray();
            
            //Loop through char array and create a node for each char
            //Then, add the node to the queue
            for(char c : arr){
                
                Node n = new Node(c);
                
                queue.addNode(n);
            }
        }
        
        //Close input stream
        input.close();
    }


    public static void displayQueue(PrintWriter output, QueueClass queue){
            
        Node n = null;
        
        //Display queue nodes while queue is not empty
        do{
            
            n = queue.removeNode();
            
            //If queue is empty, display message
            if(n == null)
                System.out.println("\nQueue is empty.");
            else{    // Else, display node contents
                output.print(n.getChar());
                System.out.print(n.getChar());
            }
        }while(n != null);
        
        output.close();
        
    }
}