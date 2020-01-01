import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Arrays;

public class Main
{
    // For a given ArrayList, return an ArrayList having anti diagonal elements.
    private ArrayList<ArrayList<Integer>> antiDiagonal(ArrayList<ArrayList<Integer>> A){
        int rowMax = A.size() - 1, colMax = A.get(0).size() - 1;
        int i = 0, j = 0, row = 0, col = 0, l = 0;
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        
        if(rowMax <= 0 || colMax <= 0) return B;
        
        for(int k = 0; k < (A.get(0).size() * 2 - 1); k++){
            B.add(new ArrayList<Integer>());
        }
        while(true){
            ArrayList<Integer> C = B.get(l);
            C.add(A.get(i).get(j));
            i++;
            j--;
            if(j < 0 && i < A.size()){
                col++;
                j = col;
                i = row;
                l++;
            }
            if(i > A.size() - 1){
                row++;
                j = col;
                i = row;
                l++;
            }
            if(l == B.size()){
                break;
            }
        }
        
        return B;
    }
    
	public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        
        A.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        A.add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));
        A.add(new ArrayList<Integer>(Arrays.asList(7, 8, 9)));
        
        System.out.print("The given ArrayList is :\n");
        for(int i = 0; i < A.size(); i++){
            for(int j = 0; j < A.get(i).size(); j++){
                System.out.print(A.get(i).get(j)  + " ");
            }
            System.out.print("\n");
        }
        
        Main performOps = new Main();
        B = performOps.antiDiagonal(A);
        System.out.print("The Anti Diagonal ArrayList is :\n");
        for(int i = 0; i < B.size(); i++){
            for(int j = 0; j < B.get(i).size(); j++){
                System.out.print(B.get(i).get(j)  + " ");
            }
            System.out.print("\n");
        }
	}
}
