package in_class_assignment_4;

/**
 *
 * @author mario
 */
public class StackClass {
    
    Node head;
    static int size = 0;
    //Default Cstr
    public StackClass(){
        head  = null;
    }
    
    //Pop Node from Stack
    public Node pop(){
        
        //if stack is empty, return null
        if(head == null){
            return null;
        }else{
            
            //Temp Node variable to store head
            Node temp = head;

            //Move head to the next node
            head = head.next;

            //Completely cut the node from the list
            temp.next = null;
            
            --size;
            //Return the popped node
            return temp;
        }
        
    }
    
    //Push Node into stack
    public void push(Node n){
       
        //Insert node in the beginning of the stack
        n.next = head;
        head = n;
        ++size;
    }
    
    //Peek the next node on the stack
    public Node peek(){
        return head;
    }
    public static int getSize(){ return size;}
    
    
    
}
