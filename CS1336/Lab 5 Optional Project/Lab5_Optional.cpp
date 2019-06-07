// Lab 5 Optional Project
// Convert to Roman numerals
//
// Program by: Mario Bolivar

// Declaring Preprocessor Directives
#include <iostream>

using namespace std;

int main()
{
    // Assigning the int "number" from user input
    int number;
    cout << ">Enter a number from 1 - 5: ";
    cin >> number;

    // if number equals 1
    if (number == 1)
    {
        // A certain output is displayed
        cout << "\n>You entered: " << number << endl << endl;
        cout << ">The Roman numeral equivalent is: I\n\n";
        }

    // if number equals 2
    else if (number == 2)
    {
        // A certain output is displayed
        cout << "\n>You entered: " << number << endl << endl;
        cout << ">The Roman numeral equivalent is: II\n\n";
        }

    // if number equals 3
    else if (number == 3)
    {
        // A certain output is displayed
        cout << "\n>You entered: " << number << endl << endl;
        cout << ">The Roman numeral equivalent is: III\n\n";
        }

    // if number equals 4
    else if (number == 4)
    {
        // A certain output is displayed
        cout << "\n>You entered: " << number << endl << endl;
        cout << ">The Roman numeral equivalent is: IV\n\n";
        }

    // if number equals 5
    else if (number == 5)
    {
        // A certain output is displayed
        cout << "\n>You entered: " << number << endl << endl;
        cout << "> The Roman numeral equivalent is: V\n\n";
        }

    // if number does not equal an integer between 1 and 5
    else
    {
         // An error message is displayed and the program terminates
        cout << "\n >ERROR: The number must be an integer in the range of 1 through 5 inclusive.\n\n";
        }

    return 0;

    }

