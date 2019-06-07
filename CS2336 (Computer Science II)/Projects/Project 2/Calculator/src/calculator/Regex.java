package calculator;

import java.util.regex.*;

/**
 *
 * @author Mario Bolivar - mjb160330
 */

//Regular Expression class to make interaction with main class easier/smoother
public class Regex {
    
    //Regex variable
    String expression;
    Pattern checkRegex;
    Matcher regexMatcher; 
    boolean matches;
    
    //Default Constructor with regular expression hardcoded
    Regex(){
        this.expression = "((?<lfull>\\-?\\d+(\\.\\d+)?\\+\\-?\\d+(\\.\\d+)?i)|"
                + "(?<ldig>\\-?\\d+(\\.\\d+)?)|(?<limag>\\-?\\d+(\\.\\d+)?i))\\s(?<op>\\+|\\-|\\*|"
                + "\\/|\\<|\\>|\\=|\\/\\=)\\s((?<rfull>\\-?\\d+(\\.\\d+)?\\+\\-?\\d+(\\.\\d+)?i)|"
                + "(?<rdig>\\-?\\d+(\\.\\d+)?)|(?<rimag>\\-?\\d+(\\.\\d+)?i))$";      
        
         //Regex pattern used to validate line from file - it is hardcoded in.
        checkRegex = Pattern.compile(this.expression);
        
        matches = false;
        
    }
    
    //Checks to see if string matches the regex pattern
    public boolean matches(String expression){
        
         //Checking if Regex pattern matches with string
        regexMatcher = checkRegex.matcher(expression);
        
        //Return result
        if(regexMatcher.matches()){
            matches = true;
            return matches;
        }
        else
            return false;
    }

    //Returns the right operator from the expression
    public String[] getInfo(){
        
            //String array to contain the expression variables
            //Element [0] == operation
            //Element [1] == left operand
            //Element [2] == left operand part two (if in a+bi) form -> space for b
            //Element [3] == right operand
            //Element [4] == right operand part two (if in a+bi) form -> space for b
            //Element [5] == signal flag for left case 
            //Element [6] == signal flag for right case (a+bi)
            String [] info = new String [7];
        
        //If string matches, return the operation symbol from the string
        if(matches){
            
            //Get operation
            info[0] = this.regexMatcher.group("op");
            
             int lflag = this.getLeftCase(), rflag = this.getRightCase();
             
             //If left operator is full (a+ai)
             if(lflag == 0){
                
                 info[5] = "full";
                 //index variable for less of a mess
                 int index;
                 
                 //Check to see where the +|- is to extract variables
                 //If + does not exist, then it must be -
                 if (regexMatcher.group("lfull").lastIndexOf("+") == -1)
                     index = regexMatcher.group("lfull").lastIndexOf("-");
                 //If - does not exist then it must be +
                 else
                     index = regexMatcher.group("lfull").lastIndexOf("+");
                 
                 //Filling in the array
                 info[1] = regexMatcher.group("lfull").substring(0,index);
                 info[2] = regexMatcher.group("lfull").substring(index+1,regexMatcher.group("lfull").length()-1);
             }
             //If left operator is real (a)
             else if(lflag == 1){
                 info[5] = "dig";
                 info[1] = regexMatcher.group("ldig");
             }
             //If left operator is imaginary (ai)
             else if(lflag == 2){
                 info[5] = "imag";
                 info[2] = regexMatcher.group("limag").substring(0, (regexMatcher.group("limag").length() - 1)); //discard the 'i'
             }
             
             //If right operator is full (a+ai)
             if(rflag == 0){
                 
                 info[6] = "full";
                 
                 //index variable for less of a mess
                 int index;
                 
                 //Check to see where the +|- is to extract variables
                 //If + does not exist, then it must be -
                 if (regexMatcher.group("rfull").lastIndexOf("+") == -1)
                     index = regexMatcher.group("rfull").lastIndexOf("-");
                 //If - does not exist then it must be +
                 else
                     index = regexMatcher.group("rfull").lastIndexOf("+");
                 
                 //Filling in the array
                 info[3] = regexMatcher.group("rfull").substring(0,index);
                 info[4] = regexMatcher.group("rfull").substring(index+1,regexMatcher.group("rfull").length()-1);
             }
             //If right operator is real (a)
             else if(rflag == 1){
                 info[6] = "dig";
                 info[3] = regexMatcher.group("rdig");
             }
             //If left operator is imaginary (ai)
             else if(rflag == 2){
                 info[6] = "imag";
                 info[4] = regexMatcher.group("rimag").substring(0,(regexMatcher.group("rimag").length() - 1)); //discard the 'i'
             }
        }
        //Return null if no match was made *Shouldn't happen*
        else
            return null;
        
        
        return info;
        
        
    }
    
    //Method to return a signal int that explains what type of operator is on the left hand side
    private int getLeftCase(){
        
        //If left operator is a+ai format return 0
        if(regexMatcher.group("lfull") != null)
            return 0;
        //If left operator is (a) format return 1
        else if(regexMatcher.group("ldig") != null)
            return 1;
        //If left operator is (ai) format return 2
        else
            return 2;
    }

    //Method to return a signal int that explains what type of operator is on the right hand side
    private int getRightCase(){
        
        //If right operator is a+ai format return 0
        if(regexMatcher.group("rfull") != null)
            return 0;
        //If right operator is (a) format return 1
        else if(regexMatcher.group("rdig") != null)
            return 1;
        //If right operator is (ai) format return 2
        else
            return 2;
    }
    
}
