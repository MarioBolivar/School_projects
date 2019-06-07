// CS 1136 Lab 2 Exercise 2
// Program by: Mario Bolivar

/* This Program is to calculate the markup and selling price for a circuit board using
 * several values and variables */


#include <iostream>
using namespace std;

int main (){

// Allowing for the user to input the variable Man_Price and assign that input as the variable
    float Man_Price;

        cout << "What is the manufacture price? $";
            cin >> Man_Price;

        cout << "____________________________________";

        cout << "\n\nSo,\n\n";

        cout << "If the manufacture price is: $" << Man_Price << endl << endl;

        cout << "Then,\n\n";

// Setting Mark_Percent as a constant double as it will not change
    const double Mark_Percent = .425 ;


    float Mark_Amount;

        Mark_Amount = Man_Price * Mark_Percent;


// Setting the Selling_Price given Man_Price and Mark_Amount
    float Selling_Price;

        Selling_Price = Man_Price + Mark_Amount;


// Displaying the results
    cout << "The markup for the circuit board is: $" << Mark_Amount << endl << endl;

    cout << "And, \n\n";

    cout << "The selling price of the circuit boards is: $" << Selling_Price << endl << endl;

    cout << "Thank you, come again!\n\n\n\n\n";

    int height = 10, width = 5, depth = 2;

    cout << height << endl << width << endl << depth << endl;
    return 0;

}


