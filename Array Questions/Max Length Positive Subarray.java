import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;

public class Main
{
    // For a given array, return the max length of the non negative subarray.
    public ArrayList<Integer> lengthSubArray(ArrayList<Integer> A){
        int start = 0, end = 0, s = 0;
        int max_So_Far = 0, max_Ending_Here = 0;
        int count = 0, maxCount = 0;
        int countNeg = 0;
        ArrayList<Integer> B = new ArrayList<Integer>();
        
        if(A.size() <= 0) return B;
        for(int i = 0; i < A.size(); i++){
            if(A.get(i) < 0) countNeg++;
        }
        if(countNeg == A.size() ) return B;
        
        for(int i = 0; i < A.size(); i++ ){
            if(A.get(i) >= 0 ){
                count++;
            }
            if(count > maxCount){
                maxCount = count;
                start = s;
                end = i;
            }
            if(A.get(i) < 0 ){
                s = i + 1;
                count = 0;
            }
        }
        B.addAll(Arrays.asList(end - start + 1, start, end));
        
        return B;
    }
    
	public static void main(String[] args) {
	    ArrayList<Integer> A = new ArrayList<Integer>();
	    ArrayList<Integer> B = new ArrayList<Integer>();
	    Main performOps = new Main();
	    
	    A.addAll(Arrays.asList(1, 2, 4, -1, -2, 4, 5, 6, 7));
	    
	    B = performOps.lengthSubArray(A);
	    System.out.print("The given array is: \n");
	    for(int i = 0; i < A.size(); i++){
	       System.out.print(A.get(i) + " ");
	    }
	    
	    System.out.print("\n");
	    System.out.print("Length of subarray is " + B.get(0));
	    System.out.print("\nStarting Index is " + B.get(1));
	    System.out.print("\nEnding Index is " + B.get(2));
	}
}
