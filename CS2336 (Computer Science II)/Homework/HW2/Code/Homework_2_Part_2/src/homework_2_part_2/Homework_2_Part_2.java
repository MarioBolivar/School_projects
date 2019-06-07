package homework_2_part_2;
import java.util.Scanner;
import java.io.File;
/**
 *
 * @author Mario Bolivar - mjb160330
 * 
 * This program imports faculty salary information from a text file in a web-site  and displays
 * information based off of the data imported.
 */
public class Homework_2_Part_2 {
    public static void main(String[] args) throws Exception{
       
       //Variable information 
       String fileUrl = "http://cs.armstrong.edu/liang/data/Salary.txt";
       double assistantProf = 0, associateProf = 0, fullProf = 0, allFaculty = 0;
       int assistantCnt = 0, associateCnt = 0, fullCnt = 0;
       double assistantSum = 0, associateSum = 0, fullSum = 0, allSum = 0;
       double currentSalary = 0;
       String info;
       
       //Try to open connection with the text file
        try{
            java.net.URL url = new java.net.URL(fileUrl);
            Scanner input = new Scanner(url.openStream());
            
            //Loop through file data
            while(input.hasNext()){
                
                //We don't care for names in this program
                input.next();
                input.next();
                
                //import professor rank
                info = input.next(); 
                
                //import salary information
                currentSalary = input.nextDouble();
                
                //if statements to check professor type and sort data respectively
                if(info.equals("assistant")){
                    
                    assistantCnt++;
                    assistantSum += currentSalary;
                    allSum += currentSalary;
                    
                }else if(info.equals("associate")){
                    
                    associateCnt++;
                    associateSum += currentSalary;
                    allSum += currentSalary;
                    
                }else{
                    
                    fullCnt++;
                    fullSum += currentSalary;
                    allSum += currentSalary;
                    
                }
            }
        }
        //Catch exceptions
        catch(java.net.MalformedURLException ex){
            System.out.println("Invalid URL");
        }
        catch(java.io.IOException ex){
            System.out.println("I/O Errors: no such file");
        }
        
        //Output data
        System.out.printf("The total salary for assistant professors is: $%.2f\n", assistantSum);
        System.out.printf("The total salary for associate professors is: $%.2f\n", associateSum);
        System.out.printf("The total salary for full professors is: $%.2f\n", fullSum);
        System.out.printf("The total salary for all faculty is: $%.2f\n", allSum);
        System.out.printf("The average salary for assistant professors is: $%.2f\n", (assistantSum / assistantCnt));
        System.out.printf("The average salary for associate professors is: $%.2f\n", (associateSum / associateCnt));
        System.out.printf("The average salary for assistant professors is: $%.2f\n", (fullSum / fullCnt));
        System.out.printf("The average salary for all faculty is: $%.2f\n", (allSum / (fullCnt + associateCnt + assistantCnt)));
       
    }
    
}
