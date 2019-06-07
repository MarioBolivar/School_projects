package TieFighter;

/**
 *
 * @author Mario Bolivar
 */

public class PilotInfo {
    boolean validRoute;
    int routeLength;
    String name;
    
    //Overloaded ctr
    public PilotInfo(String name, boolean validRoute, int routeLength){
        this.name = name;
        this.validRoute = validRoute;
        
        
        if(validRoute)
            this.routeLength = routeLength; //If valid route, assign passed in value
        else
            this.routeLength = -1; //If route not valid, assign a default value of -1
    }
    
}
