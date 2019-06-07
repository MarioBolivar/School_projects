package project.pkg2;

/**
 *
 * 
 * @author Mario Bolivar - Mjb160330
 * 
 * This is a generic Linked list whose generic object extends IDedObject
 */


public class GenLinkedList<AnyType extends IDedObject>{
    
    public class Node <AnyType extends IDedObject>{
        
        Node(AnyType data){
            this.data = data;
            next = null;
        }
        
        Node next;
        AnyType data;
        
    }
    
    private Node head;
    
    //Default Ctor.
    GenLinkedList(){ //Generate an empty LL
        head = null;
    }
    
    void makeEmpty(){ //Empty linked list.
        head = null;
    }
    
    AnyType findID(int ID){
        
        if(head == null) //If list is empty, return null
            return null;
        else if(head.data.getID() == ID){
            return (AnyType)head.data;
        }
        else{
            Node ptr = head;
            while(ptr != null){
                if(ptr.data.getID() == ID){
                    return (AnyType)ptr.data;
                }else
                    ptr = ptr.next;
            }
            return null;
        }
    }
    
    boolean insertAtFront(AnyType x){
        
        if(head == null){ //If LL is empty, insert node at front of list
            head = new Node(x);
            return true;
        }
        
        AnyType test = findID(x.getID());
        
        
        if(test == null){ //If ID was not already in list
             //Insert Node at front of list.
            Node newNode = new Node(x);
            Node temp = head;
            head = newNode;
            newNode.next = temp;
            return true;
        }
        
        return false; //Else return false
    }
    
    AnyType deleteFromFront(){
        
        if(head == null) //if LL is empty, return null
            return null;
        else{ //Else remove from front of list and return removed object.
            Node temp = head;
            head = head.next;
            return (AnyType)temp.data;
        }
    }
    
    AnyType delete(int ID){
        
        if(head == null) //If list is empty, return null;
            return null;
        else if(head.data.getID() == ID){ //If node being searched for is at beginning of list.
       
            Node temp = head;
            head = head.next;
            return (AnyType)temp.data;
           
        }
        else{ //If Node being searched for is somewhere inside of list.
            
            Node ptr = head;
            while(ptr.next != null){
                if(ptr.next.data.getID() == ID){ //If ID is found, delete from LL
                    Node temp = ptr.next;
                    ptr = ptr.next.next;
                    temp.next = null;
                    return (AnyType)temp.data;
                }else
                    ptr = ptr.next;
            }
            
            return null;
        }
    }
    
    void printAllRecords(){
        
        if(head == null){ //If linked list is empty, display message.
            System.out.println("\n    >List is empty!\n");
            return;
        }else{
            
            Node ptr = head;
            System.out.println("\n  >Printing all objects in Linked List..\n");
            
            //Printing all objects in linked list.
            while(ptr != null){
                System.out.println();
                ptr.data.printID();
                System.out.println();
                ptr = ptr.next;
            }
        }
    }
}
