
package assignment.pkg3;

import java.util.LinkedList;

/**
 *
 * @author Mario Bolivar - Mjb160330
 *
 */
public class Assignment3 {
    
    public static void main(String[] args) {
        
        Node ptr = head;
        
        while(ptr.next != ptr){
            
            for(int i = 0; i < M; i++)
                ptr = ptr.next;
            
            System.out.println(ptr.data + " : was removed.");
             
            //Removing node
            Node temp = ptr.prev;
            ptr.prev = null;
            ptr.next.prev = temp;
            temp.next = ptr.next;
            ptr.next = null;
            
        }
        
        
    }

}
