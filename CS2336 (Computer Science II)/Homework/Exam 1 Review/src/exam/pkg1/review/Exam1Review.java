package exam.pkg1.review;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author Mario Bolivar - Mjb160330
 *  This program is a test review for exam 1 for CS2336.002
 */

public class Exam1Review {

    public static void main(String[] args) /*throws HexFormatException*/ {

        reverseReverse(12345678);
//        File inputFile = new File("input.txt");
//       File outputFile = new File("output.txt");
//        try{
//            Scanner input = new Scanner(inputFile);
//            PrintWriter output = new PrintWriter(outputFile);
//            doStuff(input,output);
//        }catch(Exception ex){
//            System.out.println(ex);
//            System.exit(-1);
//        }
//  
        
//        File inputFile = new File("input.txt");
//        
//        try{
//            Scanner input = new Scanner(inputFile);
//            readFile(input);
//        }catch(Exception ex){
//            System.out.println(ex);
//            System.exit(-1);
//        }
        
      
//        
//            String hexNum = "AFDx";
//            
//            try{
//                System.out.println(Integer.parseInt(hexNum,16));
//                
//            }catch(Exception ex){
//                throw new HexFormatException(hexNum);
//            }
    }
    
    public static void reverseReverse(int num){
        
       
        String s = Integer.toString(num);
       
        int index = s.length()-1;
        
        System.out.print(s.charAt(index));
        
        s = s.substring(0,index-1);
        num = Integer.parseInt(s);
        if(num != Integer.valueOf(s.charAt(0)))
            reverseReverse(num);
        
        
    }
    
    
//    public static String sort(String s){
//        
//        char []string = s.toCharArray();
//                
//        for(int i = 0; i < s.length()-1; i++){
//            int min = i;
//            
//            for(int j = i+1; j < s.length(); j++){
//                if(string[j] < string[i])
//                    min = j;
//            }
//            
//            char temp = string[min];
//            string[min] = string[i];
//            string[i] = temp;
//            
//        }
//                return String.valueOf(string);
//    }
//
//
//
//public static void doStuff(Scanner input, PrintWriter output){
//    
//    while(input.hasNext()){
//        output.println(sort(input.next()));
//    }
//    
//    input.close();
//    output.close();
//}

//    public static void readFile(final Scanner input){
//          int numLines = 0, numWords = 0, numChars = 0;
//        
//        //While file has a next line
//        while(input.hasNextLine()){
//            
//            numLines++;
//            
//            //Store file line
//            String temp = input.nextLine();
//            
//            //Split the line into words by whitespaces
//            String []parts = temp.split(" ");
//            
//            //for each word in the split array
//            for(String w : parts){
//                numWords++;
//            }
//                    
//            //Assuming whitespaces count as a character
//            numChars += temp.length();
//            
//        }
//        
//        System.out.println("NumChars: " + numChars);
//        System.out.println("NumWords: " + numWords);
//        System.out.println("NumLines: " + numLines);
//    }
//}

}