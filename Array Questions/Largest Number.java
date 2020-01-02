import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.lang.String;

public class Main
{
    // Largest Number: Given an ArrayList of non negative integers, return a string which is the largest number possible from the 
    // combination of the given ArrayList.
    public String largestNumber(final ArrayList<Integer> A) {
        ArrayList<String> B = new ArrayList<String>();
        for (Integer number : A) {
            String x = number.toString();
            B.add(x);
        }
        Collections.sort(B, new Comparator<String>(){
            public int compare(String X, String Y){
                String XY = X + Y;
                String YX = Y + X;
                
                return XY.compareTo(YX);
            }
        });
        StringBuilder ans = new StringBuilder();
        int sum = 0;
        for (int i = B.size() - 1; i >= 0; i--) {
            ans.append(B.get(i));
            sum += Integer.parseInt(B.get(i));
        }
        return sum == 0 ? "0" : ans.toString();
    }
    
	public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<Integer> B = new ArrayList<Integer>();
        String res;
        
        //A.addAll(Arrays.asList(1, 3, 5, 7, 10));
        A.addAll(Arrays.asList(3, 2, 1, 6, 9, 10));
        
        System.out.print("The given ArrayList is :\n");
        for(int i = 0; i < A.size(); i++){
            System.out.print(A.get(i) + " ");
        }
        
        Main performOps = new Main();
        res = performOps.largestNumber(A);
        System.out.print("\nThe largest number is " + res);
	}
}
