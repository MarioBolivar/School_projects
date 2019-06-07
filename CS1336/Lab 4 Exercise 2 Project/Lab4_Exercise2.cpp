// Lab 4 Exercise 2
// History grading project
//
// Program by: Mario Bolivar

// defining preprocessor directives
#include <iostream>
#include <iomanip>

using namespace std;

int main(){

// Initializing test variables
    double test1, test2, test3;

    // defining test variables from user input
    cout << "Enter the score for test 1: ";
    cin >> test1;
    cout << endl;

    cout << "Enter the score for test 2: ";
    cin >> test2;
    cout << endl;

    cout << "Enter the score for test 3: ";
    cin >> test3;
    cout << endl;

    // Outputting right-aligned user inputs (test1, test2. and test3)
    cout << right << "First Test: " << setw(10)<< test1 << endl;
    cout << "Second Test: " << setw(9)<< test2 << endl;
    cout << "Third Test: " << setw(10)<< test3 << endl << endl;

// Defining "Final1" variable depending on its relation to test1 and test2.
double Final1;

     if (test1 > test2)
    {
        Final1 = test1;
     }
        else
        {
        Final1 = test2;
            }

// Defining "addedtests" variable
double addedtests = Final1 + test3;

// Initializing "letterGrade" variable
char letterGrade;

// Defining a tree of "if" checks to define what "letterGrade" is
    if (addedtests >= 92)
    {
        letterGrade = 'A';
        }
        else if (addedtests < 92 && addedtests >= 82)
            {
               letterGrade = 'B';
                }
        else if (addedtests < 82 && addedtests >= 72)
            {
               letterGrade = 'C';
            }
        else
            {
               letterGrade = 'F';
                }

    // Defining an "if" check to determine whether test1 or test2 was dropped
    // Depending on what check is true, an output is displayed
    if (Final1 == test1)
    {
        cout << "After dropping Test #2, the points earned are: " << addedtests << "." << endl;
        cout << "The letter grade is " << letterGrade << "." << endl << endl;
        }
        else if (Final1 == test2)
                {
                    cout << "After dropping Test #1, the points earned are: " << addedtests << "." << endl;
                    cout << "The letter grade is " << letterGrade << "." << endl << endl;
                    }

    return 0;
}

