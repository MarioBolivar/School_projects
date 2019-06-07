#include "leastAndGreatest.h"

//Function definition 
//Calculates the least/greatest number of plaes that landed
// on any one day and which month it occured in.
void leastAndGreatest(Airport *airportArray,int size){

    int least = 0, greatest = 0, monthLeast = 0, monthGreatest = 0;

    //Loops through the year's data and finds the least/greatest and the month
    // using a flag to track the least/greatest number.
    for(int i = 0; i < size; i++){

        if(least < airportArray[i].minPlanes){
            least = airportArray[i].minPlanes;
            monthLeast = i;
        }

        if(greatest < airportArray[i].maxPlanes){
            greatest = airportArray[i].maxPlanes;
            monthGreatest = i;
        }
    }

    //output
    cout << "The greatest number of planes that landed on any one day happened in month [ " << ++monthGreatest << " ] and was: " << greatest << " planes.\n";
    cout << "The least number of planes that landed on any one day happened in month [ " << ++monthLeast << " ] and was: " << least << " planes.\n";
}