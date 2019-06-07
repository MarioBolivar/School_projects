/*  Assignment 5 - Mario Bolivar - mjb160330 - CE 1337.501
    This program runs a store with preset inventory and prices.
    The program prompts the user for what they would like to purchase
    as well as how much and generates a receipt after they want to checkout.
*/

#include "CashRegisterClass.h"
#include "InventoryClass.h"
#include <iostream>
#include <iomanip>

using namespace std;

// main menu function prototype
int mainMenu(InventoryItem&,InventoryItem&,InventoryItem&);

int main(){

    
    int choice = 0;
    
    //creating store inventory
    InventoryItem MobyHuge((char*)"Detailed and crafted for realism",900,4);
    InventoryItem SourPatchKids((char*)"First they're sour. Then they're sweet.",2.88,69);
    InventoryItem HereComeDatBoiLapelPin((char*)"watch him rollin watch him go",5.99,19);

    //looping through main menu until user exits
    do{

        //display main menu
        choice = mainMenu(MobyHuge,SourPatchKids,HereComeDatBoiLapelPin);
    
        //output and prompts depending on selection
        if(choice == 1){
            cout << "\n\nMobyHuge : " << MobyHuge.getDescription() << endl;
            cout << "Quantity Available: " << MobyHuge.getUnits() << endl;
            CashRegister mHuge(MobyHuge);
        }else if (choice == 2){
            cout << "\n\nSourPatchKids : " << SourPatchKids.getDescription() << endl;
            cout << "Quantity Available: " << SourPatchKids.getUnits() << endl;
            CashRegister spKids(SourPatchKids);
        }else if(choice == 3){
            cout << "\n\nHereComeDatBoiLapelPin : " << HereComeDatBoiLapelPin.getDescription() << endl;
            cout << "Quantity Available: " << HereComeDatBoiLapelPin.getUnits() << endl;
            CashRegister datBoiLapelPin(HereComeDatBoiLapelPin);
        }else{
            CashRegister total;
            cout << "\n\nSummary of your purchase: \n";
            cout << "Subtotal: $" << fixed << setprecision(2) << total.getSubtotal() << endl;
            cout << "Tax: $" << fixed << setprecision(2) << total.getTax() << endl;
            cout << "Total: $" << fixed << setprecision(2) << total.getTotal() << endl;
            cout << "\nThank you for shopping with us!\n";

            cout << "\n\nNew inventory after purchase:\n\n";
            cout << left << setw(30) << "Item" << setw(40) << "Quantity Available" << setw(20) << "Price" << endl;
            cout << left << setw(30) << "MobyHuge" << setw(40) << MobyHuge.getUnits() << "$" << MobyHuge.getCost() << endl;
            cout << left << setw(30) << "SourPatchKids" << setw(40) << SourPatchKids.getUnits() << "$" << SourPatchKids.getCost() << endl;
            cout << left << setw(30) << "HereComeDatBoiLapelPin" << setw(40) << HereComeDatBoiLapelPin.getUnits() << "$" << HereComeDatBoiLapelPin.getCost() << endl;
        }
    }while(choice != 4);
    return 0;
}

//main menu definition
int mainMenu(InventoryItem& MobyHuge,InventoryItem& SourPatchKids,InventoryItem& HereComeDatBoiLapelPin){
    
    int choice;
    cout << "\n\nWelcome to the general store!: \n\n\n";
    cout << left << setw(10) << " " << setw(30) << "Item" << setw(40) << "Quantity Available" << "Price" << endl;
    cout << left << setw(10) << "1." << setw(30) << "MobyHuge" << setw(40) << MobyHuge.getUnits() << "$" << MobyHuge.getCost() << endl;
    cout << left << setw(10) << "2." << setw(30) << "SourPatchKids" << setw(40) << SourPatchKids.getUnits() << "$" << SourPatchKids.getCost() << endl;
    cout << left << setw(10) << "3." << setw(30) << "HereComeDatBoiLapelPin" << setw(40) << HereComeDatBoiLapelPin.getUnits() << "$" << HereComeDatBoiLapelPin.getCost() << endl;
    cout << "4. Exit/Checkout" << endl;

    cout << "\n >Please choose from the following options: ";
    cin >> choice;

    while (choice < 1 || choice > 4 || cin.fail()){

        cin.clear();
        cin.ignore();
        cin.clear();    

        cout << "Error: Invalid input, please try again.\n"; 
        cout << "\n >Please choose from the following options (1-3): ";
        cin >> choice;
    }

    return choice;
}
