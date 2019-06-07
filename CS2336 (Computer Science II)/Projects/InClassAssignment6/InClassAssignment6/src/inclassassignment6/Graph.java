package inclassassignment6;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 *  @author Mario Bolivar - Mjb160330
 *  @author Zhen Zhang - Zxz152330
 *  Homework - 8
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
        graphMatrix = new int[maxSize][maxSize];
    }
    
    //Checks currentSize;
    public boolean isEmpty(){ 
        if(currentSize == 0)
            return true;
        else
            return false;
    }
    
    //Creates a graph by reading a formatted file and filling matrix from data in file
    public void createGraph(String fileName){
        
        try{
            
            //Create file input scanner
            Scanner fileInput = new Scanner(new File(fileName));
            
            //Get matrix size
            currentSize = Integer.parseInt(fileInput.nextLine());
            
            //Fill in the matrix
            for(int i = 0; i < currentSize; i++){
                
                //Get the current line of the file
                String currentLine = fileInput.nextLine();
                
                //Split the line by whitespaces into an array
                String[] split = currentLine.split(" ");
                
                //Skip the first element and fill in the neighbors
                for(int j = 1; j < split.length; j++){
                    graphMatrix[i][(Integer.parseInt(split[j]) -1)] = 1;
                }
            }
            
            fileInput.close();
        }catch(Exception e){
          System.out.println(e);  
        }
        
    }
    
    //Depth first search
    public boolean isBipartite(){
        return isBipartiteHelper(1);
    }
    
    private boolean isBipartiteHelper(int source){
        
        //Queue
        Queue<Integer> q = new LinkedList();
        
        int [] colors = new int[currentSize];
        
        colors[source-1] = 1;
        
        
        q.add(source-1);
        
        //While queue is not empty
        while(!q.isEmpty()){
           
            int element = q.remove();
            
            //So for the entire row, check nodes
            for(int i = 0; i < currentSize; i++){
                
                //If neighbor
                if(graphMatrix[element][i] == 1){
                    
                    //If it doesn't have a color (no color is 0), give it a color based on previous neighbor
                    if(colors[i] == 0){
                        colors[i] = (colors[element] == 1)? 2:1;
                        q.add(i);
                    }
                    //if the current neighbor has a color, and it is the same as the one before, return false
                    if(colors[i] > 0 && colors[element] == colors[i]){
                        return false;
                    }  
                }
            }
        }
            
            return true;
    }
}

