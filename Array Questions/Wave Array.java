import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Arrays;

public class Main
{
    // Wave Array: For a given array, sort the array in a wave like array
    // {a1 >= a2 <= a3 >= a4 <=a5 .....}
    private void waveArray(ArrayList<Integer> A){
        int temp;
        
        Collections.sort(A);
        
        for(int i = 0; i < A.size() - 1; i+=2){
            if(A.get(i) < A.get(i + 1)){
                temp = A.get(i);
                A.set(i, A.get(i + 1));
                A.set(i + 1, temp);
            }
        }
    }
    
	public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<Integer> B = new ArrayList<Integer>();
        
        //A.addAll(Arrays.asList(1, 3, 5, 7, 10));
        A.addAll(Arrays.asList(3, 2, 1, 6, 9, 10));
        
        System.out.print("The given ArrayList is :\n");
        for(int i = 0; i < A.size(); i++){
            System.out.print(A.get(i) + " ");
        }
        
        Main performOps = new Main();
        performOps.waveArray(A);
        System.out.print("\nThe wave array is :\n");
        for(int i = 0; i < A.size(); i++){
            System.out.print(A.get(i) + " ");
        }
	}
}
