/*
 * Author: Carlos Canto
 * NetID: cxc162530
 * Date: Nov 28, 2016
 *
 * Course: CS-1336
 * Section: 009
 * Name: Programming Assignment #4a
 *
 * Description: This program let's the user play the game of "Rock, Paper, Scissors, Lizard, Spock"
 *
 */

// Defining the preprocessor directives
#include <iostream>
#include <ctime>
#include <cstdlib>

using namespace std;

// Declaring the the choices from the user as constant variables.
const int ROCK = 1;
const int PAPER = 2;
const int SCISSORS = 3;
const int LIZARD = 4;
const int SPOCK = 5;
const int SURRENDER = 0;


// Function prototypes
int userchoiceinput();
int cpuchoiceinput();
void winner(int, int);
void displayinputs(int);


int main()
{
        // Initializing two variables that will be used
        // to set the values for the functions \\ parameter lists
        int userinput, cpuinput;

        // Defining the two variables to their according
        // function
        userinput = userchoiceinput();
        cpuinput = cpuchoiceinput();

        // Using the appropriate functions as the parameter list, the "winner"
        // function is run and displays the winner of the game.
        winner(userinput, cpuinput);


    return 0;
}

// Generating a random number from 1-5 depending on the time
// that the program is read
int cpuchoiceinput()
{
    int Cpuchoice;
    srand(time(NULL));
    Cpuchoice = rand() % 5 + 1;
    return Cpuchoice;
}

// Reading in the user's input
int userchoiceinput()
{
    int UsrChoice;

    cout << " ______________________________________________\n";
    cout << "|                                              |\n";
    cout << "|           THIS    IS     THE                 |\n";
    cout << "|                  GAME                        |\n";
    cout << "|                   OF                         |\n";
    cout << "|       -----------------------------          |\n";
    cout << "|     ~ROCK~     ~PAPER~    ~SCISSORS~         |\n";
    cout << "|        ~LIZARD~       ~SPOCK~                |\n";
    cout << "|**********************************************|\n";
    cout << "|                1  =  ROCK                    |\n";
    cout << "|                2  =  PAPER                   |\n";
    cout << "|                3  =  SCISSORS                |\n";
    cout << "|                4  =  LIZARD                  |\n";
    cout << "|                5  =  SPOCK                   |\n";
    cout << "|      ENTER 0 FOR A DISGRACEFUL SURRENDER     |\n";
    cout << "|______________________________________________|\n\n\n\n";

    cout << "What will you be today? A winner...or a loser?";
    cout << " You decide...\n   > What will it be?: ";
    cin >> UsrChoice;
    cin.ignore(10000, '\n');
    cin.clear();
    cout << endl << endl;

    // While loop for invalid inputs
    while (UsrChoice < 0 || UsrChoice > 5)
    {
        cout << "Beware... Enter a valid choice.. or else...\n";
        cout << "   > What will it be?: ";
        cin >> UsrChoice;
        cin.ignore(10000, '\n');
        cin.clear();
        cout << endl << endl;
    }
    return UsrChoice;
}

// Outputting the cpu\user decisions based on what was chosen
// using a series of if-else checks
void displayinputs(int choice)
{
    if (choice == ROCK)
    {
        cout << "Rock\n";
        }
    else if (choice == PAPER)
    {
        cout << "Paper\n";
        }
    else if (choice == SCISSORS)
    {
        cout << "Scissors\n";
        }
    else if (choice == LIZARD)
    {
        cout << "Lizard\n";
        }
    else if (choice == SPOCK)
    {
        cout << "Spock\n";
        }
    else
    {
        cout << "The easy way out.";
        }
}


// Displaying the winner based on the choices made by the user and cpu
// and also on the conditions set by the series of if checks
void winner(int user, int cpu )
{
    if (user == SURRENDER)
    {
        cout << "You decided...: ";
        displayinputs(user);
        cout << "\n\n\n\n\n\n\n\n\n\n\n\n\n         You disgust me.. coward...";
        cout << "\n\n                                     YOU LOSE\n\n\n\n\n";
        return;
    }

    cout << "The computer chose...: ";
    displayinputs(cpu);
    cout << "You decided...: ";
    displayinputs(user);

    if (user == cpu)
    {
            cout << "\n\n\n\n\n\n\n\n\n\n\n\n\n\nYou are lucky to be alive...\n";
            cout << "\n                              > the game is a tie.\n\n\n";
        }

    if (user == ROCK)
    {
            if (cpu == LIZARD || cpu == SCISSORS)
            {
                    cout << "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nWhat a dissapointment..";
                    cout << "\n\n                          > You win.\n\n";
                }
             if (cpu == PAPER || cpu == SPOCK)
             {
                    cout << "\n\n\n\n\n\n\n\n\n\nHa-Ha-Ha foolish mortal, You had no chance,";
                    cout << " \n\n                                           > YOU LOSE!\n\n\n\n\n\n";
                }
        }

    if (user == PAPER)
    {
            if (cpu == ROCK || cpu == SPOCK)
            {
                    cout << "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nWhat a dissapointment..";
                    cout << "\n\n                          > You win.\n\n";
                }
            if (cpu == SCISSORS || cpu == LIZARD)
            {
                    cout << "\n\n\n\n\n\n\n\n\n\n\nHa-Ha-Ha foolish mortal, You had no chance,";
                    cout << " \n\n                                           > YOU LOSE!\n\n\n\n\n\n";
                }
        }

    if (user == SCISSORS)
    {
            if(cpu == PAPER || cpu == LIZARD)
            {
                    cout << "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nWhat a dissapointment..";
                    cout << "\n                          > You win.\n\n";
                }
            if (cpu == SPOCK || cpu == ROCK)
            {
                    cout << "\n\n\n\n\n\n\n\n\n\n\nHa-Ha-Ha foolish mortal, You had no chance,";
                    cout << " \n\n                                           > YOU LOSE!\n\n\n\n\n\n";
                }
        }

    if (user == LIZARD )
    {
            if (cpu == SPOCK || cpu == PAPER)
            {
                    cout << "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nWhat a dissapointment..";
                    cout << "\n                          > You win.\n\n";
                }
            if (cpu == ROCK || cpu == SCISSORS)
            {
                    cout << "\n\n\n\n\n\n\n\n\n\n\nHa-Ha-Ha foolish mortal, You had no chance,";
                    cout << " \n\n                                           > YOU LOSE!\n\n\n\n\n\n";
                }
        }

    if (user == SPOCK)
    {
            if (cpu == SCISSORS || cpu == ROCK)
            {
                    cout << "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nWhat a dissapointment..";
                    cout << "\n                          > You win.\n\n";
                }
            if (cpu == LIZARD || cpu == PAPER)
            {
                    cout << "\n\n\n\n\n\n\n\n\n\n\nHa-Ha-Ha foolish mortal, You had no chance,";
                    cout << " \n\n                                           > YOU LOSE!\n\n\n\n\n\n";
                }
        }
}
