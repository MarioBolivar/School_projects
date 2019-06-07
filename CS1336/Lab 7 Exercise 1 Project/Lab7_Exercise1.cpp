// Lab 7 Exercise 1
// Display a row of $ characters based on user input
//
// Program by: Mario Bolivar -- mjb160330

// Preprocessor directives
#include <iostream>

using namespace std;

int main()
{

// Creating a five-time loop that will prompt 5 valid numbers from the user
for (int five_prompts = 0; five_prompts < 5; five_prompts++)
{

    // Initializing the int x and prompting the user for a value to assign to it.
    int number_inputted;
    cout << "Enter a number (1-10): ";
    cin >> number_inputted;
    cin.ignore(INT_MAX, '\n');
    cin.clear();


    // While the int x is less than 1 and greater than 10, an error loop will occur
    // prompting the user to type in a valid input
     while (number_inputted < 1 || number_inputted > 10)
        {
            cout << "   >ERROR: Invalid input!\n\n";
            cout << "Enter a number (1-10): ";
            cin >> number_inputted;
            cin.ignore(INT_MAX, '\n');
            cin.clear();
            }

    // This is the for loop that outputs an amount dollar signs depending
    // on the number inputted from the user
    for (int j = 1; j <= number_inputted; j++)
    {
        cout << "$";

        }

    // New lines for my OCD
    cout << endl << endl;

    }


    return 0;
}
