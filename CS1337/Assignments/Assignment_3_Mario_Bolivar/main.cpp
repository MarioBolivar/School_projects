/*  Mario Bolivar - mjb160330 - CE 1337.501
    This program gathers monthly airport data input from the user
    and calculates statistics based off of the information provided.
*/

#include <iostream>
#include "airportStruct.h"
#include "avgPlanesLanded.h"
#include "avgPlanesDeparted.h"
#include "total.h"
#include "leastAndGreatest.h"

using namespace std;

// Declaring const int variable for the size of the Airport array
const int ARRAYSIZE = 12;

int main(){

    //Dynamically allocating an array of Airport Structures
    Airport *airportArray = new Airport[ARRAYSIZE];

    //Filling in the array with each month of the year's user data
    for(int i = 0; i < ARRAYSIZE; i++){
        
        //Prompting for input and gathering input
        cout << "Please enter the following information for month " << (i + 1) << ": \n";
        cout << "Total number of planes that landed: ";
        cin >> airportArray[i].planesLanded;
        
        //If user inputs incorrect data, display error message and re-prompt for input
        while(cin.fail() || airportArray[i].planesLanded < 0){

            cin.clear();
            cin.ignore();
            cin.clear();    

            cout << "Error: Invalid input, please try again.\n";          
            cout << "Total number of planes that landed: ";
            cin >> airportArray[i].planesLanded;
        }
        

        //Prompting user for input and gathering input
        cout << "Total number of planes that departed: ";
        cin >> airportArray[i].planesDeparted;
       
        //If user inputs incorrect data, display error message and re-prompt for input
        while(cin.fail() || airportArray[i].planesDeparted < 0){
            
            cin.clear();
            cin.ignore();
            cin.clear();

            cout << "Error: Invalid input, please try again.\n";   
            cout << "Total number of planes that departed: ";
            cin >> airportArray[i].planesDeparted;
        }

        //Prompting user for input and gathering input
        cout << "Greatest number of planes that landed in a given day that month: ";
        cin >> airportArray[i].maxPlanes;
        
        //If user inputs incorrect data, display error message and re-prompt for input    
        while(cin.fail() || airportArray[i].maxPlanes < 0){
            
            cin.clear();
            cin.ignore();

            cout << "Error: Invalid input, please try again.\n";          
            cout << "Greatest number of planes that landed in a given day that month: ";
            cin >> airportArray[i].maxPlanes;
        }

        //Prompting user for input and gathering input
        cout << "Least number of planes that landed in a given day that month: ";
        cin >> airportArray[i].minPlanes;
       
        //If user inputs incorrect data, display error message and re-prompt for input        
        while(cin.fail() || airportArray[i].minPlanes < 0){
            
            cin.clear();
            cin.ignore();

            cout << "Error: Invalid input, please try again.\n";          
            cout << "Least number of planes that landed in a given day that month: ";
            cin >> airportArray[i].minPlanes;
        }

        cout << endl << endl;

    }

    cout << "******************************************************************\n";
    // Calls function to calculate the avg monthly number of planes landed
    avgPlanesLanded(airportArray,ARRAYSIZE);
    
    // Calls function to calculate the avg monthly number of planes departed
    avgPlanesDeparted(airportArray,ARRAYSIZE);

    // Calls function to calculate the total number of planes landed/departed
    total(airportArray,ARRAYSIZE);

    //Calls function to calculate the least/greatest number of planes that landed
    // on any onde day and which month it occured in.
    leastAndGreatest(airportArray,ARRAYSIZE);







    return 0;
}