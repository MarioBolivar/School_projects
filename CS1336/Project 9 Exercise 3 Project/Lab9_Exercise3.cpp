// Lab 9 Exercise 3
// Currency conversions
//
// Program by: Mario Bolivar -- mjb160330

// This program will get an amount in US dollars from the user and convert it
// to another currency

// Defining Preprocessor Directives
#include <iostream>
#include <iomanip>

using namespace std;

// Defining Constant floats that will be used to convert
// the U.S. dollar amount inputted from the user
const float globEuros = .77;
const float globPesos = 13.07;
const float globYen = 104.75;

// Prototypes of the functions
float convertToYen(float dollars);
void convertToEurosAndPesos(float dollars, float &euros, float &pesos);

int main ()
{
    // Initializing variables
   float dollars, euros, pesos, yen;
   cout << fixed << showpoint << setprecision(2);

   // Defining "dollars" from user input
   cout << "Please input the amount of US Dollars "
        << "you want converted: ";
   cin >> dollars;

    // Calling functions to complete calculations
    yen = convertToYen(dollars);
    convertToEurosAndPesos(dollars, euros, pesos);

    // Outputting results
    cout << "The value of $" << dollars << " is: \n";
    cout << "   > " << yen << " Yen\n";
    cout << "   > " << euros << " Euros\n";
    cout << "   > " << pesos << " Pesos\n";

    cout << "\nThank you for using this program.\n\n";

   return 0;
}

// Function that converts dollars to Yen
float convertToYen(float dollars)
{
    return dollars * globYen;
}

// Function that converts dollars to Euros and Pesos
void convertToEurosAndPesos(float dollars, float &euros, float &pesos)
{
    euros = dollars * globEuros;
    pesos = dollars * globPesos;
}
