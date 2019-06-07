package TieFighter;
/**
 *
 * @author Mario Bolivar - mjb160330
 * 
 *  
 */

public class Payload implements Comparable<Payload> {
    String pilotName;
    double patrolArea;
    boolean flag;
   
    //Constructor
    Payload(String pilotName){
        this.pilotName = pilotName;
        patrolArea = 0;
        flag = false;
    }
    
    //Accessors
    public String getPilotName(){ return pilotName; }
    
    public double getPatrolArea(){ return patrolArea; }
    
    public boolean getComparison() { return flag; }
    
    
    //Mutators
    public void setPatrolArea(double area){
        patrolArea = area;
    }
     
    @Override
    public int compareTo(Payload o){
        
        //If left is less than for both -3
        if(patrolArea < o.patrolArea && pilotName.compareTo(o.pilotName) < 0 ){
            return -3;
        }
        
        //If left name is less than right -2
        else if(pilotName.compareTo(o.pilotName) < 0){
            return -2;
        }
        
        //If left area is less than the right -1
        else if(patrolArea < o.patrolArea){
            return -1;
        }
        
        //If both are equal 0 
        else if(patrolArea == o.patrolArea && pilotName.equals(o.pilotName)){
            return 0;
        }
        
        //If left area is greater than right 1
        else if(patrolArea > o.patrolArea){
            return 1;
        }
        
        //If left name is greater than right 2
        else if((pilotName.compareTo(o.pilotName)) > 0){
            return 2;
        }
        
        //If left area and name is greater than right
        else{
            return 3;
        }
    }
}
