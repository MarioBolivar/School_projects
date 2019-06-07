// CS 1336.504 Project 3 <mjb160330> <Mario Bolivar>

#include <iostream>
#include <string>
#include <fstream>


using namespace std;

int main()
{
    ifstream infile;
    string filename;
    cout << "Please enter the name of the file to open: ";
    cin >> filename;
    cin.ignore(INT_MAX, '\n');
    cin.clear();

    infile.open(filename);
    if(!infile)
    {
        cout << "\n\n > ERROR: File does not exist or cannot otherwise be opened!\n\n";
        cout << "Please re-run the program to try again!";
        }
    else
    {
        cout << "* File successfully opened * \n\n";



        }







    return 0;
    }
