#include "cruiseShip.h"

//Constructors
CruiseShip::CruiseShip():Ship(){
        maxPassengers = 0;
}

CruiseShip::CruiseShip(string name,string year,int max):Ship(name,year){
    maxPassengers = max;
}

//accessors
int CruiseShip::getMaxPassengers() const{
    return maxPassengers;
}

//mutators
void CruiseShip::setMaxPassengers(int passengers){
    maxPassengers = passengers;
}

//Virtual function to display ship info
void CruiseShip::displayInfo() const{
    cout << "This is a Cruise Ship.\n";
    cout << "Ship's Name: " << getName() << endl; 
    cout << "Maximum number of passengers: " << getMaxPassengers() << endl << endl;
}
