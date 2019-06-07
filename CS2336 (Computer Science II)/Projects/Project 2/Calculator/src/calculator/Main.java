package calculator;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author Mario Bolivar - Mjb160330
 *
 */

public class Main {

    public static void main(String[] args) {
        
        inputFileStream("expressions.txt","results.txt");

        
    }
    
    //Method to open the connection with the input file and begin inputting information
    public static void inputFileStream(String inputFileName,String outputFileName){
        
        //File variable that will be used to check if the file exists
        //and if it can be read from
        File inputFile = new File(inputFileName);
        
        //Checks if file exists
        if(inputFile.exists()){
            
            //If file cannot be read from, display error and terminate program.
            if(!inputFile.canRead()){
                System.out.println(">File \"" + inputFileName + "\" cannot be read from.\n");
                System.out.println(">Please fix this error and restart the program.\n");
                System.exit(-1);
                
            //If file exists and can be read from, continue
            }else{
                
                //Scanner object 
                Scanner input = null;
                
                
                try{
                    //Creating Scanner object for input
                    input = new Scanner(inputFile);
                
                }catch(Exception ex){
                     System.out.println(">Error: Program could not open \"" + inputFileName + "\"\n");
                     System.exit(-1);
                }
                
                //If file is empty, display error and terminate program
                if(!input.hasNextLine()){
                    System.out.println(">File \"" + inputFileName + "\" cannot be empty.\n"
                            + ">Please fill file \"" + inputFileName + "\" with data and restart the program.\n");
                    System.exit(-1);
                }
                
                getFileContents(input,outputFileName);
            }
            
        //If file does not exist, display error message and terminate program
        }else{
            System.out.println(">File \"" + inputFileName + "\" does not exist.\n");
            System.out.println(">Please add the file to the directory and restart the program.\n");
            System.exit(-1);
        }
        
        
        
    }
    
    //Method to get the file contents 
    public static void getFileContents(Scanner input,String outputFileName){
        
                
        //Creating output file
        File outputFile = new File(outputFileName);
        
        //If file exists, delete the file to create it again
        if(outputFile.exists()){
            System.out.println(">\"" + outputFileName + "\" already exists.\n");
            try{
                System.out.println(">Program will now try to delete the file and recreate it..\n");
                outputFile.delete();
                System.out.println(">Program successfully recreated the file \"" + outputFileName + "\"\n");
            }catch(Exception ex){
                System.out.println(">Program could not delete the file \"" + outputFileName + "\"\n"
                        + "\n>Please delete the file \"" + outputFileName + "\"and restart the program.\n");
                System.exit(-1);
            }
        }
        
        PrintWriter output = null;
        
        //Try to create the printwriter connection to the output file
        try{
            output = new PrintWriter(outputFile);
        }catch(Exception ex){
            System.out.println(">Error: Program could not create \"" + outputFileName + "\"\n");
            System.exit(-1);
        }
        
        
        //The currect expresison being examined
        String currentExpression; 
        
        //Regex object from regex custom class to facilitate expression handling
        Regex regexObject = new Regex();

        //While not at the end of file
        while(input.hasNextLine()){
            
            //Get an expression
            currentExpression = input.nextLine();
            
            //If the expression is valid, continue
            if(regexObject.matches(currentExpression)){
                String [] expression = regexObject.getInfo();
                
                //String array to contain the expression variables
                //Element [0] == operation
                //Element [1] == left operand
                //Element [2] == left operand part two (if in a+bi) form -> space for b
                //Element [3] == right operand
                //Element [4] == right operand part two (if in a+bi) form -> space for b
                //Element [5] == signal flag for left case 
                //Element [6] == signal flag for right case (a+bi)
                
                //If both the left and right hand operands are in (a+ai) form 
                if(expression[5] == "full" && expression[6] == "full"){
                    
                    //Filling in the objects
                    ComplexNumberClass leftComplexNum = new ComplexNumberClass(Double.parseDouble(expression[1]),Double.parseDouble(expression[2]));
                    ComplexNumberClass rightComplexNum = new ComplexNumberClass(Double.parseDouble(expression[3]),Double.parseDouble(expression[4]));
                    
                    //Calling the method to perform the calculation
                    performOperation(leftComplexNum, rightComplexNum,currentExpression, expression[0], output);
                }
                //If left hand operand is in (a+ai) form and right hand operand is a real number
                else if(expression[5] == "full" && expression[6] == "dig"){
                     
                    //Filling in objects
                    ComplexNumberClass leftComplexNum = new ComplexNumberClass(Double.parseDouble(expression[1]),Double.parseDouble(expression[2]));
                    NumberClass rightRealNum = new NumberClass(Double.parseDouble(expression[3]));
                     
                     //Calling the method to perform the calculation
                    performOperation(leftComplexNum, rightRealNum,currentExpression, expression[0], output);
                }
                //If left hand operand is in (a+ai) form and right hand operand is an imaginary number
                else if(expression[5] == "full" && expression[6] == "imag"){
                    
                    //Filling in objects
                    ComplexNumberClass leftComplexNum = new ComplexNumberClass(Double.parseDouble(expression[1]),Double.parseDouble(expression[2]));
                    ComplexNumberClass rightComplexNum = new ComplexNumberClass(0,Double.parseDouble(expression[4]));
                            
                     //Calling the method to perform the calculation
                    performOperation(leftComplexNum, rightComplexNum,currentExpression, expression[0], output);
                    
                }
                //If left hand operand is a real number and right hand operand is in (a+ai) form
                else if(expression[5] == "dig" && expression[6] == "full"){
                    
                    //Filling in objects
                    NumberClass leftRealNum = new NumberClass(Double.parseDouble(expression[1]));
                    ComplexNumberClass rightComplexNum = new ComplexNumberClass(Double.parseDouble(expression[3]),Double.parseDouble(expression[4]));
                    
                    //Calling the method to perform the calculation
                    performOperation(leftRealNum, rightComplexNum,currentExpression, expression[0], output);
                    
                }
                //If both left and right hand operands are real numbers
                else if(expression[5] == "dig" && expression[6] == "dig"){
                    
                    //Filling in objects
                    NumberClass leftRealNum = new NumberClass(Double.parseDouble(expression[1]));
                    NumberClass rightRealNum = new NumberClass(Double.parseDouble(expression[3]));
                    
                     //Calling the method to perform the calculation
                    performOperation(leftRealNum, rightRealNum,currentExpression, expression[0], output);
                    
                }
                //If left hand operand is a real number and right hand operand is an imaginary number
                else if(expression[5] == "dig" && expression[6] == "imag"){
                    
                    //Filling in objects
                    NumberClass leftRealNum = new NumberClass(Double.parseDouble(expression[1]));
                    ComplexNumberClass rightComplexNum = new ComplexNumberClass(0, Double.parseDouble(expression[4]));
                    
                    //Calling the method to perform the calculation
                    performOperation(leftRealNum, rightComplexNum,currentExpression, expression[0], output);
                    
                }
                //If left hand operand is an imaginary number and right hand operand is in (a+ai) form
                else if(expression[5] == "imag" && expression[6] == "full"){
                    
                    //Filling in objects
                    ComplexNumberClass leftComplexNum = new ComplexNumberClass(0, Double.parseDouble(expression[2]));
                    ComplexNumberClass rightComplexNum = new ComplexNumberClass(Double.parseDouble(expression[3]),Double.parseDouble(expression[4]));
                    
                     //Calling the method to perform the calculation
                    performOperation(leftComplexNum, rightComplexNum,currentExpression, expression[0], output);
                    
                }
                //If left hand operand is an imaginary number and right hand operator is a real number
                else if(expression[5] == "imag" && expression[6] == "dig"){
                    
                    //Filling in objects
                    ComplexNumberClass leftComplexNum = new ComplexNumberClass(0, Double.parseDouble(expression[2]));
                    NumberClass rightRealNum = new NumberClass(Double.parseDouble(expression[3]));
                    
                     //Calling the method to perform the calculation
                    performOperation(leftComplexNum, rightRealNum,currentExpression, expression[0], output);
                    
                }
                //If both operands are imaginary numbers
                else if(expression[5] == "imag" && expression[6] == "imag"){
                    
                    //Filling in objects
                    ComplexNumberClass leftComplexNum = new ComplexNumberClass(0, Double.parseDouble(expression[2]));
                    ComplexNumberClass rightComplexNum = new ComplexNumberClass(0,Double.parseDouble(expression[4]));
                    
                     //Calling the method to perform the calculation
                    performOperation(leftComplexNum, rightComplexNum,currentExpression, expression[0], output);
                    
                }
            }
        }
        
        //Close file input stream
        input.close();
        output.close();
    }
    
    //Method to perform operation and return the result
    public static void performOperation(Object leftOperandObj, Object rightOperandObj, String fullOperation, String operation, PrintWriter output){
        
        //If both objects are complex 
        if(leftOperandObj instanceof ComplexNumberClass && rightOperandObj instanceof ComplexNumberClass){

            //If adding
            if(operation.equals("+")){

                //Calculating results
               double imaginaryNumResult = ((ComplexNumberClass)leftOperandObj).getImaginaryNumber() + ((ComplexNumberClass)rightOperandObj).getImaginaryNumber();
               double realNumResult = ((ComplexNumberClass)leftOperandObj).getNumber() + ((ComplexNumberClass)rightOperandObj).getNumber();

               //Calling method to output the calculated results
               outputResults(fullOperation, operation, realNumResult, imaginaryNumResult,false, output);
            }
            //If subtracting
            else if(operation.equals("-")){

               //Calculating results
               double imaginaryNumResult = ((ComplexNumberClass)leftOperandObj).getImaginaryNumber() - ((ComplexNumberClass)rightOperandObj).getImaginaryNumber();
               double realNumResult = ((ComplexNumberClass)leftOperandObj).getNumber() - ((ComplexNumberClass)rightOperandObj).getNumber();

               //Calling method to output the calculated results
               outputResults(fullOperation, operation, realNumResult, imaginaryNumResult,false, output);
            }
            //if multiplying - todo
            else if(operation.equals("*")){

                //Calculating results
               double imaginaryNumResult = ((ComplexNumberClass)leftOperandObj).getImaginaryNumber() * ((ComplexNumberClass)rightOperandObj).getImaginaryNumber();
               double realNumResult = ((ComplexNumberClass)leftOperandObj).getNumber() * ((ComplexNumberClass)rightOperandObj).getNumber();

               //Calling method to output the calculated results
               outputResults(fullOperation, operation, realNumResult, imaginaryNumResult,false, output);
            }
            //If dividing - todo
            else if(operation.equals("/")){

                double realNumResult;
                    
                
                
                //Cannot divide by zero
                if(((ComplexNumberClass)rightOperandObj).getImaginaryNumber() == 0 || ((ComplexNumberClass)rightOperandObj).getNumber() == 0){
                    realNumResult = 0;
                }
                else
                    realNumResult = ((ComplexNumberClass)leftOperandObj).getNumber() / ((ComplexNumberClass)rightOperandObj).getNumber();

                //Calculating results
               double imaginaryNumResult = ((ComplexNumberClass)leftOperandObj).getImaginaryNumber() / ((ComplexNumberClass)rightOperandObj).getImaginaryNumber();


               //Calling method to output the calculated results
               outputResults(fullOperation, operation, realNumResult, imaginaryNumResult,false, output);
            }
            //If less than
            else if(operation.equals("<")){

                boolean lessThan = false;

                //If less than
                if(Math.abs((((ComplexNumberClass)leftOperandObj).getNumber() + ((ComplexNumberClass)leftOperandObj).getImaginaryNumber())) < Math.abs((((ComplexNumberClass)rightOperandObj).getNumber() + ((ComplexNumberClass)rightOperandObj).getImaginaryNumber()))){
                    lessThan = true;
                }

                //Calling method to output the calculated results
                outputResults(fullOperation, operation,0,0,lessThan, output);
            }

            //If greater than
            else if(operation.equals(">")){

                 boolean greaterThan = false;

                //If less than
                if(Math.abs((((ComplexNumberClass)leftOperandObj).getNumber() + ((ComplexNumberClass)leftOperandObj).getImaginaryNumber())) > Math.abs((((ComplexNumberClass)rightOperandObj).getNumber() + ((ComplexNumberClass)rightOperandObj).getImaginaryNumber()))){
                    greaterThan = true;
                }



               //Calling method to output the calculated results
               outputResults(fullOperation, operation,0,0,greaterThan, output);
            }

            //If equals
            else if(operation.equals("=")){
                boolean equals = false;

                //Checks if they are equal
                if(((ComplexNumberClass)leftOperandObj).equals(((ComplexNumberClass)rightOperandObj).getImaginaryNumber()) && ((ComplexNumberClass)leftOperandObj).equals(((ComplexNumberClass)rightOperandObj).getNumber())){
                    equals = true;
                }

                //Calling method to output the calculated results
                outputResults(fullOperation, operation, 0, 0, equals, output);
            }

            //If not equals
            else if(operation.equals("/=")){

                boolean notEquals = false;
                 //Checks if they are equal
                if(!(((ComplexNumberClass)leftOperandObj).equals(((ComplexNumberClass)rightOperandObj).getImaginaryNumber()) && ((ComplexNumberClass)leftOperandObj).equals(((ComplexNumberClass)rightOperandObj).getNumber()))){
                    notEquals = true;
                }

                //Calling method to output the calculated results
                outputResults(fullOperation, operation, 0, 0, notEquals, output);

            }

        }
        //If leftOperandObj is complex and the rightOperandObj is a realNumber 
        else if(leftOperandObj instanceof ComplexNumberClass && rightOperandObj instanceof NumberClass){

            //If adding
            if(operation.equals("+")){

                //Calculating results
               double imaginaryNumResult = ((ComplexNumberClass)leftOperandObj).getImaginaryNumber();
               double realNumResult = ((ComplexNumberClass)leftOperandObj).getNumber() + ((NumberClass)rightOperandObj).getNumber();

               //Calling method to output the calculated results
               outputResults(fullOperation, operation, realNumResult, imaginaryNumResult,false, output);
            }
            //If subtracting
            else if(operation.equals("-")){

               //Calculating results
               double imaginaryNumResult = ((ComplexNumberClass)leftOperandObj).getImaginaryNumber();
               double realNumResult = ((ComplexNumberClass)leftOperandObj).getNumber() - ((NumberClass)rightOperandObj).getNumber();

               //Calling method to output the calculated results
               outputResults(fullOperation, operation, realNumResult, imaginaryNumResult,false, output);
            }
            //if multiplying - todo
            else if(operation.equals("*")){

                //Calculating results
               double imaginaryNumResult = ((ComplexNumberClass)leftOperandObj).getImaginaryNumber() * ((NumberClass)rightOperandObj).getNumber(); 
               double realNumResult = ((ComplexNumberClass)leftOperandObj).getNumber() * ((NumberClass)rightOperandObj).getNumber();

               //Calling method to output the calculated results
               outputResults(fullOperation, operation, realNumResult, imaginaryNumResult,false, output);
            }
            //If dividing - todo
            else if(operation.equals("/")){

                double realNumResult;

                //Cannot divide by zero
                if(((ComplexNumberClass)leftOperandObj).getImaginaryNumber() == 0 || ((NumberClass)rightOperandObj).getNumber() == 0){
                    realNumResult = 0;
                }
                else
                    realNumResult = ((ComplexNumberClass)leftOperandObj).getNumber() / ((NumberClass)rightOperandObj).getNumber();

                //Calculating results
               double imaginaryNumResult = ((ComplexNumberClass)leftOperandObj).getImaginaryNumber() / ((NumberClass)rightOperandObj).getNumber();


               //Calling method to output the calculated results
               outputResults(fullOperation, operation, realNumResult, imaginaryNumResult,false, output);
            }
            //If less than
            else if(operation.equals("<")){

                boolean lessThan = false;

                //If less than
                if(Math.abs((((ComplexNumberClass)leftOperandObj).getNumber() + ((ComplexNumberClass)leftOperandObj).getImaginaryNumber())) < Math.abs(((NumberClass)rightOperandObj).getNumber())){
                    lessThan = true;
                }

                //Calling method to output the calculated results
                outputResults(fullOperation, operation,0,0,lessThan, output);
            }

            //If greater than
            else if(operation.equals(">")){

                 boolean greaterThan = false;

                //If less than
                if(Math.abs((((ComplexNumberClass)leftOperandObj).getNumber() + ((ComplexNumberClass)leftOperandObj).getImaginaryNumber())) > Math.abs((((NumberClass)rightOperandObj).getNumber()))){
                    greaterThan = true;
                }


 
              //Calling method to output the calculated results
               outputResults(fullOperation, operation,0,0,greaterThan, output);
            }

            //If equals
            else if(operation.equals("=")){
                
                //They will never be equal, (a+ai) != (a)
                //Calling method to output the calculated results
                outputResults(fullOperation, operation, 0, 0, false, output);
            }

            //If not equals
            else if(operation.equals("/=")){
                
                //Will always not be equal
                //Calling method to output the calculated results
                outputResults(fullOperation, operation, 0, 0, true, output);

            }

        }
        //If leftOperandObj is a real number and the rightOperandObj is a Complex number
        else if(leftOperandObj instanceof NumberClass && rightOperandObj instanceof ComplexNumberClass){

            //If adding
            if(operation.equals("+")){

                //Calculating results
               double imaginaryNumResult = ((ComplexNumberClass)rightOperandObj).getImaginaryNumber();
               double realNumResult = ((NumberClass)leftOperandObj).getNumber() + ((ComplexNumberClass)rightOperandObj).getNumber();

               //Calling method to output the calculated results
               outputResults(fullOperation, operation, realNumResult, imaginaryNumResult,false, output);
            }
            //If subtracting
            else if(operation.equals("-")){

               //Calculating results
               double imaginaryNumResult = ((ComplexNumberClass)rightOperandObj).getImaginaryNumber();
               double realNumResult = ((NumberClass)leftOperandObj).getNumber() - ((ComplexNumberClass)rightOperandObj).getNumber();

               //Calling method to output the calculated results
               outputResults(fullOperation, operation, realNumResult, imaginaryNumResult,false, output);
            }
            //if multiplying - todo
            else if(operation.equals("*")){

                //Calculating results
               double imaginaryNumResult = ((NumberClass)leftOperandObj).getNumber() * ((ComplexNumberClass)rightOperandObj).getImaginaryNumber();
               double realNumResult = ((NumberClass)leftOperandObj).getNumber() * ((ComplexNumberClass)rightOperandObj).getNumber();

               //Calling method to output the calculated results
               outputResults(fullOperation, operation, realNumResult, imaginaryNumResult,false, output);
            }
            //If dividing - todo
            else if(operation.equals("/")){

                double realNumResult;

                //Cannot divide by zero
                if(((ComplexNumberClass)rightOperandObj).getImaginaryNumber() == 0 || ((ComplexNumberClass)rightOperandObj).getNumber() == 0){
                    realNumResult = 0;
                }
                else
                    realNumResult = ((NumberClass)leftOperandObj).getNumber() / ((ComplexNumberClass)rightOperandObj).getNumber();

                //Calculating results
               double imaginaryNumResult = 0;

               //Calling method to output the calculated results
               outputResults(fullOperation, operation, realNumResult, imaginaryNumResult,false, output);
            }
            //If less than
            else if(operation.equals("<")){

                boolean lessThan = false;

                //If less than
                if((Math.abs((((NumberClass)leftOperandObj).getNumber()))) < (Math.abs(((ComplexNumberClass)rightOperandObj).getNumber() + ((ComplexNumberClass)rightOperandObj).getImaginaryNumber()))){
                    lessThan = true;
                }

                //Calling method to output the calculated results
                outputResults(fullOperation, operation,0,0,lessThan, output);
            }

            //If greater than
            else if(operation.equals(">")){

                 boolean greaterThan = false;

                //If less than
                if(Math.abs((((NumberClass)leftOperandObj).getNumber())) > Math.abs((((ComplexNumberClass)rightOperandObj).getNumber() + ((ComplexNumberClass)rightOperandObj).getImaginaryNumber()))){
                    greaterThan = true;
                }



               //Calling method to output the calculated results
               outputResults(fullOperation, operation,0,0,greaterThan, output);
            }

            //If equals
            else if(operation.equals("=")){
                //Never true
                //Calling method to output the calculated results
                outputResults(fullOperation, operation, 0, 0, false, output);
            }

            //If not equals
            else if(operation.equals("/=")){
                
                //Always true
                //Calling method to output the calculated results
                outputResults(fullOperation, operation, 0, 0, true, output);

            }
        }
        //If both objects are real numbers
        else if(leftOperandObj instanceof NumberClass && rightOperandObj instanceof NumberClass){

            //If adding
            if(operation.equals("+")){

                //Calculating results
               double realNumResult = ((NumberClass)leftOperandObj).getNumber() + ((NumberClass)rightOperandObj).getNumber();

               //Calling method to output the calculated results
               outputResults(fullOperation, operation, realNumResult, 0,false, output);
            }
            //If subtracting
            else if(operation.equals("-")){

               //Calculating results
               double realNumResult = ((NumberClass)leftOperandObj).getNumber() - ((NumberClass)rightOperandObj).getNumber();

               //Calling method to output the calculated results
               outputResults(fullOperation, operation, realNumResult, 0,false, output);
            }
            //if multiplying 
            else if(operation.equals("*")){

                //Calculating results
               double realNumResult = ((NumberClass)leftOperandObj).getNumber() * ((NumberClass)rightOperandObj).getNumber();

               //Calling method to output the calculated results
               outputResults(fullOperation, operation, realNumResult, 0,false, output);
            }
            //If dividing 
            else if(operation.equals("/")){

                double realNumResult;
                    
                
                
                //Cannot divide by zero
                if(((NumberClass)leftOperandObj).getNumber() == 0 || ((NumberClass)rightOperandObj).getNumber() == 0){
                    realNumResult = 0;
                }
                else
                    realNumResult = ((NumberClass)leftOperandObj).getNumber() / ((NumberClass)rightOperandObj).getNumber();


               //Calling method to output the calculated results
               outputResults(fullOperation, operation, realNumResult, 0,false, output);
            }
            //If less than
            else if(operation.equals("<")){

                boolean lessThan = false;

                //If less than
                if((((NumberClass)leftOperandObj).getNumber()) < (((NumberClass)rightOperandObj).getNumber())){
                    lessThan = true;
                }

                //Calling method to output the calculated results
                outputResults(fullOperation, operation,0,0,lessThan, output);
            }

            //If greater than
            else if(operation.equals(">")){

                 boolean greaterThan = false;

                //If less than
                if((((NumberClass)leftOperandObj).getNumber()) > (((NumberClass)rightOperandObj).getNumber())){
                    greaterThan = true;
                }



               //Calling method to output the calculated results
               outputResults(fullOperation, operation,0,0,greaterThan, output);
            }

            //If equals
            else if(operation.equals("=")){
                boolean equals = false;

                //Checks if they are equal
                if(((NumberClass)leftOperandObj).equals(((NumberClass)rightOperandObj).getNumber())){
                    equals = true;
                }

                //Calling method to output the calculated results
                outputResults(fullOperation, operation, 0, 0, equals, output);
            }

            //If not equals
            else if(operation.equals("/=")){

                boolean notEquals = false;
                 //Checks if they are equal
                if(!((NumberClass)leftOperandObj).equals(((NumberClass)rightOperandObj).getNumber())){
                    notEquals = true;
                }

                //Calling method to output the calculated results
                outputResults(fullOperation, operation, 0, 0, notEquals, output);

            }

        }
        
    }
    
    //Method to output results
    public static void outputResults(String fullOperation,String operation, double realNumResult, double imaginaryNumResult, boolean boolResult, PrintWriter output){
        
        if(operation.equals("<") || operation.equals(">") || operation.equals("=")|| operation.equals("/=")){
            
            output.printf("%-15s%-10s", fullOperation, boolResult);
            output.println();
        }else{
            
            if(realNumResult == 0 && imaginaryNumResult == 0){
                output.printf("%-15s%.2f", fullOperation, 0.0);
                output.println();
            }
            
            else if(realNumResult == 0 && imaginaryNumResult != 0 ){
                if(imaginaryNumResult > 0){
                    output.printf("%-15s" + "+" + "%.2f" + "i", fullOperation, imaginaryNumResult);
                    output.println();                    
                }
                else{
                    output.printf("%-15s%.2f" + "i", fullOperation, imaginaryNumResult);
                    output.println();
                }
                
            }
            
            else if(realNumResult != 0 && imaginaryNumResult == 0){
                output.printf("%-15s%.2f", fullOperation, realNumResult);
                output.println();
            }
            
            else if(realNumResult != 0 && imaginaryNumResult != 0){
                    
                if(imaginaryNumResult > 0){
                    output.printf("%-15s%.2f+%.2f" + "i", fullOperation, realNumResult, imaginaryNumResult);
                    output.println();
                }
                else{
                    output.printf("%-15s%.2f%.2f" + "i", fullOperation, realNumResult, imaginaryNumResult);
                    output.println();

                }


            }
            
        }
            
        
    }
}
