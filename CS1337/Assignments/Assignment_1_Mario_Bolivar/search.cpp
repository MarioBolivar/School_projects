#include "search.h"

int searchFunc(int arr[],int numSearch, int size)
{
    // Binary search 
    int pos = -1, middle, last = (size - 1), first = 0;
    bool found = false;

    while(!found && first <= last)
    {
        middle = (first + last) / 2;
    
        if(arr[middle] == numSearch)
        {
            found = true;
            pos = middle;
        }
        else if(arr[middle] > numSearch)
        {
            last = middle - 1;
        }
        else
        {
            first = middle + 1;
        }

    }

    return pos;
}