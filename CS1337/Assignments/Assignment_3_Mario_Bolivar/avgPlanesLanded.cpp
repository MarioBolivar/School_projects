#include "avgPlanesLanded.h"

//Avg monthly planes landed function definition
void avgPlanesLanded(Airport *airportArray, int size){


    int totalPlanesLanded = 0;
    double avgPlanesLanded = 0;

    //Loops through entire array and sums the number of planes landed
    for(int i = 0; i < size; i++)
    {
        totalPlanesLanded += airportArray[i].planesLanded;
    }

    //Calculates and outputs the average monthly number of planes landed
    avgPlanesLanded = totalPlanesLanded / size;
    cout << "Average monthly number of planes landed: " << avgPlanesLanded << endl;

}