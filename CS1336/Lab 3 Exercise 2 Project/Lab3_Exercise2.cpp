// Lab 3 Exercise 2
// Calculate MPH (Miles Per Hour) and KPH (Kilometers Per Hour)
//
// Program by: Mario Bolivar


// Declaring Preprocessor Directives
#include <iostream>
#include <iomanip>

using namespace std;

int main()
{

// Assigning Variables
    float Starting_Mileage;
    float Ending_Mileage;
    float Total_Hours;

// Prompting the user to input the value of the starting mileage
    cout <<  "What was the starting mileage before your trip?: ";
    cin >> Starting_Mileage;
    cout << endl << endl;

// Prompting the user to input the value of the ending mileage
    cout << "What was the ending mileage after your trip?: ";
    cin >> Ending_Mileage;
    cout << endl << endl;

// Prompting the user to input the value of the total hours the trip took
    cout << "Enter the total hours the trip took: ";
    cin >> Total_Hours;
    cout << endl << endl;


// Calculating Values of Miles Traveled, MPH, Kilometers traveled, and KMH.
    float Miles_Traveled = Ending_Mileage - Starting_Mileage;
    float MPH = Miles_Traveled / Total_Hours;
    float Kilometers_Traveled = Miles_Traveled / 0.62137;
    float KMH = Kilometers_Traveled / Total_Hours;

// Displaying the values calculated
    cout << fixed << right << setprecision(1)<< "Total Miles: ";
    cout << setw(15)<< Miles_Traveled << endl << endl;
    cout << setw(13)<< "Miles/Hour: " << setw(15)<< MPH << endl << endl;
    cout << "Total Kilometers: " << setw(10)<< Kilometers_Traveled << endl << endl;
    cout << setw (18)<< "Kilometers/Hour: " << setw (10)<< KMH << endl << endl;

    return 0;

}
