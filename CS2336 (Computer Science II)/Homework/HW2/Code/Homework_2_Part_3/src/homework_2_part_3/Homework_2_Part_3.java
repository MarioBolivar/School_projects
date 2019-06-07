package homework_2_part_3;
import java.util.Scanner;
/**
 *
 * @author Mario Bolivar - mjb160330
 * This program prompts the user to enter two 3 x 3 matrices and displays the product of the two matrices
 */
public class Homework_2_Part_3 {

    public static void main(String[] args) {
 
        //Scanner object for input
        Scanner input = new Scanner(System.in);
        
        //two two-dimensional arrays for the 3x3 matrices
        int [][] matrixOne = new int[3][3];
        int [][] matrixTwo = new int[3][3];
        
        //Method that prompts user for two matrices and fills
        //them in based off of user input
        fillMatrix(matrixOne,matrixTwo,input);
        
        //Method to calculate product of the two inputted matrices 
        //and display that product
        displayMatrixProduct(matrixOne,matrixTwo);
        
    }

    //Method to calculate product of the two inputted matrices 
    //and display that product    
    public static void displayMatrixProduct(int [][] matrixUno, int[][] matrixDos){
        
        //2-dimensional array for 3x3 product matrix
        int [][] productMatrix = new int[3][3];
        int sum = 0;
        
        //Calculating product matrix
            for(int y = 0; y < 3; y++){
                
                for(int i = 0; i < 3; i++){

                    for(int j = 0; j < 3; j++){
                        
                        sum += matrixUno[y][j] * matrixDos[j][i];
                    
                    }
                    
                     productMatrix[y][i] = sum;
                     sum = 0;
                
                }
            }
        
        //Displaying product matrix
        System.out.println("The product matrix is:\n");
        for(int x = 0; x < 3; x++){
            
            for(int y = 0; y < 3; y++){
                System.out.printf("%10d",productMatrix[x][y]);
            }
            System.out.println("");
        }
        System.out.println("");
    
    }

    
    //Method that prompts user for two matrices and fills
    //them in based off of user input    
    public static void fillMatrix(int [][] matrixUno,int[][] matrixDos,Scanner input){
    
        //Filling in two 3x3 matrices from user input
        System.out.println("_Note: Matrix values must be of Integer type _\n");
        System.out.print("Please enter the first row values for matrix #1 (x1 x2 x3): ");
        for(int i = 0; i < 3; i++){
            matrixUno[0][i] = input.nextInt();
        }
        
        System.out.print("Please enter the second row values for matrix #1 (x4 x5 x6): ");
        for(int i = 0; i < 3; i++){
            matrixUno[1][i] = input.nextInt();
        }
        
        System.out.print("Please enter the third row values for matrix #1 (x7 x8 x9): ");
        for(int i = 0; i < 3; i++){
            matrixUno[2][i] = input.nextInt();
        }
        
        System.out.print("Please enter the first row values for matrix #2 (y1 y2 y3): ");
        for(int i = 0; i < 3; i++){
            matrixDos[0][i] = input.nextInt();
        }
        
        System.out.print("Please enter the second row values for matrix #2 (y4 y5 y6): ");
        for(int i = 0; i < 3; i++){
            matrixDos[1][i] = input.nextInt();
        }
        
        System.out.print("Please enter the third row values for matrix #2 (y7 y8 y9): ");
        for(int i = 0; i < 3; i++){
            matrixDos[2][i] = input.nextInt();
        }
     
        
        
    }
}
