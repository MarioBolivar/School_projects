package project.pkg5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 *
 *  @author Mario Bolivar - Mjb160330
 *  CE 3345.001 Data Structures and Algorithms
 *  Project 5 - Quicksort algorithm run-time examination 
 *
 */

public class Project5 {

    public static void main(String[] args) {
      
        //Initialize a randomNum object
        Random randomNum = new Random();
        int unsortedArr[];
        int arrSize = 0;
            
            do{ //Repeat until valid input is given and no exceptions are thrown

                try{ //Get valid input
                
                    Scanner input = new Scanner(System.in);
                    System.out.print("Please enter the size of the array to fill with random numbers for (Enter '-1' to exit): ");
                    arrSize = input.nextInt();

                    
                    if(arrSize == -1){
                        System.out.println(">Exiting..");
                        System.exit(0);
                    }

                    if(arrSize <= 0){ //If input is invalid, throw exception
                        throw new Exception("Invalid input.");
                    }

                }catch(Exception e){ //If input is invalid, continue to next iteration and try again.
                
                    System.out.println(e.toString() + " >Error: Please try again.\n\n");
                    continue;
                }
            
                try{ //Try to fill array with generated pseudo-random numbers and output numbers to unsorted.txt

                    unsortedArr = new int[arrSize];
                    File unsortedFile = new File("unsorted.txt");
                    PrintWriter fileOut = new PrintWriter(unsortedFile);

                    fileOut.print("Unsorted random array: ");

                    for(int i = 0; i < arrSize; i++){ //Fill array and output to file.

                        unsortedArr[i] = randomNum.nextInt(999);
                        fileOut.print(unsortedArr[i] + " ");

                    }

                    fileOut.close(); //Close file stream
                    beginTest(unsortedArr, arrSize);
                    
                    System.out.println(">Please check output files.\n");


                }catch(FileNotFoundException e){
                    System.out.println(e.toString() + " >Error: Something went wrong.. Please try again.\n\n");
                }
                
            }while(true);    
    }
    
    
    public static void beginTest(int unsortedArr[],int arrSize){
                
        try{ //Try-catch in case any exceptions are thrown

            long beginningTime, endTime, result;
            File outFile = new File("sorted.txt");
            PrintWriter outputFile = new PrintWriter(outFile);

            int unsortedArr2[] = new int[arrSize];
            int unsortedArr4[] = new int[arrSize];
            int unsortedArr3[] = new int[arrSize];

            //Creating and filling copies of pseudo-random array
            for(int i = 0; i < arrSize; i++){
                unsortedArr2[i] = unsortedArr[i];
                unsortedArr3[i] = unsortedArr[i];
                unsortedArr4[i] = unsortedArr[i];
            }

            //First element as pivot
            beginningTime = System.nanoTime();
            quicksort(unsortedArr,0,arrSize-1,1); //Sorts array and outputs the sorted array to file
            endTime = System.nanoTime();

            result = endTime - beginningTime;

            printArr(unsortedArr,outputFile);

            //Close output file stream
            outputFile.close();
            
            //Output results to console and File
            System.out.println("The quicksort with first element as the pivot took '" + (result) + "ns' to sort the array.");


            //Randomly generating a pivot (0 - arraySize)
            beginningTime = System.nanoTime();
            quicksort(unsortedArr2,0,arrSize-1,2); //Sorts array and outputs the sorted array to file
            endTime = System.nanoTime();

            result = endTime - beginningTime;

            //Output results to console and file
            System.out.println("The quicksort with a randomly generated pivot (0 - array size)  took '" + (result) + "ns' to sort the array.");



            //Generating a pivot from the median of the sum of three random numbers (0 - arraySize)
            beginningTime = System.nanoTime();
            quicksort(unsortedArr3,0,arrSize-1,3);
            endTime = System.nanoTime();

            result = endTime - beginningTime;

            //Output results to console and file
            System.out.println("The quicksort using the the median of the sum of three random numbers (0 - array size) as pivot took '" + (result) + "ns' to sort the array.");




            beginningTime = System.nanoTime();
            quicksort(unsortedArr4,0,arrSize-1,4);
            endTime = System.nanoTime();

            //Choosing the median of first center and last element as the pivot
            result = endTime - beginningTime;

            //Output results to console and file
            System.out.println("The quicksort using the median of first center and last element as the pivot took '" + (result) + "ns' to sort the array.");
            
        }catch(FileNotFoundException e){ //Catch any Exceptions
            System.out.println(e.toString() + " >Error: Something went wrong. Please try again.\nExiting..");
        }
    }
    //Quicksort method -- takes in unsorted array,low, high and pivot flag, and output file stream  -- prints sorted array to output file
    public static void quicksort(int arr[], int a, int b,int flag) 
    { 
        Random randomNum = new Random();
        
        if(a >= b)
            return;
        
        int left = a;
        int right = b-1;
        int temp;
        int pivot;
        
        if(flag == 1){ //Using first element as pivot
            
            pivot = arr[b];
            
        }else if(flag == 2){ //Randomly generating a pivot (0 - arraySize)
            
            pivot = arr[randomNum.nextInt(b)]; 
            
        }else if(flag == 3){ //Generating a pivot from the median of the sum of three random numbers (0 - arraySize)
            
             pivot = arr[((randomNum.nextInt(b) + randomNum.nextInt(b) + randomNum.nextInt(b)) / 3)];
            
        }else{ //Choosing the median of first center and last element as the pivot
          
            pivot = arr[(((b - 1) / 2) + (b - 1)) / 2];
        
        }
        
        while(left <= right){
            
            while(left <= right && arr[left] < pivot) left++;
            
            while(left <= right && arr[right] > pivot) right--;
            
            if(left <= right){
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
      
        temp = arr[left];
        arr[left] = arr[b];
        arr[b] = temp;
        
        quicksort(arr,a,left-1,flag);
        quicksort(arr,left+1,b,flag);
        
    }
    
    
    public static void printArr(int arr[], PrintWriter outputFile){
        
        int length = arr.length;
        for(int i = 0; i < length; i++){
            
            outputFile.print(arr[i] + " ");
            
        }
        
        outputFile.println();
    }
}





