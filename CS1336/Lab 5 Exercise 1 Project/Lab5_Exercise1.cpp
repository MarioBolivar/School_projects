// Lab 5 Exercise 1
// Financial aid program
//
// Program by: Mario Bolivar

// Declaring Preprocessor Directive
#include <iostream>

using namespace std;

int main()
{
    // Assigning the char undegradStudent to the input from the user
    char undergradStudent;
    cout << ">Are you an undergraduate student? (Y/N): ";
    cin >> undergradStudent;
    cin.ignore(256, '\n');


    // If statement for when the char input equals yes
    if (undergradStudent == 'Y' || undergradStudent == 'y')
        {
                // Displaying an output
                cout << "\n>You entered: Yes\n\n";

                // Assigning the int yearlyIncome to a user input that will later calculate how much
                // Financial aid the user will be eligible for
                int yearlyIncome;
                cout << ">What is your current yearly income? (Please enter whole number): $";
                cin >> yearlyIncome;
                cout << "\n>You entered: $" << yearlyIncome << endl << endl;

                    // If statement to check if the int yearlyIncome is less than or equal to 15,000
                    if (yearlyIncome <= 15000)
                    {
                        // Output that states how much financial aid the user qualifies for
                        cout << ">You qualify for $1000 in financial aid.\n\n";
                        }

                    // If statement to check if the int yearlyIncome is greater than 15,000
                    if (yearlyIncome > 15000)
                    {
                        // Output that states how much financial aid the user qualifies for
                        cout << ">You qualify for $500 in financial aid.\n\n";
                        }
            }

    // If statement for when UndergradStudent equals No.
    else if (undergradStudent == 'N' || undergradStudent == 'n')
        {
                // Output
                cout << ">You entered: No\n\n";

                // The user does not qualify for Financial aid.
                cout << ">You do not qualify for financial aid.\n\n";

            }

    // Error check for invalid input
    else
        {
            cout << ">ERROR: Input should be Y/N\n\n";
            }

    return 0;
}

