
package in_class_assignment_4;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mario Bolivar - Mjb160330
 * @author Cooper Omundson- cao170130
 *
 */
public class In_Class_Assignment_4 {

    public static void main(String[] args) {
        outputFile("output.txt",inputFile("input.txt"));
    }
    
    public static ArrayList inputFile(String fileName){
        ArrayList<String> list = new ArrayList<>();
        
        try{
            File file = new File(fileName);
            Scanner input = new Scanner(file);
            String currentLine = "";
            String postFix = "";
            
            while(input.hasNextLine()){
                currentLine = input.nextLine();
                System.out.println(currentLine);
                StackClass stack = new StackClass();
                
                for(char c : currentLine.toCharArray()){
                    
                    //when at the end of string, pop everything off of stack and append it to postfix expression
                    if(c == currentLine.length()){
                        while(stack.getSize() != 0){
                            
                            String s = "" + (stack.pop()).getChar();
                            postFix += s;
                            
                        }
                    }else if(c == ')'){ //when right parenthesis is encountered, pop and append stack until left is encountered
                        
                        while(stack.getSize() != 0){
                            char x = (stack.pop()).getChar();
                            if(x ==  '('){
                                break;
                            }else{
                                String s = "" + (stack.pop()).getChar();
                                postFix += s;
                            }
                        }
                    }else if(c == '*' || c == '/' || c == '^' || c == '+' || c == '-' ){ //If we get an operator Pop the stack 
                        //(appending to postfix expression) until an operator of lower precedence is on top of the stack or the stack is empty
                        char i;
                        while(getOrder(c) >= getOrder(i =(stack.pop()).getChar()) || stack.getSize() == 0){
                            Node l = new Node(i);
                            stack.push(l);
                            String s = "" + stack.pop().getChar();
                            postFix += s;
                            
                            Node n = new Node(c);
                            stack.push(n);
                            
                           
                        }
                    }else if(c == '('){ //If left parenthesis is encountered, push it onto the stack.
                        Node n = new Node(c);
                        stack.push(n);
                    }else{ //When operand is encountered append it to the postfix expression
                        String s = "" + c;
                        postFix += s;
                    }
                }
                System.out.println(postFix);
                list.add(postFix);
            }
            input.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return list;
    }
    
    //Write output to file
    public static void outputFile(String outputFileName, ArrayList<String> list){
        try{
            
            PrintWriter out = new PrintWriter(outputFileName);
            for(int i = 0; i < list.size();i++){
                out.println(list.get(i));
                System.out.println(list.get(i));
            }
            out.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
        
      public static int getOrder(char c){
        switch(c){
            case '+' :  return 2;
            case '-'  : return 2;
            case '*' : return 3;
            case '/' : return 3;
            case '^' : return 4;
            default : return 1;
        }
    }

}
    
  

