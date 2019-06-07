// Lab 9 Exercise 2
// Call by value and call by reference
//
// Program by:     Mario Bolivar -- mjb160330
// This Program Asks the user for the value of two numbers until -999
// is inputted to start the program. The inputs for the two numbers
// are over-written every time the user inputs two new values

// Defining Preprocessor Directives
#include <iostream>

using namespace std;

// function prototype
// Swap the values value1 and value2
void swapInts(int &value1, int &value2);

// main function - you application starts here
int main()
{
    // Variables
   int num1 = 0, num2;

   do
   {
      // ask for the first input value
      cout << "Enter number 1 (enter -999 to quit processing): ";
      cin >> num1;

      // check to see if we should ask for num2 and then swap num1 and num2
      if (num1 != -999)
      {
         // get num2
         cout << "Enter number 2: ";
         cin >> num2;
         // OK, we now swap the values
         cout << "Swapping numbers 1 (" << num1 << ") and 2 (" << num2 <<")." << endl;
         swapInts(num1, num2);
         // Outputting new values
         cout << "The new value of number 1 is " << num1 << "." << endl;
         cout << "The new value of number 2 is " << num2 << "." << endl;
      }
   }
   while (num1 != -999); // Loop until -999 is entered

   cout << "Thank you for using this application." << endl;
}

// This function is supposed to swap the values value1 and value2, but it
// will not work because value1 and value2 are passed by value.
void swapInts(int &value1, int &value2)
{
   int temp;

   // Swap value1 and value2
   temp = value1;
   value1 = value2;
   value2 = temp;

   return;
}
