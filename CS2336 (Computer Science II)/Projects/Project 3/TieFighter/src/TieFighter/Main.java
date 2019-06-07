package TieFighter;

import java.io.File;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mario Bolivar - Mjb160330
 *
 * Merge sort Extra Credit:
 *  Implementation in LinkedList.java Lines: 82-154
 *  mergeSort function call in LinkedList.java Line: 61
 * 
 * 
 */
public class Main {

    public static void main(String[] args) {
      
        LinkedList list = inputPilotData("pilot_routes.txt");
        commandFile(list, "commands.txt");
   
    }
    
    public static LinkedList inputPilotData(String inputFileName){

        //File variable that will be used to check if the file exists
        //and if it can be read from
        File inputFile = new File(inputFileName);
        
        LinkedList list = null;
        
        
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
                
                int line = 1, num = 0;
                
                
                    
                //While not at the end of the file
                while(input.hasNextLine()){
                    
                    //Create arrayLists to store coordinate values
                    ArrayList<Double> xCoords = new ArrayList<>();
                    ArrayList<Double> yCoords = new ArrayList<>();
                    
                    //Variables
                    String currentWord, currentLine = "";
                    String pilotName = "";
                    String firstCoordPair = "";
                    
                    //Get the current line from file
                    currentLine = input.nextLine();
                    
                    try{
                        //Index variables
                        int left = 0,right = 0;
                            
                            //The first word has to be a pilot name so just go ahead and add it to the pilotName
                            right = currentLine.indexOf(' ');
                            pilotName += currentLine.substring(left,right) + " ";
                            right = currentLine.indexOf(' ',left + 1);
                            
                            while(true){ //While the current word does not contain a comma, add it to the pilot name
                                    
                                    //Extract pilot name from file
                                    left = right;
                                    right =  currentLine.indexOf(' ',left + 1);
                                    currentWord = currentLine.substring(left + 1,right);
                                    if(!currentWord.contains(","))
                                        pilotName += currentWord + " ";
                                    else
                                        break;
                          }
                            
                        
                        firstCoordPair = currentWord; //First coordinate 
                        pilotName = pilotName.trim();
                        if(!checkPilotName(pilotName)){ //Check if pilotName is valid
                            ++line;
                            continue;   //If not, skip to the next line
                        }
                        double x = RoundTo2Decimals(Double.parseDouble(firstCoordPair.substring(0,(firstCoordPair.indexOf(",")))));
                        double y = RoundTo2Decimals(Double.parseDouble(firstCoordPair.substring(firstCoordPair.indexOf(",") + 1,firstCoordPair.length())));
                              
                        //Add the first coordinate values to the arrayLists for calculations
                        xCoords.add(x);
                        yCoords.add(y);
                        
                        
                        while(true){ //While the current word does not contain a comma, add it to the pilot name
                            
                            //Whitespace index variables 
                            int comma = 0;
                            left = right;
                            right = currentLine.indexOf(' ',left + 1);
                            if(right < left)
                                currentWord = currentLine.substring(left+1,currentLine.length());
                            else
                                currentWord = currentLine.substring(left+1,right);
                            comma = currentWord.indexOf(',');

                            
                            if(!currentWord.equals(firstCoordPair)){
                               x = RoundTo2Decimals(Double.parseDouble(currentWord.substring(0,comma)));
                               y = RoundTo2Decimals(Double.parseDouble(currentWord.substring(comma + 1,currentWord.length())));
                                //Add coordinate values to the arrayLists for calculations
                                xCoords.add(x);
                                yCoords.add(y);
                            }else
                                break;
                                    
                        }
                        
                       if(xCoords.size() < 3)
                           continue;
                        
                       x = RoundTo2Decimals(Double.parseDouble(firstCoordPair.substring(0,firstCoordPair.indexOf(','))));
                       y = RoundTo2Decimals(Double.parseDouble(firstCoordPair.substring(firstCoordPair.indexOf(',')+1,firstCoordPair.length())));
                              
                         
                        xCoords.add(x);
                        yCoords.add(y);

                        //Calculate the area  that the pilot patrols
                        double area = calculateArea(xCoords,yCoords);
                        
                        //Create Payload object and fill object with pilot data
                        Payload p = new Payload(pilotName);
                        p.setPatrolArea(area);
                        
                        //Create Payload object and fill in with Payload data
                        Node<Payload> n = new Node<>(p);
                        
                        if(num == 0){
                            list = new LinkedList(n);
                        }else{
                            list.addNode(n);
                        }
                        ++num;
                        
                    }catch(Exception e){ //if an exception is thrown then we know the input file line was wrong
                        System.out.println("Line {" + line + "} in input file 1 is invalid.");
                        System.out.println(e);  
                    }
                }
            }
            
        //If file does not exist, display error message and terminate program
        }else{
            System.out.println(">File \"" + inputFileName + "\" does not exist.\n");
            System.out.println(">Please add the file to the directory and restart the program.\n");
            System.exit(-1);
        }
    
        return list;
    }
    
    //Validate the pilot name 
    public static boolean checkPilotName(String name){
        char [] arr = name.toCharArray();
        
        for(char c : arr){
            
            if(!Character.isLetter(c) &&  !(c == '-') && !(c == '\'') && !Character.isWhitespace(c)){
                return false;
            }
        }
        return true;
    }
    
    
    //Calculate the area of the pilots
    public static double calculateArea(ArrayList<Double> xCoords, ArrayList<Double> yCoords){
        
        int size = xCoords.size();
        double sum = 0;
        
        for(int i = 0; i <= size - 2; i++){
            sum+= (xCoords.get(i + 1) + xCoords.get(i)) * (yCoords.get(i+1) - yCoords.get(i));
        }
         return RoundTo2Decimals(Math.abs(sum) / 2);
    }
    
    
    public static void commandFile(LinkedList list, String inputFileName){
        //File variable that will be used to check if the file exists
        //and if it can be read from/written to
        File inputFile = new File(inputFileName);
        File outputFile = new File("results.txt");
        PrintWriter output = null;
        boolean noWhiteSpace = false;
        //Try to open the output stream
        try{
            output = new PrintWriter(outputFile);
        }catch(Exception e){
            System.out.println(e);
        }
        
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
                
                int line = 1, num = 0;
                
                
                    
                //While not at the end of the file
                while(input.hasNextLine()){
                   int left = 0, right = 0;
                  String currentLine = input.nextLine();
                  String command = "";
                  try{ //try to parse command
                         command = currentLine.substring(left,right = currentLine.indexOf(' '));
                        left = right;
                        right = currentLine.indexOf(' ',right+1);
                        
                  }catch(Exception e){ // if no whitespace, then command is a single word
                      command = currentLine;
                      command = command.trim();
                      noWhiteSpace = true;
                  }
                  command = command.trim();
                  //If command is sort.
                  if(command.equals("sort")){
                      String areaOrPilot = currentLine.substring(left + 1,right);

                      //If sort by area
                      if(areaOrPilot.equals("area")){
                          String ascOrDec = currentLine.substring(right+1,currentLine.length());
                          ascOrDec = ascOrDec.trim();
                          if(ascOrDec.equals("asc")){ //if sort by area ascending
                              list.sort(areaOrPilot, ascOrDec);
                          }else if(ascOrDec.equals("dec")){//if sort by area descending
                              list.sort(areaOrPilot, ascOrDec);
                          }else{//else, incorrect command, skip line.
                              continue;
                          }
                          
                          output.printf("%-20s%-6s%-14.2f%-6s%-14.2f\r\n", currentLine,"Head: ",((Payload)(list.head.getObj())).patrolArea,"Tail: ", ((Payload)list.tail.payloadObj).patrolArea);
                          
                          
                      }else if(areaOrPilot.equals("pilot")){ //If sort by pilot
                          String ascOrDec = currentLine.substring(right+1,currentLine.length());
                           ascOrDec = ascOrDec.trim();
                          if(ascOrDec.equals("asc")){ //if sort by area ascending
                             list.sort(areaOrPilot, ascOrDec); 
                          }else if(ascOrDec.equals("dec")){//if sort by area descending
                             list.sort(areaOrPilot, ascOrDec); 
                          }else{//else, incorrect command, skip line.
                              continue;
                          }
                          output.printf("%-20s%-6s%-14s%-10s%-10s\r\n", currentLine,"Head: ",((Payload)(list.head.getObj())).pilotName,"Tail: ", ((Payload)list.tail.payloadObj).pilotName);
                      }else{ //If neither, incorrect, skip command.
                          continue;
                      }
                  }else{
                      
                      boolean found = false;
                      command = command.trim();
                        //if command is a number search for it
                        if(command.matches("^-?[0-9]+\\.?[0-9]+$")){
                            double d = Double.parseDouble(command);
                            found = search(list,d);
                            
                            //Display result
                            if(found){
                                output.printf("%-20s%-20.2f%-20s\r\n", currentLine,d,"found");
                            }else{
                                output.printf("%-20s%-20.2f%-20s\r\n", currentLine,d,"not found");
                            }
                            
                        }else{ //if command is a valid pilot name, search.
                            
                            
                        while(true){ //While the current word does not contain a comma, add it to the pilot name

                           if(noWhiteSpace){
                               break;
                           }
                            
                            String currentWord;
                            right =  currentLine.indexOf(' ',left + 1);
                            
                             if(right < 0 || left < 0){
                                if(left < 0)
                                break;
                                else
                                   command += currentLine.substring(left,currentLine.length());
                                    
                            }else{
                                 command += currentLine.substring(left,right);
                             }
                            
                                    
                            left = right;
                        }
                            if(!checkPilotName(command)){ //Check if pilotName is valid
                                continue;   //If not, skip to the next line
                            }
                            found = search(list,command);
                            
                            //Display result
                            if(found){
                                output.printf("%-20s%-20s%-20s\r\n", currentLine,command,"found");
                            }else{
                                output.printf("%-20s%-20s%-20s\r\n", currentLine,command,"not found");
                            }
                        }
                  }
                }
                
                //Close input stream
                input.close();
            }
            
        //If file does not exist, display error message and terminate program
        }else{
            System.out.println(">File \"" + inputFileName + "\" does not exist.\n");
            System.out.println(">Please add the file to the directory and restart the program.\n");
            System.exit(-1);
        }
    
        //Close output stream
        output.close();
        
        //Write linked list to pilot_areas.txt
        try{
            PrintWriter outputPilotAreas = new PrintWriter("pilot_areas.txt");
            outputPilotAreas.print(list.toString());
            outputPilotAreas.close();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    //Generic search method built for strings and double values 
    public static <T> boolean search(LinkedList list,T value){
        Node temp = list.head;
        if(value instanceof String){ //If value is a string or pilot name, search
            
            while(temp.next != null){
                String currentPilot = ((Payload)(temp.payloadObj)).pilotName;
                String val = (String)value;
                //If pilot is found, return true
                if(currentPilot.equals(val)){
                    return true;
                }
                temp = temp.next;
            }
            
            //If pilot is not found, return false
            return false;
        }else{ //If value is a double or area, search
            
              while(temp != null){
                double area = (((Payload)temp.payloadObj).patrolArea);
                double val = (Double)value; 
                //If pilot is found, return true
                if(area == val){
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }
        
    }
    
    //Round to 2 decimals method
    public static  double RoundTo2Decimals(double val) {
            DecimalFormat df2 = new DecimalFormat("###.##");
        return Double.valueOf(df2.format(val));
}
}
