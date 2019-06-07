// Lab 5 Exercise 2
// Convert to Roman numerals
//
// Program by: Mario Bolivar

// Declaring Preprocessor Directives
#include <iostream>

using namespace std;

int main()
{

    // Assigning the int number to a user input
    int number;
    cout << ">Enter a number from 1 - 5: ";
    cin >> number;

    // Opening a switch statement
    switch (number)
    {

        // if number equals 1
        case 1:
            // A certain output
            cout << "\n>You entered: " << number << endl << endl;
            cout << ">The Roman numeral equivalent is: I\n\n";
            break;

        // if number equals 2
        case 2:
            // A certain output
            cout << "\n>You entered: " << number << endl << endl;
            cout << ">The Roman numeral equivalent is: II\n\n";
            break;

        // if number equals 3
        case 3:
            // A certain output
            cout << "\n>You entered: " << number << endl << endl;
            cout << ">The Roman numeral equivalent is: III\n\n";
            break;

        // if number equals 4
        case 4:
            // A certain output
            cout << "\n>You entered: " << number << endl << endl;
            cout << ">The Roman numeral equivalent is: IV\n\n";
            break;
        // if number equals 5
        case 5:
            // A certain output
            cout << "\n>You entered: " << number << endl << endl;
            cout << "> The Roman numeral equivalent is: V\n\n";
            break;
        // if number does not equal an integer between 1 and 5
        default:
            // An error message is displayed and the program terminates
            cout << "\n >ERROR: The number must be an integer in the range of 1 through 5 inclusive.\n\n";
            break;
    }
    // end of program
    return 0;

    }
