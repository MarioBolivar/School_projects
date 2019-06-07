package in_class_assignment_4;

/**
 *
 * @author Mario Bolivar - Mjb160330
 */

//Node class to store a character and point to the next item in the stack
public class Node {
    
    //Character to be stored
    char character;
    
    //Next node reference variable
    Node next;
    
    //Constructor
    public Node(char character){
        this.character = character;
        this.next = null;
    }
    
    //Return character in Node
    public char getChar(){
        return character;
    }
    
}
