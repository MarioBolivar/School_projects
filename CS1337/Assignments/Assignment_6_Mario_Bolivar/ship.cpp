#include "ship.h"

//Constructors
Ship::Ship(){
    shipName = "N/A";
    yearBuilt = "N/A";
}

Ship::Ship(string name,string year){
    shipName = name;
    yearBuilt = year;
}


//Accessors
string Ship::getName() const{
    return shipName;
}

string Ship::getYearBuilt() const{
    return yearBuilt;
}

//Mutators
void Ship::setName(string name){
    shipName = name;
}

void Ship::setYearBuilt(string year){
    yearBuilt = year;
}

//Virtual function to display ship info
void Ship::displayInfo() const{
    cout << "This is a Ship.\n";
    cout << "Ship's Name: " << shipName << endl;
    cout << "Year Built: " << yearBuilt << endl << endl;
}

