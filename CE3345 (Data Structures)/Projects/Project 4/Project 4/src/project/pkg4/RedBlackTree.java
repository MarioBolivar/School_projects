package project.pkg4;

/**
 *
 * @author Mario Bolivar - Mjb160330
 *  CE 3345.001
 *  RedBlackTree Class Implementation
 */
public class RedBlackTree <E extends Comparable<E>>{
    private static boolean RED;
    private static boolean BLACK;
    private Node root;
    
    public class Node <E extends Comparable<E>>{
        E element;
        Node leftChild;
        Node rightChild;
        Node parent;
        boolean color;
        
        Node(E element){
            this.element = element;
            leftChild = null;
            rightChild = null;
            parent = null;
            color = false;
        }
        
    }
    
    
    public boolean insert(E element){
        
        
        
        return false;
    }
    
    public boolean contains(E object){
        
        return false;
    }
    
    @Override
    public String toString(){
        
        
        return "";
    }
    
}
