package homework_4_Pt1;

/**
 *
 * @author Mario Bolivar - Mjb160330
 *
 */

//This program converts a binary string into a decimal number and displays the result
//if the string is not a binary number, a custom exception containing the error is displayed
public class Homework_4_Pt1 {

    public static void main(String[] args) throws BinaryFormatException  {
        
            
            //String 100a1 is not a string.
            try{
                System.out.println("100a1 to decimal: " + bin2Dec("100a1"));
            }
            catch(BinaryFormatException ex){
                System.out.println(ex);
            }
            
            //9
            try{
                System.out.println("1001 to decimal: " + bin2Dec("1001"));
            }
            catch(BinaryFormatException ex){
                System.out.println(ex);
            }
            
            //15
            try{
                System.out.println("1111 to decimal: " + bin2Dec("1111"));
            }
            catch(BinaryFormatException ex){
                System.out.println(ex);
            }

          
  
    
    }
    
    public static int bin2Dec(String string) throws BinaryFormatException{
        
        
        int x;
        
        try{
            x = Integer.parseInt(string,2);
        }
        catch(Exception ex){
            throw new BinaryFormatException(string);
        }
        
        return x;
    }

}
