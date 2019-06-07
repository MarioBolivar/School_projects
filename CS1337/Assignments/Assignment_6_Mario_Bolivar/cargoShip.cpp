#include "cargoShip.h"


//Constructors
CargoShip::CargoShip():Ship(){
        cargoCapacity = 0;
}


CargoShip::CargoShip(string name,string year,int cargo):Ship(name,year){
    cargoCapacity = cargo;
}


//accessors
int CargoShip::getCargoCapacity() const{
    return cargoCapacity;
}


//mutators
void CargoShip::setCargoCapacity(int cargo){
    cargoCapacity = cargo;
}

//Virtual function to display ship info
void CargoShip::displayInfo() const{
    cout << "This is a Cargo Ship.\n";
    cout << "Ship's Name: " << getName() << endl; 
    cout << "Ship's cargo capacity: " << getCargoCapacity() << " tons." << endl << endl; 
}