
package homework7;


/**
 *
 * @author Mario Bolivar - Mjb160330
 *
 */

//This program creates a hash table that has a load factor of .5
//Using quadratic probing as a collision handler, we fill the hash table with enough keys
//to where it will rehash 
public class Main {

    public static void main(String[] args) {
        
        final double loadFactor = .5;
        
        int [] hashTable = new int[9];
        int key = 9;
        
        //Inserting keys into table
        hashTable = hash(hashTable, 101, loadFactor);
        hashTable = hash(hashTable, 102, loadFactor);
        hashTable = hash(hashTable, 103, loadFactor);
        hashTable = hash(hashTable, 104, loadFactor);
        hashTable = hash(hashTable, 105, loadFactor);
        hashTable = hash(hashTable, 106, loadFactor);
        hashTable = hash(hashTable, 107, loadFactor);
        hashTable = hash(hashTable, 108, loadFactor);
        hashTable = hash(hashTable, 109, loadFactor);
        hashTable = hash(hashTable, 110, loadFactor);
        hashTable = hash(hashTable, 111, loadFactor);
        hashTable = hash(hashTable, 112, loadFactor);
        hashTable = hash(hashTable, 113, loadFactor);
        hashTable = hash(hashTable, 114, loadFactor);
        hashTable = hash(hashTable, 115, loadFactor);
        hashTable = hash(hashTable, 116, loadFactor);
        hashTable = hash(hashTable, 117, loadFactor);
        hashTable = hash(hashTable, 118, loadFactor);
        hashTable = hash(hashTable, 119, loadFactor);
        hashTable = hash(hashTable, 120, loadFactor);
        hashTable = hash(hashTable, 121, loadFactor);
        hashTable = hash(hashTable, 122, loadFactor);
        hashTable = hash(hashTable, 123, loadFactor);
        hashTable = hash(hashTable, 124, loadFactor);
        hashTable = hash(hashTable, 125, loadFactor);
        
        
        for(int i = 0; i < hashTable.length;i++){
            System.out.println("Hash table value at index " + i + ": " + hashTable[i]);
        }
        
    }
    
    
    public static int[] hash(int[] hashTable, int key, double loadFactor){
        int length = hashTable.length;
        int k = key % length;
        double currentLoad = 0,  numElements = 0;
        
        for(int i = 0; i < length; i++){
        
            if(hashTable[i] != 0){
                numElements++;
            }
        }
        
        currentLoad = numElements / hashTable.length;
        if(currentLoad > loadFactor){
            hashTable = rehash(hashTable);
            length = hashTable.length;
            k = key % length;
        }
        
        
        
        //if index is empty, fill it with the key
        if(hashTable[k] == 0){
            hashTable[k] = key;
        }
        
        //if index is taken, use quadratic probing
        else{
            
            int j = 0, index = 0;
            final int MAX_ITER = 100000;
            while(hashTable[((k + j*j) % length)] != 0 && j <= MAX_ITER){
                j++;
        
            }
            
            if(j != MAX_ITER){
                index = (k + j*j) % length;
                hashTable[index] = key;
            }else{
                System.out.println("No open spot available for key: " + key);
            }
            
        }
        return hashTable;
    }
    
    //Rehash the table
    public static int[] rehash(int [] originalHashTable){
       
        int[] newHashTable = new int[((originalHashTable.length) * 2)];
        int length = newHashTable.length;
        for(int i = 0; i < originalHashTable.length;i++){
            newHashTable[i] = originalHashTable[i];
        }
        return newHashTable;
    }
}    

