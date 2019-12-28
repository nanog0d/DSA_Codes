import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;

public class Main
{
    // Merge overlapping intervals in the given Array List. Original question has aa class Interval containing the start and end of the interval.
    public ArrayList<ArrayList<Integer>> merge(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> interval){
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        
        A.add(interval);
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
	    ArrayList<Integer> interval = new ArrayList<Integer>();
	    Main performOps = new Main();
	    
	    // [1,2],[3,5],[6,7],[8,10],[12,16]    [4, 9]
	    A.add(new ArrayList<Integer>(Arrays.asList(1,2)));
	    A.add(new ArrayList<Integer>(Arrays.asList(3,5)));
	    A.add(new ArrayList<Integer>(Arrays.asList(6,7)));
	    A.add(new ArrayList<Integer>(Arrays.asList(8,10)));
	    A.add(new ArrayList<Integer>(Arrays.asList(12,16)));
	    interval.add(4);
	    interval.add(9);
	    
	    B = performOps.merge(A, interval);
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
