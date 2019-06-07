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

    //Converts an infix expression to postfix
    string InfixToPostfixConverter(string);



private:
    //holds user postfix expression
    string postfixExpression;
    
    //holds user infix expression
    string infixExpression;
};

#endif