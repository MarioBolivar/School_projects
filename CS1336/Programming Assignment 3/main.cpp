#include <iostream>

using namespace std;

int main()
{
    int x,minimum = x,maximum = x;
    cout << "Please enter a series of positive integers\n";
    cout << "Input as many as you'd like\n";
    cout << "When finished inputting, enter '-99' to exit\n";

    do
    {
        cout << "Integer: ";
        cin >> x;
        cin.ignore(10000, '\n');
        cin.clear();

        while(x < 0 && x != -99)
        {
            cout << "WARNING: That is not a positive integer\n";
            cout << "Please continue to enter a series of positive integers.\n";
            cout << "When you are finished, enter '-99'\n";
            cout << "Integer: ";
            cin >> x;
            cin.ignore(10000, '\n');
            cin.clear();


        }

        if (minimum > x && x != -99){
            minimum = x;
        }
        if(maximum < x && x != -99)
        {
            maximum = x;
        }



    }while (x != -99);

        cout << "Minimum:" << minimum << endl;
        cout << "Maximum:" << maximum << endl;

    return 0;
}
