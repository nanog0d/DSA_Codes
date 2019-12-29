import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;

public class Main
{
    // For a given integer A, return a spiral matrix of order AxA.
    public ArrayList<ArrayList<Integer>> spiralMatrix2(int A){
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        int t = 0, b = (A) - 1, l = 0, r = (A) - 1;
        int n = 1, dir = 0;
        
        if(A <= 0) return B;
        for(int i = 0; i < A; i++){
            ArrayList<Integer> C = new ArrayList<Integer>(Collections.nCopies(A, 0));
            B.add(C);
        }
        while(t <= b && l <= r){
            if(dir == 0){
                for(int i = l; i <= r; i++){
                    B.get(t).set(i, n);
                    n++;
                }
                dir = 1;
                t++;
            }
            else if(dir == 1){
                for(int i = t; i <= b; i++){
                    B.get(i).set(r, n);
                    n++;
                }
                dir = 2;
                r--;
            }
            else if(dir == 2){
                for(int i = r; i >= l; i--){
                    B.get(b).set(i, n);
                    n++;
                }
                dir = 3;
                b--;
            }
            else if(dir == 3){
                for(int i = b; i >= t; i--){
                    B.get(i).set(l, n);
                    n++;
                }
                dir = 0;
                l++;
            }
        }
        
        return B;
    }
    
	public static void main(String[] args) {
	    //ArrayList<Integer> A = new ArrayList<Integer>();
	    int A = 4;
	    ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
	    Main performOps = new Main();
	    
	    B = performOps.spiralMatrix2(A);
	    System.out.print("The given integer is " + A + "\n");
	    
	    System.out.print("The spiral matrix is :\n");
	    for(int i = 0; i < B.size(); i++){
	        for(int j = 0; j < B.get(0).size(); j++){
	            System.out.print(B.get(i).get(j) + " ");
	        }
	        System.out.print("\n");
	    }
	}
}
