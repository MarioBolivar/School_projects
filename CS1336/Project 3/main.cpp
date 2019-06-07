// CS 1336.504 Project 3 <mjb160330> <Mario Bolivar>
// Declaring preprocessor directives
#include <iostream>
#include <string>
#include <fstream>


using namespace std;

int main()
{

    // Initializing and declaring variables
    double number;
    ifstream infile;


    // Receiving user input to declare the filename
    cout << "Please enter the name of the file to open: ";
    string filename;
    getline(cin, filename);




    // Opening the user-given filename
    infile.open(filename.c_str());

    // Displaying an error message and terminating the program
    // if the filename given cannot be found/opened
    if(!infile)
    {
        cout << "\n\n > ERROR: File does not exist or cannot otherwise be opened!\n\n";
        cout << "Please re-run the program to try again!";
        }
    // The program continues if the file is able to be opened
    else
    {
        cout << "\n* File <" << filename << "> successfully opened * \n\n";

        // Declaring variables that are used in the while loop
        int count = 0;
        double sum = 0;
        double average = 0;

        // A loop to calculate the sum and average of the numbers from the file
        while (infile >> number)
            {
                ++count;
                sum += number;
                average = (sum / count);

                }

        // outputting the information received and calculated
        cout << "There was " << count << " numbers read from the file.\n\n";
        cout << "The sum of the numbers read from the file is: " << sum << endl << endl;
        cout << "The average of the numbers read from the file is: " << average << endl << endl;

        }

    return 69;
    }
