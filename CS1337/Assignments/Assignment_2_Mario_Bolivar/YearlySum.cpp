#include "YearlySum.h"

//Function to find the yearly sum of all of the elements inside the array.
double yearlysumFunc(double arr[], int size)
{
    double total = 0;

    for(int i = 0; i < size; i++)
    {
        total += arr[i];
    }

    cout << "The total sales for the year is: $" << total << endl;

    return total;
}