package TieFighter;

/**
 *
 * @author Mario Bolivar - Mjb160330
 *
 * Merge sort Extra Credit:
 *  Implementation in LinkedList.java Lines: 82-154
 *  mergeSort function call in LinkedList.java Line: 61
 * 
 */

public class LinkedList {
    Node head;
    Node tail;
    
    //Overloaded Constructor
    LinkedList(Node Node){
        head = Node;
        tail = Node;
    }
    
    //Accessors
    public Node getHead(){ return head; }
    
    public Node getTail() { return tail; }
    
    //Mutators
    public void addNode(Node n){
        n.prev = tail;
        tail.next = n;
        tail = n;
    }
    
    @Override
    public String toString(){
        
        Node temp = head;
        
        if(head == tail){
        
            Object o = temp.getObj();
            return (((Payload) o).pilotName + "      " + ((Payload) o).patrolArea + "\r\n");
        }
        else{
            
            return ((Payload)temp.getObj()).getPilotName() + "      " + ((Payload)temp.getObj()).getPatrolArea() + "\r\n" + toStringHelper(temp);
            //return ((Payload)(toStringHelper(temp).getObj())).getPilotName() + "       " + ((Payload)(toStringHelper(temp).getObj())).getPatrolArea() + "\r\n";
        }
    }
    
    private String toStringHelper(Node temp){
        if(temp == tail){
            //If last element, return empty string
            return "";
        }else{ //Else return the next Node
            
            temp = temp.next;
            return ((Payload)temp.getObj()).getPilotName() + "      " + ((Payload)temp.getObj()).getPatrolArea() + "\r\n" + toStringHelper(temp);
        }
    }
    
    public void sort(String areaOrPilot, String ascOrDec){
            //Method to sort depending on parameters
            head = mergeSort(head, areaOrPilot, ascOrDec);
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            tail = temp;
    }
    // Split a doubly linked list (DLL) into 2 DLLs of
    // half sizes
    Node split(Node head) {
        Node fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node temp = slow.next;
        slow.next.prev = null;
        slow.next = null;
        return temp;
    }
 
    Node mergeSort(Node node, String areaOrPilot, String ascOrDec) {
        if (node == null || node.next == null) {
            return node;
        }
        Node second = split(node);
 
        // Recur for left and right halves
        node = mergeSort(node, areaOrPilot, ascOrDec);
        second = mergeSort(second, areaOrPilot, ascOrDec);
 
        // Merge the two sorted halves
        return merge(node, second, areaOrPilot, ascOrDec);
    }
 
    // Function to merge two linked lists
    Node merge(Node first, Node second, String areaOrPilot, String ascOrDec) {
        
        // If first linked list is empty
        if (first == null) {
            return second;
        }
 
        // If second linked list is empty
        if (second == null) {
            return first;
        }
        
        double left = 0;
        double right = 0;
        boolean alph = false;
        
        //Ascending Area Sort        
        if(areaOrPilot.equals("area") && ascOrDec.equals("asc")){
            left = ((Payload)first.payloadObj).patrolArea;
            right = ((Payload)second.payloadObj).patrolArea;
        }
        
        //Descending Area Sort
        else if(areaOrPilot.equals("area") && ascOrDec.equals("dec")){
            right = ((Payload)first.payloadObj).patrolArea;
            left = ((Payload)second.payloadObj).patrolArea;  
        }
        
        //Ascending Pilot Sort
        else if(areaOrPilot.equals("pilot") && ascOrDec.equals("asc")){
            
            if(((Payload)first.payloadObj).compareTo(((Payload)second.payloadObj)) == -2 || ((Payload)first.payloadObj).compareTo(((Payload)second.payloadObj)) == -3 )
                alph = true;
        }
        
        //Descending Pilot Sort
        else if(areaOrPilot.equals("pilot") && ascOrDec.equals("dec")){
              //  if(((Payload)first.payloadObj).compareTo(((Payload)second.payloadObj)) == 2 || ((Payload)first.payloadObj).compareTo(((Payload)second.payloadObj)) == 3 )
               // alph = true;
               if(((Payload)second.payloadObj).compareTo(((Payload)first.payloadObj)) == -2 || ((Payload)second.payloadObj).compareTo(((Payload)first.payloadObj)) == -3 )
                alph = true;
        }

        
        // Pick the smaller value
        if (left < right || alph) {
            first.next = merge(first.next, second, areaOrPilot, ascOrDec);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next, areaOrPilot, ascOrDec);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
 
    }
}
