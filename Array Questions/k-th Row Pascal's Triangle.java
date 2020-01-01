import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;

public class Main
{
    // Pascal's triangle: Return k-th row of Pascal's Triangle. Row indexing starts from 1 and not 0.
    public ArrayList<Integer> pascalTriangle(int A){
        int k = 3, i = 0;
        int previous = 0;
        int current = 0;
        ArrayList<Integer> B = new ArrayList<Integer>();
        
        if(A <= 0) return B;
        if(A <= 2){
            for(int j = 0; j <= A - 1; j++){
                B.add(1);
            }
            return B;
        }
        
        B.add(1);
        B.add(1);
        current = B.get(0);
        while(k <= A){
            B.set(i, current + previous);
            previous = current;
            if(i < B.size() - 1) current = B.get(i + 1);
            i++;
            if(i == B.size()){
                B.add(i, 1);
                k++;
                i = 0;
                previous = 0;
                current = B.get(0);
            }
        }
        
        return B;
    }
    
	public static void main(String[] args) {
	    int A = 6;
	    ArrayList<Integer> B = new ArrayList<Integer>();
	    Main performOps = new Main();
	    
	    B = performOps.pascalTriangle(A);
	    System.out.print("The given integer is " + A + "\n");
	    
	    System.out.print("The Pascal's Triangle is :\n");
	    for(int i = 0; i < B.size(); i++){
            System.out.print(B.get(i) + " ");
	    }
	}
}
