#ifndef CRUISESHIP_H
#define CRUISESHIP_H

#include <iostream>
#include "ship.h"
using namespace std;

//CruiseShip class that is derived from the Ship Class
class CruiseShip:public Ship{
private:
    int maxPassengers;

public:
    //Constructors
    CruiseShip();
    CruiseShip(string,string,int);
    
    //accessors
    int getMaxPassengers() const;
    int getCargoCapacity() const;

    //mutators
    void setMaxPassengers(int);
    void setCargoCapacity(int);

    virtual void displayInfo() const;
    
};

#endif
