
package test;

/**
 *
 * @author Mario Bolivar - Mjb160330
 *
 */
public class Test {

    public static void main(String[] args) {
      
        
        String [] operators = {"\\+","\\-","\\*","\\/"};
        String expression = "1+2*9-23";
        String str = "asd";
        for(String op : operators){
            
            expression = expression.replaceAll(op," " + op + " ");
            
        }
        
        
        System.out.println(expression);
        
        String [] s = expression.split(" ");

        for(int i = s.length-1;i >= 0; i--){
            System.out.print(s[i]);
        }
        System.out.println();
            
        
        
        
    }

}
