package homework4_pt2;

/**
 *
 * @author Mario Bolivar - Mjb160330
 *
 */

//This program utilizes a generic arraylist class along with its methods
//to create a list, insert items, sort the list and display the list, both sorted
//and unsorted
public class Homework4_Pt2 {

    public static void main(String[] args) {
        
        //Create a GenericArrayList object that will be filled with integers 
        GenericArrayList newList0 = new GenericArrayList();
        
        //Filling the list object with integers
        newList0.add(4);
        newList0.add(-1);
        newList0.add(27);
        newList0.add(-33);
        
        //Displaying list before sort
        newList0.displayList();
        
        //Sorting and displaying list
        newList0.insertionSort();
        newList0.displayList();
        
        //Displaying search results
        System.out.println("\"3\" is in the list?: " + newList0.search(3));
        System.out.println("\"-33\" is in the list?: " + newList0.search(-33));
        
        //Creating a GenericArrayList object that will be filled with doubles
        GenericArrayList newList1 = new GenericArrayList();
        
        //Filling the list object with doubles
        newList1.add(1.23);
        newList1.add(-1.23);
        newList1.add(-900.23);
        newList1.add(-123.23);
        
        //Displaying the list of doubles before sort
        newList1.displayList();
        
        //Sorting and displaying the list of doubles
        newList1.insertionSort();
        newList1.displayList();
        
        //Displaying search results
        System.out.println("\"123.23\" is in the list?: " + newList1.search(123.23));
        System.out.println("\"-123.23\" is in the list?: " + newList1.search(-123.23));
        
        //Create a GenericArrayList object that will be filled with Strings
        GenericArrayList newList2 = new GenericArrayList();
        
        //Filling the list object with strings
        newList2.add("Peach");
        newList2.add("Wario");
        newList2.add("Luigi");
        newList2.add("Mario");
        
        //Displaying the list of strings before sorting
        newList2.displayList();
        
        //Sorting and displaying the list of strings
        newList2.insertionSort();   
        newList2.displayList();
        
        //Displaying search results
        System.out.println("\"Yoshi\" is in the list?: " + newList2.search("Yoshi"));
        System.out.println("\"Mario\" is in the list?: " + newList2.search("Mario"));
    }   

}
