package Paradox;

import java.io.File;
import java.util.Scanner;
import java.util.regex.*;


/**
 *
 * @author Mario Bolivar - Mjb160330
 */
public class Main {

    public static void main(String [] args){
    
        String inputFileName = "integrals.txt";
        BST binarySearchTree = new BST();
        
        input(inputFileName, binarySearchTree);
        
    
    }
    
    
    public static void input(String inputFileName, BST binarySearchTree){

        //File variable that will be used to check if the file exists
        //and if it can be read from
        File inputFile = new File(inputFileName);
        
        //Checks if file exists
        if(inputFile.exists()){
            
            //If file cannot be read from, display error and terminate program.
            if(!inputFile.canRead()){
                System.out.println(">File \"" + inputFileName + "\" cannot be read from.\n");
                System.out.println(">Please fix this error and restart the program.\n");
                System.exit(-1);
                
            //If file exists and can be read from, continue
            }else{
                
                //Scanner object 
                Scanner input = null;
                
                
                try{
                    //Creating Scanner object for input
                    input = new Scanner(inputFile);
                }catch(Exception ex){
                     System.out.println(">Error: Program could not open \"" + inputFileName + "\"\n");
                     System.exit(-1);
                }
                
                //If file is empty, display error and terminate program
                if(!input.hasNextLine()){
                    System.out.println(">File \"" + inputFileName + "\" cannot be empty.\n"
                            + ">Please fill file \"" + inputFileName + "\" with data and restart the program.\n");
                    System.exit(-1);
                }
                
                fillBST(input,binarySearchTree);
            }
        }else{
            System.out.println(inputFileName + " does not exist!");
            System.exit(-1);
        }
        
    }
    
    public static void fillBST(Scanner input, BST binarySearchTree){
        
        boolean defaultBounds = false;
        String currentLine, integrands;
        int terms = 0, coefficient = 1, exponent = 1, boundA = 1, boundB = 1;
        
        //While file has a next line
        while(input.hasNextLine()){
            
            try{
                //Get current line
                currentLine = input.nextLine();

                //Parse out the bounds
                if(currentLine.charAt(0) != '|'){
                    boundA = Integer.parseInt(currentLine.substring(0,currentLine.indexOf('|')));
                    boundB = Integer.parseInt(currentLine.substring(currentLine.indexOf('|')+1,currentLine.indexOf(" ")));
                }else
                    defaultBounds = true;


                
                //Parse out the integrands
                integrands = currentLine.substring(currentLine.indexOf(" "), currentLine.length()-3);
                
                //Remove all whitespaces for regex matching purposes
                integrands = integrands.replaceAll("\\s+","");
                //Compile the regex pattern
                Pattern pattern = Pattern.compile("(?<coe>(-?(\\d+)?))x(\\^(?<exp>(-?\\d+)))?|(?<dig>(-?\\d+))");
                
                //Match the pattern with the integrand strings
                Matcher matcher = pattern.matcher(integrands);
                
                while(matcher.find()){
                    terms++;
                    //If coefficient and exponent both exist
                    if(matcher.group("coe") != null && matcher.group("exp") != null){
                        coefficient = Integer.parseInt(matcher.group("coe"));
                        exponent = Integer.parseInt(matcher.group("exp"));
                    }
                    
                    //If only coefficient exists
                    else if(matcher.group("coe") != null){
                         coefficient = Integer.parseInt(matcher.group("coe"));
                         exponent = 1;
                    }
                    
                    //If only exponent is defined
                    else if(matcher.group("exp") != null){
                        coefficient = 1;
                        exponent = Integer.parseInt(matcher.group("exp"));
                    }
                    
                    //If integrand is a digit
                    else{
                        coefficient = Integer.parseInt(matcher.group("dig"));
                        exponent = -99;
                    } 
                
                }
                   
                for(int i = 0;i < terms; i++){
                    
                }
                binarySearchTree.inorderTraversal();
                System.out.println(binarySearchTree.search(-99));
            }catch(Exception e){
                continue;
            }
            
            
        }
    }
}