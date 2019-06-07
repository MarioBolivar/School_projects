#include "total.h"

//Fucntion Definition
//Function finds the total number of planes landed/departed
void total(Airport *airportArray, int size){

    int totalLanded = 0, totalDeparted = 0;
    
    for(int i = 0; i < size; i++){

        totalLanded += airportArray[i].planesLanded;
        totalDeparted += airportArray[i].planesDeparted;
    }

    cout << "Total number of planes landed: " << totalLanded << endl;
    cout << "Total number of planes departed: " << totalDeparted << endl;
}