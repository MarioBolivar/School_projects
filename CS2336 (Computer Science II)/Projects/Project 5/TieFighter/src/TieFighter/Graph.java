package TieFighter;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

/**
 *
 *  @author Mario Bolivar - Mjb160330
 *  
 * 
 */

public class Graph {
    public int [][] graphMatrix;
    int currentSize;
    int maxSize;
    
    //Default cstr
    public Graph(){
        maxSize = 10;
        graphMatrix = new int[maxSize][maxSize];
    }
    
    //Overloaded cstr
    public Graph(int size){
        maxSize = size;
        currentSize = size;
        graphMatrix = new int[maxSize][maxSize];
       
        for(int [] e: graphMatrix){
            Arrays.fill(e, -1);
        }
    }
    
    //Creates a graph by reading a formatted file and filling matrix from data in file
    public void createGraph(String fileName){
        
        try{
            
            //Create file input scanner
            Scanner fileInput = new Scanner(new File(fileName));
           
            //Fill in the matrix
            while(fileInput.hasNextLine()){
                
                //Get the current line of the file
                String currentLine = fileInput.nextLine();
                
                //Split the line by whitespaces into an array
                String[] split = currentLine.split(" ");
                
                int currVertex = Integer.parseInt(split[0]);
                
                for(int j = 1; j < split.length; j++){
                    
                    int indxComma = split[j].indexOf(',');
                    int currAdjVertex = Integer.parseInt((split[j].substring(0,indxComma)));
                    int weight = Integer.parseInt((split[j].substring(indxComma+1,split[j].length())));
                    
                    graphMatrix[currVertex-1][currAdjVertex-1] = weight;
                    
                }
                
            }
            
            fileInput.close();
        }catch(Exception e){
          System.out.println(e);  
        }
        
        //Outputting graph to console for debugging/viewing matrix
        for(int x = 0; x <= 35; x++){
           
            if(x == 0)
                System.out.print("    ");
            else if(x > 8)
                System.out.print(x + "  ");
            else
                System.out.print(x + "   ");
            
        }
        //Outputting graph to console for debugging/viewing matrix
        for(int i = 0; i < currentSize; i++){
            
            System.out.println();
            for(int j = 0; j < currentSize; j++){
                
               if(j == 0){
                        
                   
                        if(graphMatrix[i][j] > 0){
                            if(i >= 9){
                                System.out.print(i+1 + "  " + graphMatrix[i][j] + "  ");
                            }
                            else
                                System.out.print(i+1 +  "   " + graphMatrix[i][j] + "  ");
                        }
                        else{
                            if(i >= 9){
                                System.out.print(i+1 + " " + graphMatrix[i][j] + "  ");
                            }
                            else
                                System.out.print(i+1 + "  " + graphMatrix[i][j] + "  ");
                        }
                            
               }
               else if(graphMatrix[i][j] > 0)
                    System.out.print(" " + graphMatrix[i][j] + "  ");
               else     
               System.out.print(graphMatrix[i][j] + "  ");
            }         
            
        }
        
        System.out.println("\n");
    }
}
