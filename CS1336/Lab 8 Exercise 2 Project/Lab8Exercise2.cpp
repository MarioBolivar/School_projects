// Lab 8 Exercise 2
// Determine if your heart beat rate is within the
// target heart rate.
//
// Program by: Mario Bolivar--mjb160330

// This program determines whether the user is within his
// target heart rate range depending on his age and heartbeats
// per minute which are inputted by the user.

// Defining preprocessor directives
#include <iostream>

using namespace std;

// function prototype
bool targetHeartRate(int age, int hearbeat);


int main()
{
    // initializing variables
    int age;
    int heartbeats;
    bool check;

    // do while to prompt the user for inputs atleast once
    do
    {
        // prompting the user for his age
        cout << "Please enter your age: ";
        cin >> age;
        cin.ignore(10000, '\n');
        cin.clear();

        // if check to continue prompting
        if (age > 0 )
        {
            // prompting the user for heartbeats
            cout << "Please enter your heartbeats per minute: ";
            cin >> heartbeats;
            cin.ignore(10000, '\n');
            cin.clear();

            // calling the function to calculate the user's
            // target heart rate
            check = targetHeartRate(age, heartbeats);

                // if checks to determine whether the user is in their target heart rate
                // range according to their inputs
                if (check)
                {
                    cout << "Congratulations! You are in your target heart rate!\n";
                    cout << "\n***************************************************\n\n";

                }
                else
                {
                    cout << "You are not in your target heart rate\n";
                    cout << "\n***************************************************\n\n";

                }

        }


    }while(age > 0);

    return 0;
}

// function that calculates the user's target heart rate
// according to their inputs
bool targetHeartRate(int age, int heartbeat)
{
    // calculating variables
    int maxHeartRate = 220 - age;
    int minTargetHeartRate = maxHeartRate * .6;
    int maxTargetHearRate = maxHeartRate * .7;

    // if checks according to calculations to determine
    // whether to return true/false
    if (heartbeat > minTargetHeartRate && heartbeat <= maxHeartRate)
    {
        return true;
    }
    else
    {
        return false;
    }
}
