package homework_8;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 *  @author Mario Bolivar - Mjb160330
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
    public boolean[] DFS(){
        return DFSHelper(1);
    }
    
    private boolean[] DFSHelper(int source){
        
        Stack<Integer> stack = new Stack();
        boolean [] visited = new boolean[currentSize];
        
        visited[source-1] = true;
        
        int i, element;
        
        stack.push(source-1);
        
        while(!stack.isEmpty()){
            element = stack.pop();
            i = 0;
            
            while(i <= currentSize){
                if(graphMatrix[element][i] == 1 && visited[i] == false){
                    stack.push(i);
                    visited[i] = true;
                }
                i++;
            }
        }
        return visited;
    }
    
    public boolean isConnnected(){
        boolean [] check = DFS();
        boolean flag = true;
        
        for (boolean j : check){
                if(j != true){
                    flag = false;
                    break;
                }
        }
        
        if(flag)
            return true;
        else
            return false;
    } 
}
