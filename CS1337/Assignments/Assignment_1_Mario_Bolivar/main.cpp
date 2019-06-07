/*  Mario Bolivar - mjb 160330 CE 1337.501
    This program prompts the user for an array, its contents, the size of the array
    and the number to be searched for and sorts the given array then searches for the number in the sorted array.
    Lastly, it outputs the index of the number searched for along with some information of the contents of the array.
*/

#include <iostream>
#include "sort.h"
#include "search.h"
#include "mean.h"

using namespace std;

int main()
{

    // Prompting the user for the size of the array with input validation
    int arrSize = 0, numSearch = 0, pos;
    cout << "Please enter the number of elements in the array: ";
    cin >> arrSize;
    while(arrSize < 1 || arrSize > 50)
    {
        if(arrSize < 1)
        {
            cout << "Error: The size of the array must be greater than 0!\n";
            cout << "Please enter the size of the array: ";
            cin >> arrSize;
        }
        else if(arrSize > 50)
        {
            cout << "Error: The size of the array must be less than or equal to 50!\n";
            cout << "Please enter the size of the array: ";
            cin >> arrSize;
        }
    }
    
    // Creating variables for the sorted/unsorted arrays
    int userArray[arrSize], unsortedArray[arrSize];

    // filling in the array with user input
    for(int i = 0; i < arrSize; i++)
    {
        cout << "Please enter the number for element[" << i << "] in the array: ";
        cin >> userArray[i];
        unsortedArray[i] = userArray[i];
    }

    // getting the number to search for from the user
    cout << "Please enter the number to search for in the array: ";
    cin >> numSearch;

    // calling the sorting function
    sortFunc(userArray, arrSize);

    // calling the search function and returning the position of the element (-1 if not found)
    pos = searchFunc(userArray,numSearch,arrSize);

    // calling the mean function to output and calculate the mean of the array's contents.
    meanFunc(unsortedArray, userArray, arrSize, numSearch, pos);

    return 0;

}
