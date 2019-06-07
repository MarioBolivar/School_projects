#include "Calculator.h"

//Constructor
Calculator::Calculator(){
    int total;
    char cTotal;
    bool expressionCheck;
    
    //If user input fails, keep prompting for correct input
    do{
        expressionCheck = true;
        cout << "Please input a postfix expression to evaluate: ";
        cin >> postfixExpression;

        //validating the expression
        for(int i = 0; i < postfixExpression.size();i++){
            //If an operator
           if(isdigit(postfixExpression[i])){
               //do nothing
           }else if(postfixExpression[i] == '+' || postfixExpression[i] == '-' || postfixExpression[i] == '*' || postfixExpression[i] == '/' ){

                //If next char is also an operand, fail the Expression.
                if(postfixExpression[(i + 1)] == '+' || postfixExpression[(i + 1)] == '-' || postfixExpression[(i + 1)] == '*' || postfixExpression[(i + 1)] == '/' ){
                    expressionCheck = false;
                    cout << "\n >The Expression '" << postfixExpression << "' is not valid.\n";
                    cout << "Please enter a correct Expression!\n\n";

                    cout << "Please input a postfix Expression to evaluate: ";
                    cin >> postfixExpression;
                }
           }else{
                    expressionCheck = false;
                    cout << "\n >The Expression '" << postfixExpression << "' is not valid.\n";
                    cout << "Please enter a correct Expression!\n\n";

                    cout << "Please input a postfix Expression to evaluate: ";
                    cin >> postfixExpression;
                }


        }

    }while(!expressionCheck);

    //Calculate total
    total = PostfixCalculator(postfixExpression);

    //output total
    cout << "The total is: " << total << endl;
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
