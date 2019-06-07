#ifndef CARGOSHIP_H
#define CARGOSHIP_H

#include <iostream>
#include "ship.h"
using namespace std;

//Cargoship class that is derived from the Ship Class
class CargoShip:public Ship{
private:
    int cargoCapacity;

public:
    //Constructors
    CargoShip();
    CargoShip(string,string,int);
    
    //accessors
    int getCargoCapacity() const;

    //mutators
    void setCargoCapacity(int);

    virtual void displayInfo() const;
    
};

#endif
