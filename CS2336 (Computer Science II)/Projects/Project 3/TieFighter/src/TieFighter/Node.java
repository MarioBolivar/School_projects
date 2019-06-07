package TieFighter;

/**
 *
 * @author Mario Bolivar  - mjb160330
 * 
 */

public class Node<T> {
     T payloadObj;
    Node next;
    Node prev;
    static int instances = 0;
    
    //Constructor
    Node(T obj){
        payloadObj = obj;
        next = null;
        prev = null;
         instances++;
    }
    
    //Accessors
    public Node getNext(){ return next; }
    
    public Node getPrev(){ return prev; }
    
    public T getObj(){ return payloadObj; }
    
    public static int getInstances(){ return instances;}
    
    //Mutators
    public void setNext(Node next){ this.next = next; }
    
    public void setPrev(Node prev){ this.prev = prev; }
    
    

    

}
