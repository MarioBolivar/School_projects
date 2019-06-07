package homework_4_Pt1;

/**
 *
 * @author Mario Bolivar - Mjb160330
 */

//Custom Exception class to display string error
public class BinaryFormatException extends Exception {
    
    //Constructor
    public BinaryFormatException(String string) {
        super("String \"" + string + "\" is not a binary string.");
        
    }
    
}
