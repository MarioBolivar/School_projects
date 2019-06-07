#include "Calculator.h"

//Constructor
Calculator::Calculator(){
    string newPostfixExpression;
    
    cout << "Please input an infix expression to convert: ";
    cin >> infixExpression;

    newPostfixExpression = InfixToPostfixConverter(infixExpression);
}

//Converts an infix expression -> postfix
string Calculator::InfixToPostfixConverter(string infixExpression){
    Stack memStack;
    char peeking;

    cout << "\nThe converted postfix Expression: ";

    //looping through expression
    for (int i = 0; i < infixExpression.length(); i++){

        //If current char is a digit, output it
        if(isalnum(infixExpression[i])){
            cout << infixExpression[i];
        }
        //if current char is an operator,
        else if(infixExpression[i] == '+' || infixExpression[i] == '-' || infixExpression[i] == '*' || infixExpression[i] == '/' ){
            
            //Check what the next char is
            peeking = memStack.peek();
            
            //output and pop all operators of >= precedence
            if(infixExpression[i] == '/' || infixExpression[i] == '*'){
                
                
                // if next char >= precedence, output next char and push operator
                if(peeking == '/' || peeking == '*'){
                    cout << peeking;
                    memStack.pop(peeking);
                }

                
                   
            }else if(infixExpression[i] == '+' || infixExpression[i] == '-'){
                
                
                if(peeking == '+' || peeking == '-' || infixExpression[i] == '*' || infixExpression[i] == '/'){
                    cout << peeking;
                    memStack.pop(peeking);
                }

              
            }
            
            memStack.push(infixExpression[i]);

        }else if(infixExpression[i] == '(' || infixExpression[i] == ')'){
            
            //if char == (, push
            if(infixExpression[i] == '('){
                memStack.push(infixExpression[i]);
            }
            //else, pop and output all operators until (
            else{
                
                while(!memStack.isEmpty() && memStack.peek() != NULL){
                    
                    //if char on stack == (, pop it without output.
                    if(memStack.peek() == '('){
                        memStack.pop(peeking);
                    }
                    //else, output and pop all operators 
                    else{

                        memStack.pop(peeking);
                        cout << peeking;
                        
                    }
                }
            }
        }
    }

    //if no more input, pop and output all operators on stack
    while(!memStack.isEmpty() && memStack.peek() != NULL){

            memStack.pop(peeking);
            cout << peeking;               
    }

    return "This is useless";
}


//Expression Evaluation Function
int Calculator::PostfixCalculator(string Expression){
    Stack stackMem;
    int total = 0;
    char cTotal;



        for(int i = 0; i < Expression.length();i++){

            //If a number (operand)
            if(isdigit(Expression[i])){

                //push onto stack
                stackMem.push(Expression[i]);

            }
            //If an operator
            else if(Expression[i] == '+' || Expression[i] == '-' || Expression[i] == '*' || Expression[i] == '/' ){

                char one,two;
                int op1 = 0,op2 = 0;
                //pop two operands off of stack
                stackMem.pop(two);
                stackMem.pop(one);

                //char -> int
                op1 = one - '0';
                op2 = two - '0';


                //perform operation
                if(Expression[i] == '/'){
                    total = op1 / op2;
                }else if(Expression[i] == '*'){
                    total = op1 * op2;
                }else if(Expression[i] == '+'){
                    total = op1 + op2;
                }else{
                    total = op1 - op2;
                }

                //store result on stack
                stackMem.push((static_cast<char>(total) + '0'));
            }
        }
    
    //get final answer
    stackMem.pop(cTotal);
    total = cTotal - '0';

    return total;

}
