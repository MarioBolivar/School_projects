package Paradox;

/**
 *
 * @author Mario Bolivar - Mjb160330
 */

//Binary Search Tree
public class BST <T> {
    //Root Ptr
    Node root;
    
    //Default Constructor
    public BST(){
        this.root = null;
    }
    
    //Overloaded Constructor
    public BST(Node root){
        this.root = root;
    }
    
    //Accessor
    public Node getRoot(){
        return root;
    }
    
    //Mutator
    public void setRoot(Node root){
        this.root = root;
    }
    
    // public calling method
    public void insertNode(Node n) {
        root = insertNode(root, n);
    }

    // private recursive call
    private Node insertNode(Node head, Node newNode) {
        
        /* If the tree is empty, return a new node */
        if (head == null) {
            head = newNode;
            return head;
        }
 
        /* Otherwise, recur down the tree */
        if ((((Payload)head.getObj()).exponent) < (((Payload)newNode.getObj()).exponent))
            head.rightPtr = insertNode(head.rightPtr,newNode);
        else
            head.leftPtr = insertNode(head.leftPtr, newNode);
 
        /* return the (unchanged) node pointer */
        return head;
        

    }
    
    
    //Recursive search
    public boolean search(T value){
        if(searchHelper(root,value) != null)
            return true;
        else
            return false;
    }
    
    private Node searchHelper(Node n, T key){
        // Base Cases: root is null or key is present at root
            if (n==null || ((Payload)n.getObj()).getExponent() == (Integer)key)
                return n;

            // val is greater than root's key
            if (((Payload)n.getObj()).getExponent() > (Integer)key)
                return searchHelper(n.getLeftPtr(), key);

            // val is less than root's key
            return searchHelper(n.getRightPtr(), key);

    }
    
    //Recursive delete
    public void delete(){
        
    }
    
    
    //Recursive traversals
    //Preorder Traversal
    public void preorderTraversal(){
        preorderTravHelper(root);
    }
    
    //Preorder traversal helper function
    private void preorderTravHelper(Node node){
        
        if (node == null)
            return;
 
     
            
            /* first print data of node */
            System.out.print(((Payload)node.getObj()).toString());

            /* then recur on left sutree */
            preorderTravHelper(node.getLeftPtr());

            /* now recur on right subtree */
            preorderTravHelper(node.getRightPtr());
    }
    
    //Inorder Traversal
    public void inorderTraversal(){
        inorderTravHelper(root);
    }
    
    //Inorder Traversal helper function
    private void inorderTravHelper(Node node){
       
        if (node == null)
            return;
 
  
            
            /* first recur on left child */
            inorderTravHelper(node.leftPtr);

            /* then print the data of node */
            System.out.println(((Payload)node.getObj()).toString());

            /* now recur on right child */
            inorderTravHelper(node.rightPtr);
  
        
    }
    
    //Postfix Traversal
    public void postorderTraversal(){
        postorderTravHelper(root);
    }
    
    private void postorderTravHelper(Node node){
          
            if (node == null)
            return;
 
            // first recur on left subtree
            postorderTravHelper(node.leftPtr);

            // then recur on right subtree
            postorderTravHelper(node.rightPtr);

            // now deal with the node
            System.out.print(((Payload)node.getObj()).toString());
          
        
    }
    
}
