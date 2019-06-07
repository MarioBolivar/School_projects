
package TieFighter;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mario Bolivar - Mjb160330
 *
 */

public class Main {

    public static void main(String[] args) {
        
        //FileNames
        String galaxyFile = "galaxy.txt";
        
        //Get the graph size/matrix size
        int graphSize = getGraphSize(galaxyFile);
        
        //Create graph
        Graph graph = new Graph(graphSize);
        
        //Fill graph with information
        graph.createGraph(galaxyFile);
        
        //Create an array of pilotInfo objects to store pilot information
        PilotInfo[] pilotDataArr = getPilotRoutesData("pilot_routes.txt", graph);
        
        //Sort and output data
        sortedOutput(pilotDataArr,"patrols.txt");

    }
    
    public static int getGraphSize(String textFile){
        
        int currentSize = 10;
        try{
          //Create file input scanner
          Scanner getNumVertices = new Scanner(new File(textFile));

          while(getNumVertices.hasNextLine()){

              //Get current Line
              String curLine = getNumVertices.nextLine();

              //Extract current vertex
              int curVertex = Integer.parseInt((curLine.substring(0, curLine.indexOf(" "))));

              //If vertex is greater than current size of matrix, expand matrix
              if(currentSize < curVertex)
                  currentSize = curVertex;
          } 
          
          //Close input scanner
          getNumVertices.close();
        }catch(Exception e){
        System.out.println(e);  
        }
          
        return currentSize;
    }
    
    //Returns in an array of PilotInfo objects with pilot information
    public static PilotInfo[] getPilotRoutesData(String pilotRoutesFileName, Graph graph){
        
        //Get number of pilots
        int numPilots = getNumPilots(pilotRoutesFileName);
        
        PilotInfo[] pilotDataArr = new PilotInfo[numPilots];
        
        try{
            
            //Create file input scanner
            Scanner fileInput = new Scanner(new File(pilotRoutesFileName));
            int count = 0;
            //While file has a next line
            while(fileInput.hasNextLine()){
                
                
                //Pilot variables
                String pilotName = "";
                boolean validRoute = true;
                int pathLength = 0;
                
                //Get the current line from the file
                String currentLine = fileInput.nextLine();
                
                //Split the current line by white spaces into an array
                String[] currentParsedLine = currentLine.split(" ");
                
                //Go through current line array and verify pilot data
                for(int i = 0; i < currentParsedLine.length-1; i++){
                    try{
                        
                        //Try to parse the vertex, if it fails, then we know it's a pilot name
                        int currentVertex = Integer.parseInt(currentParsedLine[i]); //This only works because "All data is expected to be valid", Note: I would not do it this way if we had to validate data input
                        int nextVertex = Integer.parseInt(currentParsedLine[i+1]);
                       
                        //If not at the last vertex in the line
                        if(i != currentParsedLine.length - 1){
                            
                            //If the current and next vertices are connected
                            if(graph.graphMatrix[currentVertex-1][nextVertex-1] != -1){
                                pathLength += graph.graphMatrix[currentVertex-1][nextVertex-1]; //Add the weight to the path length
                            }
                            else{ //If the current vertex and the next vertex are not connected, break the loop and set valid route to false
                                validRoute = false;
                                pathLength = 0;
                                break;
                            }
                        }
                        
                    }catch(Exception e){
                        
                        pilotName += currentParsedLine[i] + " ";
                        
                    }
                }
                
                    //Cleanup the pilot name in case extra whitespace at the end
                    pilotName = pilotName.trim();
                    
                    //Create pilotinfo object
                    PilotInfo currentPilot = new PilotInfo(pilotName,validRoute,pathLength);
                    
                    //Add the current pilotinfo object into the array
                    pilotDataArr[count] = currentPilot;
                    
                    count++;
            }

            
            fileInput.close();
        }catch(Exception e){
          System.out.println(e);  
        }
        
        return pilotDataArr;
    }
    
    //Opens pilotRoutes file and returns the total number of lines/pilots
    public static int getNumPilots(String pilotRoutesFileName){
        
        int count = 0;
        
        try{
            
            //Create file input scanner
            Scanner fileInput = new Scanner(new File(pilotRoutesFileName));
            
            while(fileInput.hasNextLine()){
                String x = fileInput.nextLine();
                count++;
            }
            
            fileInput.close();
            
        }catch(Exception e){
          System.out.println(e);  
        }
    
        return count;
    }
    
    public static void sortedOutput(PilotInfo [] pilotInfoArr, String outputFileName){
        
        
        
        
        //Creating an output file
        File outputFile = new File(outputFileName);
      
        if(outputFile.exists()){
            System.out.println(">\"" + outputFileName + "\" already exists.\n");
            try{
                System.out.println(">Program will now try to delete the file and recreate it..\n");
                outputFile.delete();
                System.out.println(">Program successfully recreated the file \"" + outputFileName + "\"\n");
            }catch(Exception ex){
                System.out.println(">Program could not delete the file \"" + outputFileName + "\"\n"
                        + "\n>Please delete the file \"" + outputFileName + "\"and restart the program.\n");
                System.exit(-1);
            }
        }
        
        try{
            
            //Opening the printwriter stream
            PrintWriter output = new PrintWriter(outputFile);
            
            output.printf("%-15s %-10s %15s\r\n","Pilot Name","Valid Route","Route Length" );
            
            //Sorting the initial array
            int arrLength = pilotInfoArr.length;
            for(int i = 0; i < arrLength-1;i++){
                for(int j = 0; i < arrLength-i-1; i++){
                    if(pilotInfoArr[j].routeLength > pilotInfoArr[j+1].routeLength){
                        PilotInfo temp = pilotInfoArr[j];
                        pilotInfoArr[j] = pilotInfoArr[j+1];
                        pilotInfoArr[j+1] = temp;
                    }  
                }
            }

            //Getting the number of invalid pilot routes for secondary array +
            //Outputting valid routes
            int numInv = 0;
            for(int k = 0; k < arrLength;k++){
                if(pilotInfoArr[k].validRoute == false)
                    numInv++;
                else{
                    output.printf("%-15s %-10s %15d\n",pilotInfoArr[k].name,pilotInfoArr[k].validRoute,pilotInfoArr[k].routeLength);
                    output.print("\r\n");
                }
                    
            }

            //Creating invalid array
            PilotInfo[] invalidArr = new PilotInfo[numInv];
            
            //Filling in the invalid array
            int countn = 0;
            for(int l = 0; l < arrLength;l++){
                if(pilotInfoArr[l].validRoute == false){
                    invalidArr[countn] = pilotInfoArr[l];
                    countn++;
                }
            }
            
            //Sort invalid array
            int invalidArrLength = invalidArr.length;
            for(int i = 0; i < invalidArrLength-1;i++){
                for(int j = 0; i < invalidArrLength-i-1; i++){
                    if(pilotInfoArr[j].name.compareTo(pilotInfoArr[j+1].name) < 0){
                        PilotInfo temp = invalidArr[j];
                        invalidArr[j] = invalidArr[j+1];
                        invalidArr[j+1] = temp;
                    }  
                }
            }
            
            //Print invalid array
            for(PilotInfo x: invalidArr){
                output.printf("%-15s %-10s %15s\n",x.name,x.validRoute,"N/A");
                output.print("\r\n");
            }
            
            output.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
}
