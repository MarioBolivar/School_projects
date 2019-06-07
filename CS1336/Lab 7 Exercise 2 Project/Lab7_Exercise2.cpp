// Lab 7 Exercise 2
// Percentages of numbers input from a file.
//
// Program by: Mario Bolivar -- mjb160330

// Declaring Preprocessor Directives
#include <iostream>
#include <string>
#include <fstream>
#include <iomanip>

using namespace std;

int main()
{
    // Defining the name of the input file to gather the numbers from
    const string InputFileName = "numbers.txt";
    ifstream InputFile;

    // Declaring and defining all of the necessary values to run the loop that
    // will gather the data inputted from the file and simultaneously record if the
    // numbers are positive, negative, or equal to zero.
    double value, negative = 0, positive = 0, zero = 0, amountnegative, amountzero, amountpositive;
    double total = 0;
    int count = 0;

    // Opening the file
    InputFile.open(InputFileName);

    // If/Else check
    if (!InputFile.fail())// If the file opens, the program continues running
    {
        cout << "Input File: <" << InputFileName << "> opened successfully\n";

        // a while loop to gather the values from the Input File
        while(InputFile >> value)
        {
                count++;
                total = count; // To keep track of the total numbers read

                // a series of checks to increment the correct value depending
                // on the numbers read from the input file
                if(value < 0)
                {
                    negative++;
                    }
                else if (value > 0)
                {
                    positive++;
                    }
                else
                {
                    zero++;
                    }
            }

            // Calculating the percentages based on the information gathered
            amountnegative = (negative / total) * 100;
            amountpositive = (positive / total) * 100;
            amountzero = (zero / total) * 100;

            // Outputting the calculated data
            cout << fixed << setprecision(1);
            cout << "\nThere were " << amountnegative << "% numbers less than zero.";
            cout << "\nThere were " << amountzero << "% numbers equal to zero.";
            cout << "\nThere were " << amountpositive << "% numbers greater than zero.\n\n";


        }
    else // if the file does not open, the program terminates
    {
        cout << "   >ERROR! unable to open input file: " << InputFileName << endl;

        }









    return 0;
    }
