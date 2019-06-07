#ifndef SHIP_H
#define SHIP_H

#include <iostream>
using namespace std;


//Base Ship Class that is inherited
class Ship{
private:
    string shipName,yearBuilt;

public:

    //Constructors
    Ship();
    Ship(string,string);

    //Accessors
    string getName() const;
    string getYearBuilt() const;

    //mutators
    void setName(string);
    void setYearBuilt(string);

    //Virtual Functions
    virtual void displayInfo() const;
};

#endif
