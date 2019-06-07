package Homework_1_Part_1;

import java.util.Scanner;

/**
 *
 * @author Mario Bolivar - mjb160330
 * 
 * This program prompts the user for dimensions  and coordinates
 * of two rectangles and determines whether the second rectangle 
 * is inside the first or overlaps with the first
 * 
 */
public class Homework_1_Part_1 {

    public static void main(String[] args) {
        
        //input Scanner object
        Scanner input = new Scanner(System.in);
        
        //Variables
        double Xcoord1,Ycoord1,Xcoord2,Ycoord2,Width1,Width2,Height1,Height2;
        
        //Gathering rectangle information from user input
        System.out.print("Please enter the center coordinates for the first rectangle -- x y: ");
        Xcoord1 = input.nextDouble();
        Ycoord1 = input.nextDouble();
        
        System.out.print("Please enter the width and height of the first rectangle -- w h: ");
        Width1 = input.nextDouble();
        Height1 = input.nextDouble();
        
        System.out.print("Please enter the center coordinates for the second rectangle -- x y: ");
        Xcoord2 = input.nextDouble();
        Ycoord2 = input.nextDouble();
        
        System.out.print("Please enter the width and height of the second rectangle -- w h: ");
        Width2 = input.nextDouble();
        Height2 = input.nextDouble();
        
        //Calculating bottom left and top right vertexes of both rectangles
        //for determining if they overlap or not
        double x1,x2,x3,x4,y1,y2,y3,y4;
        x1 = Xcoord1 - (Width1 / 2);
        x2 = Xcoord1 + (Width1 / 2);
        x3 = Xcoord2 - (Width2 / 2);
        x4 = Xcoord2 + (Width2 / 2);
        
        y1 = Ycoord1 - (Height1 / 2);
        y2 = Ycoord1 + (Height1 / 2);
        y3 = Ycoord2 - (Height2 / 2);
        y4 = Ycoord2 + (Height2 / 2);
        
        //Output based on if rectangles are overlapping or not
        if(x3 > x2 || x1 > x4 || y3 > y2 || y1 > y4){
            System.out.println("The second rectangle is not inside nor overlaps with the first. ");
        }else if(x1 < x3 && y1 < y3 && x2 > x4 && y2 > y4){
           System.out.println("The second rectangle is inside the first.");            
        }else if(x1 == x3 && y1 == y3 && x2 == x4 && y2 == y4){
           System.out.println("Both rectangles are the same size and are at the same coordinate location. ");            
        }else{
           System.out.println("The second rectangle overlaps with the first. ");            
        }        
    }
    
}
