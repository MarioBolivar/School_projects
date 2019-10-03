
package Homework_9;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mario Bolivar - Mjb160330
 *
 */

public class Main {

    public static void main(String[] args) {
        int [] array1 = new int[5000];
        int [] array2 = new int[5000];
        int [] array3 = new int[5000];
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        ArrayList<Integer> arrayList3 = new ArrayList<>();
        
        for(int i = 0; i < 5000; i++){
            Random rand = new Random();
            int num = rand.nextInt(1000000);
            array1[i] = num;
            array2[i] = num;
            array3[i] = num;
            arrayList1.add(num);
            arrayList2.add(num);
            arrayList3.add(num);
        }
        
        
        
        bubbleSort(array1);
        selectionSort(array2);
        arrInsertionSort(array3);
        
        int comparisons = 0, assignments = 0;
        quickSort(arrayList1, 0,arrayList1.size()-1,comparisons,assignments);
        System.out.println("Quick Sort - comparisons: " + comparisons + " assignments: " + assignments);
        for(int i = 0; i < arrayList1.size()-1; i++){
            System.out.print(arrayList1.get(i) + " ");
        }
    }
    
    public static void bubbleSort(int [] arr){
        int len = arr.length;
        int comparisons = 0, assignments = 0;
        for(int i = 0; i < len -1; i++){
            for(int j = 0; j < len-i-1; j++){
                
                if(arr[j] > arr[j+1]){
                    
                    
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    assignments++;
                    
                }
                 comparisons++;
            }
        }
        System.out.println("Bubble Sort - comparisons: " + comparisons + " assignments: " + assignments);
    }
    
    public static void selectionSort(int [] arr){
        
        int n = arr.length;
        int comparisons = 0, assignments = 0;
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++){
                if (arr[j] < arr[min_idx]){
                    min_idx = j;
                    assignments++;
                }
                comparisons++;
            }
            
            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            assignments++;
        }
        
        System.out.println("Selection Sort - comparisons: " + comparisons + " assignments: " + assignments);
        
    }
    
    public static void arrInsertionSort(int [] arr){
        
        int n = arr.length;
        int comparisons = 0, assignments = 0;
        
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                comparisons++;
                assignments++;
                arr[j+1] = arr[j];
                j = j-1;
            }
            comparisons++;
            assignments++;
            arr[j+1] = key;
        }
        
        System.out.println("Insertion Sort - comparisons: " + comparisons + " assignments: " + assignments);
    }
    
    
    public static void quickSort(ArrayList<Integer> arrList, int low, int high, int comparisons, int assignments){
        
        comparisons++;
        if(arrList.get(low) < arrList.get(high)){
            int pi = partition(arrList, low, high,comparisons,assignments);
            
            quickSort(arrList,low,pi-1,comparisons,assignments);
            quickSort(arrList,pi+1,high,comparisons,assignments);
        }
    }
    
    public static int partition(ArrayList<Integer> arrList, int low, int high,int comparisons, int assignments)
    {
        int pivot = arrList.get(high);
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            comparisons++;
            // If current element is smaller than or
            // equal to pivot
            if (arrList.get(j) <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arrList.get(i);
                arrList.set(i, arrList.get(j));
                arrList.set(j, temp);
                assignments++;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arrList.get(i+1);
        arrList.set(i+1,arrList.get(high));
        arrList.set(high, temp);
        assignments++;
 
        return i+1;
    }
    
    public static void listInsertionSort(ArrayList<Integer> arrList){
        
    }
    
    public static void mergeSort(ArrayList<Integer> arrList){
        
    }
}


