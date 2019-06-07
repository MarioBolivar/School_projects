package project.pkg2;

/**
 *
 * @author Mario Bolivar - Mjb160330
 * 
 * Magazine class that implements IDedObjects
 */

public class Magazine implements IDedObject{
    
    private int magazineID;
    private String magazineName;
    private String publisherName;
    
    //Default Ctor.
    Magazine(){
        this.magazineID = -1;
        this.magazineName = "";
        this.publisherName = "";
    }
    
    //Overloaded Ctor
    Magazine(int magazineID, String magazineName, String publisherName){
        this.magazineID = magazineID;
        this.magazineName = magazineName;
        this.publisherName = publisherName;
    }
    
    @Override
    public int getID() {
        return this.magazineID;
    }

    @Override
    public void printID() {
        System.out.println("Magazine name: " + magazineName);
        System.out.println("Magazine publisher: " + publisherName);
        System.out.println("Magazine ID: " + magazineID);
    }
    
}
