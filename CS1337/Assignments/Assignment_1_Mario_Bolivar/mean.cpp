#include "mean.h"

void meanFunc(int arrOriginal[], int arrSorted[], int size, int numSearch, int pos)
{

    double mean = 0;

    // calculating the mean of the array's contents
    for(int x = 0; x < size; x++)
    {
        mean += arrOriginal[x];
    }

    mean /= 2;

    // information output
    cout << "\n\nYour array is made up of " << size << " elements.\n";

    cout << "These are the contents of the original array: \n";
    for(int i = 0; i < size; i++)
    {
        cout << "Element[" << i << "]: " << arrOriginal[i] << endl;
    }

    cout << "\nThese are the contents of the sorted array: \n";
    for(int j = 0; j < size; j++)
    {
        cout << "Element[" << j << "]: " << arrSorted[j] << endl;
    }

    cout << "The number being searched for is (" << numSearch << ").\n";

    if(pos == -1)
    {
        cout << "The number (" << numSearch << ") was not found in the array.\n";
    }
    else
    {
        cout << "The number (" << numSearch << ") was found in the array, it was element[" << pos << "] in the array. \n";
    }

    cout << "The mean of all of the values in the array is: " << mean << ".\n";


}