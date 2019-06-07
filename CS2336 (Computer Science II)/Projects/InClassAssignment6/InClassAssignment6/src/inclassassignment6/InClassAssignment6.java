package inclassassignment6;

/**
 *
 * @author Mario Bolivar - Mjb160330
 * @author Zhen Zhang - Zxz152330
 * 
 */

public class InClassAssignment6 {

    public static void main(String[] args) {
        //Creating a default graph object
        Graph graph1 = new Graph();
        
        //Filling in the graph from a passed in text file name
        graph1.createGraph("graph1.txt");
        
        System.out.println("Graph1.txt: \n");
        
        System.out.print("   1 2 3 4 5 6 7 8 9 10\n");
        
        
        //Displaying graph1
        for(int i = 0; i < graph1.maxSize; i++){
            
            if(i == 9)
                System.out.print(i+1 + " ");            
            else
                System.out.print(i+1 + "  ");
            
            
            for(int j = 0; j < graph1.maxSize; j++){
                System.out.print(graph1.graphMatrix[i][j] + " " );
            }
            System.out.println();
        
        }

            
        System.out.println("\ngraph1.txt is bipartite: " + graph1.isBipartite());
            
        //Creating a default graph object
        Graph graph2 = new Graph();
        
        //Filling in the graph from a passed in text file name
        graph2.createGraph("graph2.txt");
        
        System.out.println("\n\nGraph2.txt: \n");
        
        System.out.print("   1 2 3 4 5 6 7 8 9 10\n");
        
        
        //Displaying graph2
        for(int i = 0; i < graph2.maxSize; i++){
            
            if(i == 9)
                System.out.print(i+1 + " ");            
            else
                System.out.print(i+1 + "  ");
            
            
            for(int j = 0; j < graph2.maxSize; j++){
                System.out.print(graph2.graphMatrix[i][j] + " " );
            }
            System.out.println();
        
        }

            System.out.println("\ngraph2.txt is bipartite: " + graph2.isBipartite());
        
    }

}
