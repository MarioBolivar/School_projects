package homework5;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Mario Bolivar - Mjb160330
 * 
 */

//This program reads two files and stores their character input in nodes,
//Then adds the nodes to two different queues.
//Then, the program compares each node in both queues.
//If both queues are identical, then the both input files are the same
//And a message is displayed.
//If the queues are different, then another message is displayed 
public class Homework5_PartTres{
    public static void main(String [] args){
    
        try{
    
            //Creating the two input file objects
            File inputFile1 = new File("input1.txt");
            File inputFile2 = new File("input2.txt");

            //Creating two scanners for the two files
            Scanner input1 = new Scanner(inputFile1);
            Scanner input2 = new Scanner(inputFile2);
            
            //Creating two queues for file input
            QueueClass queue1 = new QueueClass();
            QueueClass queue2 = new QueueClass();
            
            //Fill both queues with their respective file content
            fillQueue(input1, queue1);
            fillQueue(input2, queue2);

            //Check if queues match and display output
            matchQueues(queue1,queue2);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    
    //Method that fills a queue from file input
    public static void fillQueue(Scanner input, QueueClass queue){
        
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
   
    public static void matchQueues(QueueClass queue1, QueueClass queue2){
        
        //Variables
        Node n1 = null, n2 = null;
        boolean match = true;
        
        do{
            
            //Remove first node from both queues
            n1 = queue1.removeNode();
            n2 = queue2.removeNode();
            
            //If either node is null, break
            if(n1 == null || n2 == null){
                
                //If only one of the nodes is null, then they are not the same
                if((n1 == null && n2 != null) || (n1 != null && n2 == null)){
                    match = false;
                }
                break;
            }
            
            //If for every node, both nodes are not the same, break and set match to false
            if(n1.getChar() != n2.getChar()){
                match = false;
                break;
            }
            
            
        }while(true); //If statements break when queues are empty so while(true) is fine.
        //Could probably be better structured, but it's fine.
        
        //Display output
        if(match){
            System.out.println("Files are identical!");
        }else{
            System.out.println("Files are not identical.");
        }
        
    }
}
