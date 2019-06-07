#include "StackClass.h"

//Constructor
Stack::Stack(){
    top = NULL;
}

//Push item into stack
void Stack::push(char x){
    StackNode *newNode = new StackNode;
    newNode->character = x;

    if(isEmpty()){
        top = newNode;
        newNode->next = NULL;
    }else{
        newNode->next = top;
        top = newNode;
    }
}

//Pop item from stack
void Stack::pop(char &y){
    StackNode *temp = NULL;

    if(isEmpty()){
        cout << "The stack is empty.\n";
    }else{
        y = top->character;
        temp = top->next;
        delete top;
        top = temp;
    }
}

//Check to see what is at the top of the stack
char Stack::peek() const{
    if(top == NULL){
        return NULL;
    }else{
        return top->character;
    }
    
}

//Check if the stack is empty
bool Stack::isEmpty() const{
    bool status;
    if(!top){
        status = true;
    }else{
        status = false;
    }
    return status;
}
//Destructor
Stack::~Stack(){
    StackNode *nodePtr = NULL, *nextNode = NULL;

    nodePtr = top;

    while(nodePtr != NULL){
        nextNode = nodePtr->next;
        delete nodePtr;
        nodePtr = nextNode;
    }
}

