// Lab 3 Exercise 1
// Input Using cin >>
// Program by: Mario Bolivar

// declaring preprocessor directives
#include <iostream>
#include <string>

using namespace std;

int main(){

    // declaring the variables that will be inputted by the user
    float floatValue;
    int intValue;
    char ch1, ch2;
    string name;

    // reads one character from the user
        cout << "Enter a character: ";
        cin >> ch1;

    // reads in an int value from the user
        cout << "Enter a number: ";
        cin >> intValue;

    // reads another character from the user
        cout << "Enter another character: ";
        cin >> ch2;

    // reads in a string from the user
        cout << "Enter a name: ";
        cin >> name;

    // reads in a float type from the user
        cout << "Enter a floating point value: ";
        cin >> floatValue;

    // Displays the values read from the user
        cout << endl << endl << "ch1 = " << ch1 << endl << endl;
        cout << "intValue = " << intValue << endl << endl;
        cout << "ch2 = " << ch2 << endl << endl;
        cout << "Name is: " << name << endl << endl;
        cout << "floatValue = " << floatValue << endl << endl;

        return 0;
}
