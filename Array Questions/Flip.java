import java.util.ArrayList;
import java.lang.StringBuilder;

public class Main
{
    // Find the max length of the subarray that can be flipped from 0 to 1 or vice-versa in order to obtain max number of 1
    // in the given string.
    public ArrayList<Integer> flip(String A){
        int max_Ending_Here = 0, max_So_Far = 0;
        int s = 0, start = 0, end = 0;
        int oneCount = 0;
        ArrayList<Integer> B = new ArrayList<Integer>();
        ArrayList<Integer> C = new ArrayList<Integer>();
        StringBuilder string = new StringBuilder(A);
        
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == '1') oneCount++;
        }
        if(oneCount == A.length()) return B;
        // Converting the problem into finding the max subarray Kadane's problem by substituting the 0 as 1 and 1 as -1.
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == '0') C.add(1);
            else C.add(-1);
        }
        // Using Kadane's Algorithm to find the max subarray indices.
        for(int i = 0; i < C.size(); i++){
            max_Ending_Here = max_Ending_Here + C.get(i);
            
            if(max_Ending_Here > max_So_Far) {
                max_So_Far = max_Ending_Here;
                end = i;
                start = s;
            }
            if(max_Ending_Here < 0){
                max_Ending_Here = 0;
                s = i + 1;
            }
        }
        B.add(start + 1);
        B.add(end + 1);
        
        return B;
    }
    
	public static void main(String[] args) {
	    String A = "010";
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    Main performOps = new Main();
	    
	    res = performOps.flip(A);
	    System.out.print("Following subarray must be flipped to get max 1's\n");
	    System.out.print("Start Index = " + res.get(0) + "\nEnd Index = " + res.get(1));
	}
}
