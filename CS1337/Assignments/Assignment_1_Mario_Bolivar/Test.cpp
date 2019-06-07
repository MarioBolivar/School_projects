#include <iostream>

using namespace std;

struct Test
{
    int number;
    string line;
    bool validation;

};


int main()
{


    Test one;
    one.number = 3;
    one.line = "Hi";
    one.validation = false;

    cout << one.number << endl;
    cout << one.line << endl;
    cout << one.validation << endl;

    Test *two = new Test;
    two->number = 25;
    two->line = "hello";
    two->validation = true;

    cout << two->number << endl;
    cout << two->line << endl;
    cout << two->validation << endl;
    return 0;
}