
package project.pkg3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
*
* @author Mario Bolivar - Mjb160330
* CE 3345.001 
*
*
* This program reads an input file specified via argument passed in
* and interacts with an implemented LazyBinarySearchTree class. 
* For every command read from input file, the results of the command
* are outputted to an outputfile also specified through console arguments.
*
*/


public class Project3 {

    public static void main(String[] args) {

       String inputFileName = args[0];
       String outputFileName = args[1];
       
       LazyBinarySearchTree tree = new LazyBinarySearchTree();
       
       try
       {
           
           //Try to create file streams
           File inputFile = new File(inputFileName);
           Scanner fileInput = new Scanner(inputFile);
           
           File outputFile = new File(outputFileName);
           PrintWriter fileOutput = new PrintWriter(outputFile);
           
           String inputData = "";
           
           while(fileInput.hasNextLine()){ //While file has next line
               
               inputData = fileInput.nextLine(); //Get next line in file
               
               int colonIndx = inputData.indexOf(':'); //Get index of colon
               
               if(colonIndx == -1){ //If no colon in line, check what operation it is from valid options
                   
                   if(inputData.equals("PrintTree")) //If PrintTree command 
                   {
                       fileOutput.println(tree.toString()); //Call toString method and output results to file.
                   } 
                   else if(inputData.equals("FindMin")) //If FindMin command
                   {
                       fileOutput.println(tree.findMin()); //Call findMin method and output results to file.
                   }
                   else if(inputData.equals("FindMax")) //If findMax command
                   {
                       fileOutput.println(tree.findMax()); //Call findMin method and output results to file.
                   }
                   else if(inputData.equals("Height")) //If Height command
                   {
                       fileOutput.println(tree.height()); //Call height method and output results to file.
                   }
                   else if(inputData.equals("Size")) //If Size command
                   {
                       fileOutput.println(tree.size()); //Call size method and output results to file.
                   }
                   else //If invalid command, output error message to file.
                   {
                       fileOutput.println("Error in Line: " + inputData);
                   }
               }
               else //Else check both sides of colon for input command and parameter
               {
                   String command,parameter; //Parsing both sides of the colon in the inputData
                   int key;
                   command = inputData.substring(0,colonIndx);
                   parameter = inputData.substring(colonIndx+1, inputData.length());
                   key = Integer.parseInt(parameter);
                   
                   if(command.equals("Insert")) //If insert command
                   {
                       try
                       {
                           fileOutput.println(tree.insert(key)); //Call insert method and output if Node was inserted to file.
                       }
                       catch(IllegalArgumentException e) //If key is invalid, catch exception and output error message to file.
                       {
                           fileOutput.println("Error in insertion: IllegalArgumentException raised");
                       }
                               
                   }
                   else if(command.equals("Delete")) //If Delete command
                   {
                        try
                       {
                           fileOutput.println(tree.delete(key)); //Call delete method and output if Node with given key was deleted
                       }
                       catch(IllegalArgumentException e) //If key is invalid catch exception and output error message to file
                       {
                           fileOutput.println("Error in deletion: " + e);
                       }
                   }
                   else if(command.equals("Contains")) //If Contains command
                   {
                        try
                       {
                           fileOutput.println(tree.contains(key)); //Call contains method and output to file if tree contains node with given key.
                       }
                       catch(IllegalArgumentException e)
                       {
                           fileOutput.println("Error in contains: " + e);
                       }
                   }
                   else //Else invalid input, output error message to file
                   {
                       fileOutput.println("Error in Line: " + inputData);
                   }
                   
               }
           }
           fileInput.close(); //Close input file stream
           fileOutput.close(); //Close output file stream
       }
       catch(IOException e) //Catch any input/output exceptions and print them
       {
           System.out.println(e);
       }
    }
}
