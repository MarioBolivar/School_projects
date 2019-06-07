/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.pkg1.review;

/**
 *
 * @author mario
 */
public class HexFormatException extends Exception{
    
    
    
    public HexFormatException(String hex2Dec) {
        super("String is not a valid hex number: " + hex2Dec);
    }
    
    
    
}
