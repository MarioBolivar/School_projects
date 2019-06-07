#ifndef INVENTORYCLASS_H
#define INVENTORYCLASS_H

#include <iostream>


using namespace std;



// Inventory Item class 
class InventoryItem{
    public:
        // Constructor
        InventoryItem(char *desc, double c, int u);
        // Destructor
        ~InventoryItem();
        void setDescription(char*);
        const char *getDescription() const;
        void setCost(double);
        double getCost() const;
        void setUnits(int);
        int getUnits() const;
        int getNumArticles() const;
        
    private:
        char *description; // The item description
        double cost; // The item cost
        int units; // Number of units on hand
        static int number_articles; // How many items sold by store
        
};


#endif