/*  Mario Bolivar - mjb160330 - CE 1337.501
    Assignment 6
    This program uses three different ship classes to demonstrate
    how virtual functions work when using object pointers to call
    the virtual functions.
*/

#include <iostream>
#include "cargoShip.h"
#include "cruiseShip.h"
#include "ship.h"

using namespace std;

//function prototype
void displayShipInfo(const Ship *);

int main(){

    //creating ships
    Ship ship1("The Buccaneer","1954");
    Ship* shipPtr = new Ship;
    shipPtr = &ship1;

    CruiseShip ship2("The Titanic","1909",3547);
    Ship* cruiseShipPtr = new Ship;
    cruiseShipPtr = &ship2;

    CargoShip ship3("Noah's Ark","2304 BC",75008);
    Ship* cargoShipPtr = new Ship;
    cargoShipPtr = &ship3; 

    //creating array of dynamically allocated ship objects
    Ship *shipArr[3]; 
    shipArr[0] = shipPtr;
    shipArr[1] = cruiseShipPtr;
    shipArr[2] = cargoShipPtr;

    //outputting ship info depending on object type
    for(int i = 0; i < 3; i++){
        displayShipInfo(shipArr[i]);
    }

    






    return 0;
}

//displays ship info
void displayShipInfo(const Ship *ship){
    ship->displayInfo();


}