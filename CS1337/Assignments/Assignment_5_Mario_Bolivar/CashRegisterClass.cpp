#include "CashRegisterClass.h"
#include <iomanip>

//static member variable definition
double CashRegister::tax = 0;
double CashRegister::subtotal = 0;
double CashRegister::total = 0;

//default constructor
CashRegister::CashRegister(){
    //do nothing
}

//overloaded constructor
CashRegister::CashRegister(InventoryItem &item){
    

    unitPrice =  (item.getCost() + (item.getCost() * .3));
    cout << "\nThe price per unit for this item is: $" << fixed << setprecision(2) << unitPrice << endl;
    

    int q;
    cout << "\n >How many would you like to purchase?: ";
    cin >> q;
    while(q < 0 || cin.fail() || q > item.getUnits()){
         cin.clear();
            cin.ignore();
            cin.clear();    
            if(q > item.getUnits()){
                cout << "\nThere is not enough items on hand to complete the order!\n";
                cout << "\n >Please enter an available quantity: ";
                cin >> q;
            }else{
                cout << "Error: Invalid input, please try again.\n"; 
                cout << "\n >How many would you like to purchase?: ";
                cin >> q;
            }
          

    }
    quantity = q;

    subtotal += unitPrice * quantity;
    tax += (subtotal * .06);
    total += subtotal + tax;
    item.setUnits((item.getUnits() - q));
}

//accessors
double CashRegister::getUnitPrice() const{
    return unitPrice;
}

double CashRegister::getTax() const{
    return tax;
}

double CashRegister::getSubtotal() const{
    return subtotal;
}

double CashRegister::getTotal() const{
    return total;
}

CashRegister::~CashRegister(){
    //destructor
}