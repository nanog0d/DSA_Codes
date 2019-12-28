import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;

public class Main
{
    // Find the max length of the subarray that can be flipped from 0 to 1 or vice-versa in order to obtain max number of 1
    // in the given string.
    public ArrayList<ArrayList<Integer>> mergeIntervals(ArrayList<ArrayList<Integer>> A){
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        
        Collections.sort(A, new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2){
                return a1.get(0).compareTo(a2.get(0));
            }
        });
        B.add(A.get(0));
        for(int i = 1; i < A.size(); i++){
            if(A.get(i).get(0) < B.get(B.size() - 1).get(1)){
                B.set(B.size() - 1, new ArrayList<Integer>(Arrays.asList( B.get(B.size() - 1).get(0), Math.max(A.get(i).get(1), B.get(B.size() - 1).get(1)) )));
                //i++;
            }
            else if(A.get(i).get(0) == B.get(B.size() - 1).get(1)){
                B.set(B.size() - 1, new ArrayList<Integer>(Arrays.asList( B.get(B.size() - 1).get(0), Math.max(A.get(i).get(1), B.get(B.size() - 1).get(1)) )));
                //i++;
            }
            else{
                B.add(A.get(i));
            }
        }
        return B;
    }
    
	public static void main(String[] args) {
	    ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
	    ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
	    Main performOps = new Main();
	    
	   // A.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
	   // A.add(new ArrayList<Integer>(Arrays.asList(4, 6)));
	   // A.add(new ArrayList<Integer>(Arrays.asList(3, 5)));
	   // A.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
	   // A.add(new ArrayList<Integer>(Arrays.asList(5, 8)));
	   // A.add(new ArrayList<Integer>(Arrays.asList(2, 7)));
	   // A.add(new ArrayList<Integer>(Arrays.asList(9, 10)));
	   // A.add(new ArrayList<Integer>(Arrays.asList(10, 12)));
	    A.add(new ArrayList<Integer>(Arrays.asList(1,3)));
	    A.add(new ArrayList<Integer>(Arrays.asList(2,6)));
	    A.add(new ArrayList<Integer>(Arrays.asList(8,10)));
	    A.add(new ArrayList<Integer>(Arrays.asList(15,18)));
	    
	    B = performOps.mergeIntervals(A);
	    for(int i = 0; i < A.size(); i++){
	        for(int j = 0; j < A.get(0).size(); j++){
	            System.out.print(A.get(i).get(j) + " ");
	        }
	        System.out.print("\n");
	    }
	    
	    System.out.print("\n");
	    System.out.print("\n");
	    for(int i = 0; i < B.size(); i++){
	        for(int j = 0; j < B.get(0).size(); j++){
	            System.out.print(B.get(i).get(j) + " ");
	        }
	        System.out.print("\n");
	    }
	}
}
