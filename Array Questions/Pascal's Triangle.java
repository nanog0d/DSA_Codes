import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;

public class Main
{
    // Pascal's triangle.
    public ArrayList<ArrayList<Integer>> pascalTriangle(int A){
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        
        if(A <= 0) return B;
        for(int i = 0; i <= 1; i++){
            if(i == 0){
                B.add(new ArrayList<Integer>(Arrays.asList(1)));
            }
            else if(i == 1){
                B.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
            }
            if(i == (A - 1)) return B;
        }
        
        for(int i = 2; i < A; i++){
            ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(1, 1));
            B.add(C);
            
            for(int j = 1; j < i; j++){
                B.get(i).add(j, B.get(i - 1).get(j - 1) + B.get(i - 1).get(j));
            }
        }
        
        return B;
    }
    
	public static void main(String[] args) {
	    int A = 6;
	    ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
	    Main performOps = new Main();
	    
	    B = performOps.pascalTriangle(A);
	    System.out.print("The given integer is " + A + "\n");
	    
	    System.out.print("The Pascal's Triangle is :\n");
	    for(int i = 0; i < B.size(); i++){
	        for(int j = 0; j < B.get(i).size(); j++){
	            System.out.print(B.get(i).get(j) + " ");
	        }
	        System.out.print("\n");
	    }
	}
}
