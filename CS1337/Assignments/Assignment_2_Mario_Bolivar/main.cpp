/*  Mario Bolivar - Mjb160330
    CE 1337.501 Assignment 2
    This program will dynamically allocate memory to have 
    an array ints which represents monthly sales who will then be used 
    to calculate the average monthly sales + the total yearly sales.
*/

#include <iostream>
#include "YearlySum.h"
#include "Average.h"

using namespace std;

int main()
{
    int size = 0, yearlySum = 0;

    //User input
    cout << "Please input the number of monthly sales to be input: ";
    cin >> size;

    //Declaring and defining a dynamic array
    double *inputPtr = new double[size];

    //Filling the array
    for(int i = 0; i < size; i++)
    {
        cout << "Please input the sales for month " << ++i << ": ";
        --i;
        cin >> inputPtr[i];

    }

    //Calling the yearly sum function and setting the yearly sum to its variable
    yearlySum = yearlysumFunc(inputPtr, size);

    //Calling the average function and passing the yearly sum (type double not array) as an argument
    averageFunc(yearlySum, size);

    return 0;
}