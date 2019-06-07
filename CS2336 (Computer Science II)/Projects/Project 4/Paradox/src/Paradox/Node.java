package Paradox;

/**
 *
 * @author Mario Bolivar - mjb160330
 */

//Node to store object data and create a BST
public class Node<T> implements Comparable <T>{
    T obj;
    Node leftPtr;
    Node rightPtr;
    
    //Overloaded Constructor
    public Node(T obj){
        this.obj = obj;
        leftPtr = null;
        rightPtr = null;
    }
    
    //Accessors
    public T getObj(){
        return obj;
    }
    
    public Node getLeftPtr(){
        return leftPtr;
    }
    
    public Node getRightPtr(){
        return rightPtr;
    }
    
    //Mutators
    public void setLeftPtr(Node leftPtr){
        this.leftPtr = leftPtr;
    }
    
    public void setRightPtr(Node rightPtr){
        this.rightPtr = rightPtr;
    }
    
    public void setObj(T obj){
        this.obj = obj;
    }
    
    @Override
    //Overriden compareTo method to compare exponents in Payload objects
    public int compareTo(T o){
       
        //If objects are instances of Payload class
        if(obj instanceof Payload && o instanceof Payload){
            //If exponent is less than return -1
            if(((Payload)obj).getExponent() < ((Payload)o).getExponent()){
                return -1;
            }
            
            //If exponent is greater than return 1
            else if(((Payload)obj).getExponent() > ((Payload)o).getExponent())
            {
                return 1;
            }
            
            else{
                return 0;
            }
        }
        return 69;
    }
}
