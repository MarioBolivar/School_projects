package tiefighter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static java.lang.Math.abs;
import java.util.Scanner;


/**
 *
 * @author Mario Bolivar - mjb160330
 * 
 * This program reads pilot coordinate data from a text file and calculates
 * the area that each pilot is patrolling. Each pilots name and area being patrolled is outputted 
 * to another text file, respectively.
 * 
 */
public class Main{
    public static void main(String[] args) throws Exception{
        
        //Creating arrays to store pilot and route information 
        String [] pilotNamesArr = new String[20];
        double [][][] coordinateArr = new double[20][16][2];
        
        //Array to store how many coordinates there actually was per pilot
        //Might be an easier/better way to design program but this made sense to me
        int rowIndexes[] = new int[20];
        
        //Method to check if pilot_routes.txt is a valid file 
        checkFile(pilotNamesArr, coordinateArr,rowIndexes);
        outputArea(pilotNamesArr,coordinateArr,rowIndexes);
        
    }
    
    //Method to check if pilot_routes.txt is a valid file 
    //and that calls another method to import data from the file if possible
    public static void checkFile(String [] pilotNamesArr,double [][][] coordinateArr,int [] rowIndexes)throws Exception{
        
        //File variable that will be used to check if the file exists
        //and if it can be read from
        File inputFile = new File("pilot_routes.txt");
        
        //Checks if file exists
        if(inputFile.exists()){
            
            //If file cannot be read from, display error and terminate program.
            if(!inputFile.canRead()){
                System.out.println(">File \"pilot_routes.txt\" cannot be read from.\n");
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
                     System.out.println(">Error: Program could not open \"pilot_routes.txt\"\n");
                     System.exit(-1);
                }
                
                //If file is empty, display error and terminate program
                if(!input.hasNextLine()){
                    System.out.println(">File \"pilot_routes.txt\" cannot be empty.\n"
                            + ">Please fill file \"pilot_routes.txt\" with data and restart the program.\n");
                    System.exit(-1);
                }
                
                //Calling method to import file contents
                importFileContents(input, pilotNamesArr,coordinateArr,rowIndexes);
                
            }
            
        //If file does not exist, display error message and terminate program
        }else{
            System.out.println(">File \"pilot_routes.txt\" does not exist.\n");
            System.out.println(">Please add the file to the directory and restart the program.\n");
            System.exit(-1);
        }
        
    }
    
    //Method to import data from pilot_routes.txt
    public static void importFileContents(Scanner input,String [] pilotNamesArr,double [][][] coordinateArr,int [] rowIndexes){
        
        //Temporary variables to store imported file content
        String rawCoords,firstCoords = "",temp;
        int index;
        
        
        //There can only be up to 20 pilots so loop through 20 iterations
        for(int i = 0; i < 20; i++){
            
            //If file has a next line, continue
            if(input.hasNext()){
                
                //imported pilotName
                pilotNamesArr[i] = input.next();
                
                
                //There can only be up to 16 coordinates so loop through 16 iterations
                for(int j = 0; j < 16; j++){
                    
                    //Import coordinate set
                    rawCoords = input.next();
                    
                    
                    
                    //If at first coordinate, save that coordinate
                    //to check for last coordinate
                    if(j == 0)
                        firstCoords = rawCoords;
                    
                    //Else, check if current coordinate is the last
                    else{
                        
                        //If the current coordinates are the same as the first set
                        if(rawCoords.equals(firstCoords)){
                            
                            //Assigning last coordinate the first coordinate's x-value
                            coordinateArr[i][j][0] = coordinateArr[i][0][0];
                            
                            //Assigning last coordinate the first coordinate's y-value
                            coordinateArr[i][j][1] = coordinateArr[i][0][1]; 
                            
                            //break from loop
                            break;
                        
                        }    
                        
                        
                    }
                    
                    //Keeping count of how many coordinates there actually are per pilot
                    rowIndexes[i]++;
                    
                    //Variable to check if last line has a newline char
                    boolean checkForNewLine = false;
                    
                    //Index of comma, used for parsing string that contains x and y coordinates
                    index = rawCoords.indexOf(',');
                    
                    //Extracting x-coordinate from string
                    temp = rawCoords.substring(0,index);
                    
                    //Parsing x-coordinate to a double 
                    double xCoord = Double.parseDouble(temp);
                    
                    //Assigning x-coordinate into the array, respectively
                    coordinateArr[i][j][0] = xCoord;
                    
                     //Extracting y-coordinate from string
                     temp = rawCoords.substring(index+1);
                    
             
                    //Parsing y-coordinate to a double 
                    double yCoord = Double.parseDouble(temp);

                    //Assigning y-coordinate into the array, respectively
                    coordinateArr[i][j][1] = yCoord;
                    
                    if(checkForNewLine){
                        break;
                    }
                    
                }
            
            //If file does not have another line, break from loop and continue code
            }else{
                break;
            }
        }
        
        //Closing input stream to file
        input.close(); 
    }
    
    //Method to calculate and output area of each pilot
    public static void outputArea(String [] pilotNamesArr,double [][][] coordinateArr,int[] rowIndexes){
        
        //Creating output file
        File outputFile = new File("pilot_areas.txt");
        
        //If file exists, delete the file to create it again
        if(outputFile.exists()){
            System.out.println(">\"pilot_areas.txt\" already exists.\n");
            try{
                System.out.println(">Program will now try to delete the file and recreate it..\n");
                outputFile.delete();
                System.out.println(">Program successfully recreated the file \"pilot_areas.txt\"\n");
            }catch(Exception ex){
                System.out.println(">Program could not delete the file \"pilot_areas.txt\"\n"
                        + "\n>Please delete the file \"pilot_areas.txt\"and restart the program.\n");
                System.exit(-1);
            }
        }
        
        PrintWriter output = null;
        
        try{
            output = new PrintWriter(outputFile);
        }catch(Exception ex){
            System.out.println(">Error: Program could not create \"pilot_areas.txt\"\n");
            System.exit(-1);
        }
        
        //Temporary values to check end of each pilot's coordinate set
        double firstXCoord = 0, firstYCoord = 0;

        //There can only be up to 20 pilots so loop through 20 iterations
        for(int i = 0; i < 20; i++){
            double area = 0;
            //If there is no next pilot, break and end program
            if(pilotNamesArr[i] == null){
                break;
            }
            
            //If pilot had less than 3 coordinates
             if(rowIndexes[i] < 3){
                    
                    output.println(pilotNamesArr[i] + "\t>Not enough coordinates to calculate area.");
                    System.out.println(pilotNamesArr[i] + "\t >Not enough coordinates to calculate area.");
                    
            }else{
                 
                    //Loop through number of coordinates for current pilot
                    for(int j = 0; j < (rowIndexes[i]); j++){
                 

                        //If first coordinate set, assign temp values for later checking
                        if(j == 0){
                            firstXCoord = coordinateArr[i][j][0];
                            firstYCoord = coordinateArr[i][j][1];
                        }

                        //If first coordinate set does not equal the current one, continue summing the area.
                        //Else, break from current pilot and move to the next if applicable
                        if(j != 0 && coordinateArr[i][j][0] == firstXCoord && coordinateArr[i][j][1] == firstYCoord)
                            break;
                        else{
                          System.out.println("(X2: " + coordinateArr[i][j+1][0] + " + X1: " + coordinateArr[i][j][0] + ")"+ "*(Y2: " + coordinateArr[i][j+1][1] + "- Y1: "   + coordinateArr[i][j][1] + ")");
                            area += ((coordinateArr[i][j+1][0] + coordinateArr[i][j][0]) * (coordinateArr[i][j+1][1] - coordinateArr[i][j][1]));    
                            System.out.println(area);
                        }

                    }

                    area = .5 * abs(area);

                    //output to console (for reference)
                    //output to file (for grade)
                    System.out.printf("%s\t%.2f\n",pilotNamesArr[i],area);
                    output.printf("%s\t%.2f\r\n",pilotNamesArr[i],area);
             }
            
            
                
            
        }
        
        //Close output file connection
        System.out.println();
        output.close();
        
    }
}

