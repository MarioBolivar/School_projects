
package project.pkg2;

import java.util.Scanner;

/**
 *
 * @author Mario Bolivar - Mjb160330
 * 
 *  This Program allows you to create a linked list of magazine objects
 *  by user input.
 * 
 */
public class Project2 {

    public static void main(String[] args) {
      
        //Creating Generic Linked List object of Type Magazine
        GenLinkedList<Magazine> LL = new GenLinkedList<>();
        
        int choice = 0;
        Scanner input = new Scanner(System.in);
        
        do{
            
            //Menu Output
            System.out.println("1.) Make Empty");
            System.out.println("2.) Find ID");
            System.out.println("3.) Insert at Front");
            System.out.println("4.) Delete From Front");
            System.out.println("5.) Delete ID");
            System.out.println("6.) Print all Records");
            System.out.println("7.) Done");
            
            //User Input
            System.out.print("Please choose from the above menu: ");
            choice = input.nextInt();
            
            //Input validation
            while(choice < 1 || choice > 7){
                System.out.println("\n    >Invalid Input! Please try again. \n");
                
                System.out.println("1.) Make Empty");
                System.out.println("2.) Find ID");
                System.out.println("3.) Insert at Front");
                System.out.println("4.) Delete From Front");
                System.out.println("5.) Delete ID");
                System.out.println("6.) Print all Records");
                System.out.println("7.) Done");

                System.out.print("Please choose from the above menu: ");
                choice = input.nextInt();
            }
            
            //If blocks depending on user input.
            if(choice == 1){
                LL.makeEmpty();
                System.out.println("\n  >List was emptied!\n");
            }
            else if(choice == 2){
                int ID = 0;
                System.out.print("Please enter an ID to search for: ");
                ID = input.nextInt();
                
                Magazine searchedMag = LL.findID(ID);
                
                if(searchedMag == null){
                    System.out.println("\n  >Magazine with ID '" + ID + "' was not found!\n");
                    System.out.println();
                }
                else{
                    System.out.println("\n  >Magazine with ID '" + ID + "' was found! Below is its information:\n");
                    searchedMag.printID();
                    System.out.println();
                }
            }
            else if(choice == 3){
                int magazineID;
                String magazineName, publisherName;
                
                System.out.print("Please enter the Magazine ID: ");
                magazineID = input.nextInt();
            
                System.out.print("Please enter the Magazine Name: ");
                magazineName = input.next();
                
                System.out.print("Please enter the Publisher Name: ");
                publisherName = input.next();
                
                Magazine newMag = new Magazine(magazineID,magazineName,publisherName);
                
                boolean check = LL.insertAtFront(newMag);
                
                if(check){
                    System.out.println("\n    >Magazine with the following information been added to the list:\n");
                    newMag.printID();
                    System.out.println();    
                }
                else{
                    System.out.println("\n    >Magazine with ID '" + magazineID + "' could not be added to the list. It already exists!\n");
                }
                
            }
            else if(choice == 4){
                Magazine deletedMag = LL.deleteFromFront();
                
                if(deletedMag == null){
                    System.out.println("\n  >Nothing deleted. List is empty!\n");
                }else{
                    System.out.println("\n  >The following magazine has been deleted from the list:");
                    deletedMag.printID();
                }
                System.out.println();
            }
            else if(choice == 5){
                 int ID = 0;
                System.out.print("Please enter an ID to delete: ");
                ID = input.nextInt();
                
                Magazine searchedMag = LL.delete(ID);
                
                if(searchedMag == null){
                    System.out.println("\n  >Magazine with ID '" + ID + "' was not found!\n");
                }
                else{
                    System.out.println("\n  >Magazine with ID '" + ID + "' was deleted! Below is its information:\n");
                    searchedMag.printID();
                    System.out.println();
                }
            }
            else if(choice  == 6){
                LL.printAllRecords();
            }
            else{
                System.out.println("\n  >Exiting..\n");
            }
            
            
        }while(choice != 7); //Repeat menu until user exits.
    }

}
