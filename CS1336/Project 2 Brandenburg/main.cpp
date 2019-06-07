// CS 1336.504 Project 2 <mjb160330> <Mario Bolivar>

// Defining preprocessor directives
#include <iostream>
#include <iomanip>
#include <stdlib.h>

using namespace std;

int main()
{

    // Outputting Information to describe the packages to select from
    cout << "Note:" << endl << endl;
    cout << "Package A:"<< setw(49) << "* Contains 5000 megabytes for $29.99 per month" << endl;
    cout << right << setw(44) << "* $0.05 per additional megabyte" << endl;
    cout << right << setw(54) << "* $0.03 per additional megabyte if 50% or" << endl;
    cout << right << setw(52) << "* more of the data was used on weekends" << endl;

    cout << "_________________________________";
    cout << "__________________________" << endl << endl;

    cout << "Package B:"<< setw(49) << "* Contains 7500 megabytes for $39.99 per month" << endl;
    cout << right << setw(44) << "* $0.01 per additional megabyte" << endl;

    cout << "_________________________________";
    cout << "__________________________" << endl << endl;

    cout << "Package C:"<< setw(49) << "* Contains unlimited data for $49.99 per month" << endl;

    cout << "_________________________________";
    cout << "__________________________" << endl << endl;

    // initializing a char to be inputted from the user, defining what package was selected
   char planpurchased;
    cout << "Please enter A, B, or C to indicate the plan purchased: ";
    cin >> planpurchased;
    cin.ignore(256, '\n');
    cout << endl;



// Defining a tree of "if" checks that process different operations
// depending on what package was chosen
// In this instance, package 'A' was chosen and a set of code was read and processed
   if (planpurchased == 'A' || planpurchased == 'a')
   {
        // outputting the package chosen
          cout << "You selected Package: A" << endl << endl;

        // Initializing the value for how much data was used and assigning it to a user input
           int dataused;
                cout << "Please enter the amount of data the customer used" << endl;
                cout << "(Note: This number should be a whole, non-negative number): ";
                cin >> dataused;
                cin.ignore(256, '\n');

                // Setting up an if check for when the value of "dataused" is greater than zero
                if (dataused > 0)
                {
                            cout << "You entered: " <<  dataused << " MB" << endl << endl;

                    const double PLANA = 29.99;

                // Setting up an if check for when the value of "dataused" is greater than 5000
                    if (dataused > 5000)
                    {

                        // Assigning the char "discount" to user input
                        char discount;
                            cout << "Did the customer use 50% or more of the data on the weekend? (Y/N): ";
                            cin >> discount;
                            cin.ignore(256, '\n');
                            cout << endl << endl;
                            int extradata = dataused - 5000;
                        if (discount == 'Y' || discount == 'y')
                            {
                                    cout << "The extra megabytes the customer will be charged for are: " << abs(extradata) << " MB" << endl << endl;
                                    cout << "Customer will receive a weekend data usage discount: true" << endl << endl;

                                // calculating the total cost of the package
                                double totalcost;
                                    totalcost = PLANA +(abs(extradata)* 0.03);
                                    cout << "The customer's total cost for the month is: $" << totalcost << endl << endl;

                                   // setting up an if check of when total cost is greater than $39.99
                                   if (totalcost > 39.99)
                                    {
                                        double savingsPackageB = totalcost - 39.99;
                                        cout << "Customer would have saved $" << fixed << setprecision(2)<< savingsPackageB << " on package B" << endl << endl;

                                            // setting up an if check of when total cost is greater than $49.99
                                            if (totalcost > 49.99)
                                            {
                                                float savingsPackageC = totalcost - 49.99;
                                                    cout << "Customer would have saved $" << fixed << setprecision(2)<< savingsPackageC << " on package C" << endl << endl;
                                                }
                                        }
                                }
                        else if (discount == 'N' || discount == 'n' )
                            {
                                    cout << "Customer will receive a weekend data usage discount: false" << endl << endl;

                                double totalcost;
                                    totalcost = PLANA + (abs(extradata)* 0.05);
                                    cout << "The customer's total cost for the month is: $" << totalcost << endl;

                                     if (totalcost > 39.99)
                                    {
                                        double savingsPackageB = totalcost - 39.99;
                                        cout << "Customer would have saved $" << fixed << setprecision(2)<< savingsPackageB << " on package B" << endl << endl;

                                            if (totalcost > 49.99)
                                            {
                                                double savingsPackageC = totalcost - 49.99;
                                                    cout << "Customer would have saved $" << fixed << setprecision(2)<< savingsPackageC << " on package C" << endl << endl;
                                                }
                                        }

                                }
                        else
                            {
                                    cout << "> Input should be Y/N <" << endl;
                                    // Terminate Program
                                }
                    }
               else if ( dataused <= 5000 && dataused > 0 )
                {
                        cout << "Customer will receive a weekend data usage discount: false" << endl << endl;

                    double totalcost;
                        totalcost = PLANA ;
                        cout << "The customer's total cost for the month is: $" << totalcost << endl;
                    }

            }

             else
                {
                    cout << "\n> Input should only an integer greater than zero! <" << endl;
                    // Terminate Program
                    }
        }

    else if (planpurchased == 'B' || planpurchased == 'b')
    {
                cout << "You selected Package: B" << endl << endl;

           int dataused;
                cout << "Please enter the amount of data the customer used" << endl;
                cout << "(Note: This number should be a whole, non-negative number): ";
                cin >> dataused;
                cin.ignore(256, '\n');
                            const double PLANB = 39.99;
             if(cin.fail())
             {
                     cout << "\n> Input should be only an integer! <" << endl;
                     // Terminate Program
                }
                if (dataused > 0)
                {
                                cout << "You entered: " << dataused << " MB" << endl << endl;
                    }
                if (dataused > 7500)
                {

                            int extradata = dataused - 7500;
                                    cout << "The extra megabytes the customer will be charged for are: " << abs(extradata) << " MB" << endl << endl;
                                    cout << "Customer will receive a weekend data usage discount: false" << endl << endl;

                                double totalcost = PLANB +(abs(extradata)* 0.01);
                                    cout << "The customer's total cost for the month is: $" << totalcost << endl;

                                         if (totalcost > 49.99)
                                            {
                                                double savingsPackageC = totalcost - 49.99;
                                                    cout << "Customer would have saved $" << fixed << setprecision(2)<< savingsPackageC << " on package C" << endl << endl;
                                                }
                    }

               else if ( dataused <= 7500 && dataused > 0 )
                {
                        cout << "Customer will receive a weekend data usage discount: false" << endl << endl;

                    double totalcost;
                        totalcost = PLANB ;
                        cout << "The customer's total cost for the month is: $" << totalcost << endl;
                    }
                else
                {
                    cout << "\n> Input should only an integer greater than zero! <" << endl;
                    // Terminate Program
                    }
        }

    else if (planpurchased == 'C' || planpurchased == 'c')
    {
                cout << "You selected Package: C" << endl << endl;
           const double PLANC = 49.99;
                cout << "Customer will receive a weekend data usage discount: false" << endl << endl;
                cout << "The customer's total cost for the month is: $" << PLANC << endl;
    }

    else
    {
            cout << "Input should only be 'A' , 'B' , or 'C' " << endl;
            // Terminate Program
        }


return 0;

}
