
package assigment.pkg2;

/**
 *
 * @author Mario Bolivar - Mjb160330
 *
 */
public class Assigment2 {

    public static void main(String[] args) {
        int n = 100000;
        int arr[] = new int[n];
        int i = 0, j = 0;
            for(; i < n; ++i)
                while(j < n && arr[i] < arr[j])
                {
                    System.out.print(j);
                    j++;
                }
    }

}
