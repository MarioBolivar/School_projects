#include "avgPlanesDeparted.h"

//Avg monthly planes departed function definition
void avgPlanesDeparted(Airport *airportArr, int size){

    int total = 0;
    double avgPlanesDeparted = 0;
    
    //Loops through entire array and sums the number of planes departed
    for(int i = 0; i < size; i++){

        total += airportArr[i].planesDeparted;
        
    }

    //Calculates and outputs the average monthly number of planes departed
    avgPlanesDeparted = total / size;
    cout << "Average monthly number of planes departed: " << avgPlanesDeparted << endl;
    
}