// Lab 8 Exercise 1
// The compute_sum function
//
// Program by: Mario Bolivar--mjb160330

// This Program Calculates the sum of the numbers from //
// 1 - n inclusive. "n" being inputted by the user.    //


// Defining Preprocessor directives
#include <iostream>


using namespace std;


// Function prototype
int compute_sum(int limit);


int main()
{


 int maxNumber;


 // get the maxNumber for the function call
 cout << "Enter a whole number greater than 0: ";
 cin >> maxNumber;





 // Display the sum calculated by the compute_sum function
 cout << "The sum of 1 to " << maxNumber;
 cout << " is " << compute_sum(maxNumber) << endl;

 return 0;
}

// Computes the sum of the maxNumber entered by the user
// and returns that value
int compute_sum(int limit)
{
    return limit * (limit + 1) / 2;
}
