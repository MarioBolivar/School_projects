#ifndef CALCULATOR_H
#define CALCULATOR_H
#include <iostream>
#include "StackClass.h"

using namespace std;

//Calculator class which calculates the total
//gathered from an expression from user input
class Calculator{
public:
    //Constructor
    Calculator();

    //Calculates total
    int PostfixCalculator(string);

private:
    //holds user expression
    string postfixExpression;
};

#endif