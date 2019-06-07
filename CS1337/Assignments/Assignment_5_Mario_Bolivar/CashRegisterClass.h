#ifndef CASHREGISTERCLASS_H
#define CASHREGISTERCLASS_H

#include <iostream>
#include "InventoryClass.h"

using namespace std;

class InventoryItem;

class CashRegister{

    public: 
        CashRegister(); // default constructor
        CashRegister(InventoryItem &); //overloaded constructor 
        ~CashRegister(); // destructor

        //accessors
        double getUnitPrice() const;
        double getTax() const;
        double getSubtotal() const;
        double getTotal() const;
        

    private: 
        double unitPrice;
        int quantity;
        static double tax;
        static double subtotal;
        static double total;

};


#endif
