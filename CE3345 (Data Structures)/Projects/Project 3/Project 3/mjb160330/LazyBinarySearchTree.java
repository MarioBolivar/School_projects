package project.pkg3;
import java.lang.IllegalArgumentException;
/**
 *
 * @author Mario Bolivar - Mjb160330
 * CE 3345.001
 * 
 */


public class LazyBinarySearchTree //Lazy Binary Search Tree Class
{
    /**
     * TreeNode Class
     */
    public class TreeNode{ 
        
        int key;
        boolean deleted;
        TreeNode leftChild;
        TreeNode rightChild;
        
        /**
         * Overloaded Ctor
         * @param key 
         */
        TreeNode(int key)
        {
            this.key = key;
            boolean deleted = false;
            leftChild = null;
            rightChild = null;   
        }
        
    }
    
    private TreeNode root;
    
    /**
     * 
     * Method to insert a TreeNode with given key
     * @param key
     * @return
     * @throws IllegalArgumentException 
     * 
     */
    public boolean insert(int key) throws IllegalArgumentException 
    {
        if(key >= 1 && key <= 99) //If key is not valid
        {
            if(root == null) //If LBST is empty 
            { 
                root = new TreeNode(key); //Create new TreeNode with given key and set root to that node.
                return true;
            }
            
            return insertHelper(key, root);   //Else begin recursion to try and insert key
            
        }
        else
            throw new IllegalArgumentException(); //If invalid input, throw Exception
    }
    
    
    private boolean insertHelper(int key, TreeNode node) //Insert helper method
    {
        if(key > node.key) //If key is greater than current node key
        {            
                if(node.rightChild != null) //If right child exists, recursively call insertHelper with rightChild
                {
                    return insertHelper(key, node.rightChild);
                }
                else  //Else if right child is null, physically insert right child and return false (for not logically inserted)
                {
                    node.rightChild = new TreeNode(key);
                    return true;
                }
        }
        else if(key < node.key) //Else if key is less than current node key
        {
            if(node.leftChild != null) //If left child exists, recursively call insertHelper with leftChild
                {
                    return insertHelper(key, node.leftChild);
                }
                else  //Else if left child is null, physically insert left child and return false (for not logically inserted)
                {
                    node.leftChild = new TreeNode(key);
                    return true;
                }
        }
        else //Lastly, if key is equal to current node, check if deleted/undeleted
        {
            if(node.deleted == true) //If node was deleted, undelete it and return true (for logically inserted)
            {
                node.deleted = false;
                return true;
            }
            else //Else if node was not deleted do nothing and return false (for not logically inserted)
            {
                return false;
            }
        }
    }        

    /**
     * Method to delete a TreeNode with given Key
     * @param key
     * @return 
     */
    public boolean delete(int key) 
    {
        if(key >= 1 && key <= 99)
        {
            if(root == null) //If LBST is empty 
            { 
                return false;
            }
            
            return deleteHelper(key, root);   //Else begin recursion to try and insert key
            
        }
        else
            throw new IllegalArgumentException(); //If invalid input, throw exception
    }
    
    public boolean deleteHelper(int key,TreeNode node) //Delete Helper
    {
         if(key > node.key) //If key is greater than current node key
        {            
                if(node.rightChild != null) //If right child exists, recursively call deleteHelper with rightChild
                {
                    return deleteHelper(key, node.rightChild);
                }
        }
        else if(key < node.key) //Else if key is less than current node key
        {
            if(node.leftChild != null) //If left child exists, recursively call deleteHelper with leftChild
                {
                    return deleteHelper(key, node.leftChild);
                }
        }
        else //Lastly, if key is equal to current node, check if deleted/undeleted
        {
            if(node.deleted == false) //If node was deleted, undelete it and return true (for logically deleted)
            {
                node.deleted = true;
                return true;
            }
        }
        //Else if node was not deleted do nothing and return false (for not logically deleted)
        return false;
    }
    
    /**
     * Method to find minimum key in Tree
     * @return 
     */
    public int findMin() 
    {
        return findMinHelper(root,100);
    }
    
    private int findMinHelper(TreeNode node,int min){ //Find Minimum Helper
        
        if(root == null) //If Tree is empty, return -1
        {
            return -1;
        }
        
        if(node == null) //If current Node is min return max
        {
            return min;
        }
       
        if(node.deleted == false && node.key < min) //If current node is not deleted and current node key is less than min
        {
              min = node.key; //Node.key is the new min
        }
            
        min = findMinHelper(node.leftChild,min); //Recurse to leftChild
        min = findMinHelper(node.rightChild,min); //Recurse to rightChild
        
        return min;
    }
        
    /**
     * Method to find the maximum key in Tree
     * @return 
     */
    public int findMax() 
    {
        return findMaxHelper(root,0);
    }
    
    private int findMaxHelper(TreeNode node,int max){
        
        if(root == null) //If Tree is empty, return -1
        {
            return -1;
        }
       
        if(node == null) //If current Node is null return max
        {
            return max;
        }
        
        if(node.deleted == false && node.key > max) //If current node is not deleted and current node key is greater than max
        {
              max = node.key; //Node.key is the new min
        }
            
        max = findMaxHelper(node.leftChild,max); //Recurse to leftChild
        max = findMaxHelper(node.rightChild,max); //Recurse to rightChild
        
        return max;
    }
    
    /**
     * Method to see if Binary Search Tree contains a given key
     * @param key
     * @return 
     */
    public boolean contains(int key)
    {
        return containsHelper(key,root,false);
    }
    
    private boolean containsHelper(int key, TreeNode node,boolean found) //Contains helper method
    {        
        if(root == null) //If Tree is empty, return false
        {
            return false;
        }
       
        if(node == null) //If current Node is null return false
        {
            return found;
        }
        
        if(node.deleted == false && node.key == key) //If current node is not deleted and current node key is greater than max
        {
              found = true;
        }
            
        found = containsHelper(key,node.leftChild,found); //Recurse to leftChild
        found = containsHelper(key,node.rightChild,found); //Recurse to rightChild
        
        return found;
    }
   
    /**
     * Get height of tree
     * @return 
     */
    public int height() 
    {
        return heightHelper(root);
    }
    
    private int heightHelper(TreeNode node) //Height helper method
    {
        if(node == null) //If node is null, return -1
        {
            return -1;
        }
        
        int left = heightHelper(node.leftChild); //Recurse to leftChild
        int right = heightHelper(node.rightChild); //Recurse to rightChild
        
        if(left > right)
        {
            return left+1;
        }
        else
        {
            return right+1;
        }
        
        
    }
            
    /**
     * Get size of Tree
     * @return 
     */
    public int size() 
    {
        return sizeHelper(root,0);
    }
    
    private int sizeHelper(TreeNode node,int size) //sizeHelper method
    {  
        if(root == null) //If Tree is empty, return 0
        {
            return 0;
        }
       
        if(node == null) //If current Node is null return size
        {
            return size;
        }
        
        size++; //Increment size
            
        size = sizeHelper(node.leftChild,size); //Recurse to leftChild
        size = sizeHelper(node.rightChild,size); //Recurse to rightChild
        
        return size;
    }


    
    /**
     * Print LazyBinarySearchTree in Pre-Order
     * @return String
     */
    @Override
    public String toString()
    {
       String s = "";
       return toStringHelper(root);
    }
    
    private String toStringHelper(TreeNode node) //toString helper method 
    {
        String s = "";
        
        if(node == null) //If Tree is empty, return empty string
        {
            return s;
        }
       
        if(node.deleted == true) //If current node is deleted, add asterisk plus current node key to string
        {
              s = s.concat("*" + node.key + " ");
        }
        else //If current node is not deleted, add current node key to string
        {
            s = s.concat(node.key + " ");
        }
            
        s = s.concat(toStringHelper(node.leftChild)); //Recurse to leftChild
        s = s.concat(toStringHelper(node.rightChild)); //Recurse to rightChild
        
        return s;
    }
}

