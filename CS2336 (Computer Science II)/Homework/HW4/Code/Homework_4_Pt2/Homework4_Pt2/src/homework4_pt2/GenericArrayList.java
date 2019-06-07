package homework4_pt2;

import java.util.ArrayList;

/**
 *
 * @author Mario Bolivar - Mjb160330
 */

//Generic ArrayList class
public class GenericArrayList<X extends Comparable<X>> {
    
    //Defining the GenericArraylist instance variable
    private ArrayList<X> list = new ArrayList<>();
    
    //Insertion sort method
    public void insertionSort(){
        
        for(int i = 0; i < list.size(); i++){
                
            X key = list.get(i);
            int j = i-1;
                
            while(j >=0 && (list.get(j).compareTo(key) > 0)){
                
                list.set(j+1, list.get(j));
                j = j-1;
                    
            }
            
            list.set(j+1, key);
                
        }           
    }
    
    //Generic Binary Search method
    public boolean search(X var){
        
        int lo = 0, hi = list.size()-1;
        
        
        while(hi >= lo){
            
            int mid = (hi+lo)/2;
            
            if(list.get(mid).compareTo(var) == 0)
                return true;
            else if (list.get(mid).compareTo(var) < 0)
                      lo = mid+1;
            else
                hi = mid-1;  
        }
        
        return false;
        
    } 
    
    //Insert into the list
    public void add(X var){
        this.list.add(var);
    }
    
    //Return the list in a string
    public void displayList(){
        System.out.println(this.list.toString());
    }
}
    

