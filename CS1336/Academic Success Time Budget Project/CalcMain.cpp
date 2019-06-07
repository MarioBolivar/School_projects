/* This program is to calculate and budget your free time */

#include <iostream>

using namespace std;

int main(){

        cout << "This is the Academic Success Time Budget Program.|" << endl;
        cout << "--------------------------------------------------" << endl << endl << endl;
        cout << "Do you wish to continue?:\a ";

    string yes2;
        cin >> yes2;
        cout << endl << endl;

        cout << ":There is a total of 168 hours available each week," << endl << endl << endl;

        cout << "So, let's begin:" << endl << endl << endl;

    float hoursAvailable;
        hoursAvailable = 168.00f;

    float hoursClass;

        cout << "*Reminder all of these inputs are (Per Week!)*" << endl << endl;
        cout << "How many hours of class are you taking?: ";
            cin >> hoursClass;
        cout << endl << endl << endl;

    float hoursStudy;
        cout << "How many hours of study time will you be dedicating?: ";
            cin >> hoursStudy;
        cout << endl << endl << endl;

    float hoursSleep;
        cout << "How many hours of sleep/personal hygiene will you be dedicating?: ";
            cin >> hoursSleep;
        cout << endl << endl << endl;

    float hoursJob;
        cout << "How many hours of committed time per week?" << endl;
        cout << "(e.g. job, church, clubs, meetings): ";
            cin >> hoursJob;
         cout << endl << endl << endl;

    float hoursFood;
        cout << "How many hours of meal time will you be dedicating?: ";
            cin >> hoursFood;
        cout << endl << endl << endl;

    float hoursExercise;
        cout << "How many hours of exercise?: ";
            cin >> hoursExercise;
        cout << endl << endl << endl;

    float hoursFamily;
        cout << "How many hours of family time?: ";
            cin >> hoursFamily;
        cout << endl << endl << endl;

    float hoursErrands;
        cout << "How many hours of laundry, shopping, personal errands?: ";
            cin >> hoursErrands;
        cout << endl << endl << endl;

    float hoursTelevision;
        cout << "How many hours of television?: ";
            cin >> hoursTelevision;
        cout << endl << endl << endl;

    float hoursFacebook;
        cout << "How many hours of Facebook/Video games, etc?: ";
            cin >> hoursFacebook;
        cout << endl << endl << endl;

    float hoursRec;
        cout << "How many hours of other recreation per week? (Movies, parties, etc): ";
            cin >> hoursRec;
        cout << endl << endl << endl;

    float hoursMisc;
        cout << "How many hours other? (miscellaneous):";
            cin >> hoursMisc;
        cout << endl << endl << endl;

    float FinalBalance;
        FinalBalance = hoursClass + hoursStudy + hoursSleep + hoursJob + hoursFood + hoursExercise + hoursFamily + hoursErrands + hoursTelevision + hoursFacebook + hoursRec + hoursMisc;

    float freeTime;cout << endl << endl << endl;
        freeTime = hoursAvailable - FinalBalance;

    cout << "Cool beans, Check it!: " << endl;
    cout << "----------------------------------------------------------------------" << endl << endl << endl;


string yes;
    cout << "Do you wish to continue?: \a";
        cin >> yes;
    cout << endl << endl << endl;

    cout << "Your final balance of all of your necessary hours is: " << FinalBalance << " hours" << endl << endl;
    cout << "Your available free time is: " << freeTime << " hours" << endl << endl << endl;
    cout << "Adjust your hours accordingly and see what you can + or - \n\n Goodluck!! :D" << endl << endl;


return 0 ;
}




