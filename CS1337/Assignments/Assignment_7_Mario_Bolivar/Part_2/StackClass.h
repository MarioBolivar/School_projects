#ifndef STACKCLASS_H
#define STACKCLASS_H
#include <iostream>

using namespace std;

//Class for a memory of LIFO architecture
class Stack{
private:

    //stack
    struct StackNode{
        char character;
        StackNode *next;

    };

    //stack pointer that points to the top of the stack
    StackNode *top;

public:                       
    //Constructor
    Stack();

    //Destructor
    ~Stack();

    //pushes a char into the stack
    void push(char);

    //pops a char from the stack
    void pop(char &);

    //peek into the top of the stack
    char peek() const;

    //checks if the stack is empty
    bool isEmpty() const;
  
};

#endif