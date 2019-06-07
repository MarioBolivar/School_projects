package homework5;

/**
 *
 * @author Mario Bolivar - Mjb160330
 * 
 */

//This class is a queue for nodes that store a character
public class QueueClass {
    //Node reference variables that will point to the first and last nodes in the 
    //Queue, respectively.
    Node head, tail;
    
    //Constructor
    public QueueClass(){
        head = null;
        tail = null;
    }
    
    //Add a node to the queue
    public void addNode(Node n){
        
        //If queue is empty, assign head to node.
        if(head == null){
            head = n;
            tail = head;
        }
        else{ //Else, insert node at the very end 
            tail.next = n;
            tail = tail.next;
        }
    }
    
    //Remove the first node from the queue
    public Node removeNode(){
       
        //If queue is empty, return null
        if(head == null)
            return null;
        else{ //Else return the next Node in the queue
            //Temp node variable that points to first node in the queue
            Node temp = head;

            //Move head node reference variable to the next node in the queue
            head = head.next;

            //Disconnect the first node completely from the queue
            temp.next = null;

            //Return first Node in the queue
            return temp;
        }
        
    }
}
