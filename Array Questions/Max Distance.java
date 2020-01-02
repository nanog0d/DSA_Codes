import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.lang.String;
import javafx.util.Pair;

public class Main
{
    // Max Distance: For a given ArrayList A, return the max (j - i) for the constraint A[i] <= A[j]
    public int maxDistance(ArrayList<Integer> A) {
        int max = -1, ans = 0;
        ArrayList<Pair<Integer, Integer>> B = new ArrayList<Pair<Integer, Integer>>();
        
        if(A.size() <= 0) return 0;
        
        for(int i = 0; i < A.size(); i++){
            Pair p = new Pair(A.get(i), i);
            B.add(p);
        }
        Collections.sort(B, new Comparator<Pair<Integer, Integer>>(){
            public int compare(Pair<Integer,Integer> p1, Pair<Integer, Integer> p2){
                return (p1.getKey() >= p2.getKey() ? 1 : -1);
            }
        });
        // for(int i = 0; i < B.size(); i++){
        //     System.out.print(B.get(i).getKey() + " ");
        // }
        max = B.get(B.size() - 1).getValue();
        for(int i = B.size() - 2; i >= 0; i--){
            ans = Math.max(ans, max - B.get(i).getValue());
            max = Math.max(max, B.get(i).getValue());
        }
        
        return ans;
    }
    
	public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<Integer> B = new ArrayList<Integer>();
        int res;
        
        //A.addAll(Arrays.asList(1, 3, 5, 7, 10));
        A.addAll(Arrays.asList(3, 5, 4, 2));
        
        System.out.print("The given ArrayList is :\n");
        for(int i = 0; i < A.size(); i++){
            System.out.print(A.get(i) + " ");
        }
        
        Main performOps = new Main();
        res = performOps.maxDistance(A);
        System.out.print("\nThe max distance is " + res);
	}
}
