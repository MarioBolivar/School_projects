/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework5;

/**
 *
 * @author mario
 */
public class Test {
    public static void main(String[] args){
         Cyberman one = new Cyberman("Bob");
    }
    
    
}

public class Robot{

public Robot() { System.out.println("Tom Servo");  }

public Robot(String name)  { System.out.println(name);  }

}


public class Cyborg extends Robot{

public Cyborg() {  System.out.println("Robocop");  }

public Cyborg(String name)  { System.out.println(name);  }

}


public class Cyberman extends Cyborg{

public Cyberman()  { super(); System.out.println("Cyberman");  }

public Cyberman(String name)  { super(name);  System.out.println(name);  }

}