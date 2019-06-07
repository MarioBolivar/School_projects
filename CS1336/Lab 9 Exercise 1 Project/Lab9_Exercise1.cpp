// Lab 9 Exercise 1
// The gross and net pay application
//
// Program by:     Mario Bolivar // Mjb160330
// This Program calculates Gross and Net Pay of the user using
// inputs defined by the user

// Defining Preprocessor Directives
#include <iostream>
#include <iomanip>

using namespace std;

// Function prototypes
// Print out the program description
void printDescription();
// Calculate gross pay
float computeGrossPay(float, int);
// Calculate net pay
float computeNetPay(float);

int main()
{
   // variables for
   float payRate;
   float grossPay;
   float netPay;
   int hours;

   cout << setprecision(2) << fixed;
   cout << "Welcome to the Payroll Program" << endl;

   printDescription(); //Call to Description function

   // Get the pay rate and number of hours from the user
   cout << "Please input the pay per hour: ";
   cin >> payRate;

   cout << endl << "Please input the number of hours worked: ";
   cin >> hours;

    // calculating the gross pay and outputting the results
   grossPay = computeGrossPay(payRate, hours);
    cout << "   > Your Gross Pay amount is: $" << grossPay << endl;

    // calculating the net pay and outputting the results
   netPay = computeNetPay(grossPay);
    cout << "   > Your Net Pay amount is: $" << netPay << endl;

   cout << "\nWe hope you enjoyed this program." << endl;

   return 0;
}

// ********************************************************************
// printDescription
//
// task: This function prints a program description
// data in: none
// data out: none
//
// ********************************************************************
void printDescription() //The function heading
{
   cout << endl;
   cout << "*************************************************" << endl;
   cout << "This program takes two numbers (pay rate & hours)"
        << endl;
   cout << "and multiplies them to get gross pay. The program "
        << endl;
   cout << "then calculates net pay by subtracting 15%" << endl;
   cout << "*************************************************" << endl
        << endl;
}


// *********************************************************************
// computeGrossPay
//
// task: This function takes rate and time and multiples them to
// get gross pay.
// data in: pay rate and time in hours worked
// data out: the gross pay
//
// ********************************************************************
float computeGrossPay(float rate, int time)
{
    return rate * time;
}

// *********************************************************************
// computeNetPay
//
// task: This function takes the gross pay and reduces it by 15%
//
// data in: gross pay
// data out: the net pay
//
// ********************************************************************
float computeNetPay(float gross)
{
    return gross - (gross * .15);
}
