import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.lang.String;
import javafx.util.Pair;

public class Main
{
    // Max unsorted subarray: Given an ArrayList of size N, find the minimum subarray, which on sorting will sort the whole array. 
    public ArrayList<Integer> minSubarray(ArrayList<Integer> A) {
        int i = 0, j = A.size() - 1, minInd = -1, maxInd = -1, max = -1;
        int minS = Integer.MAX_VALUE, maxS = -1;
        ArrayList<Integer> B = new ArrayList<Integer>();
        
        if(A.size() <= 1){
            B.add(-1);
            return B;
        }
        
        while(true){
            if(i == A.size() - 1) break;
            if(A.get(i) > A.get(i + 1)) {
                minInd = i;
                max = A.get(i);
                break;
            }
             i++;
        }
        while(true){
            if(i == A.size()) break;
            if(max > A.get(i)){
                maxInd = i;
            }
            else{
                max = A.get(i);
            }
            i++;
        }
        if(minInd == -1 || maxInd == -1){
            B.add(-1);
            return B;
        }
        for(int k = minInd; k <= maxInd; k++){
            if(A.get(k) > maxS) maxS = A.get(k);
            if(A.get(k) < minS) minS = A.get(k);
        }
        for(int k = 0; k < A.size(); k++){
            if(A.get(k) > minS){
                 minInd = k;
                 break;
            }
        }
        for(int k = A.size() - 1; k >= maxInd + 1; k--){
            if(maxS > A.get(k)){
                maxInd = k;
                break;
            }
        }
        B.add(minInd);
        B.add(maxInd);
        
        return B;
    }
    
	public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<Integer> B = new ArrayList<Integer>();
        
        //A.addAll(Arrays.asList(1, 3, 5, 7, 10));
        A.addAll(Arrays.asList( 1, 2, 3, 5, 6, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19 ));
        
        System.out.print("The given ArrayList is :\n");
        for(int i = 0; i < A.size(); i++){
            System.out.print(A.get(i) + " ");
        }
        
        Main performOps = new Main();
        B = performOps.minSubarray(A);
        System.out.print("\nThe min subarray is :\n");
        for(int i = 0; i < B.size(); i++){
            System.out.print(B.get(i) + " ");
        }
	}
}
