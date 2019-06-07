#include "sort.h"

void sortFunc(int arr[], int size)
{

    // Bubble Sort
    bool swap;
    int temp;

    do
    {
        swap = false;

        for(int i = 0; i < (size - 1); i++)
        {   
            if(arr[i] > arr[i + 1])
            {
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                swap = true;
            }
        }
    }while(swap);

    
}


