import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Arrays;

public class Main
{
    // Hotel Bookings: For a given number of hotel rooms k, find if it is possible to advance book if arrival and departure dates of 
    // guests is given in the form of 2 arrays A and B. Return a boolean.
    private boolean hotelBookings(ArrayList<Integer> A, ArrayList<Integer> B, int k){
        int i = 0, res = 0, j = 0;
        
        Collections.sort(A);
        Collections.sort(B);
        
        while(i < A.size() - 1 || i < B.size() - 1 && res <= k){
            if(A.get(i) < B.get(j)){
                res++;
                i++;
            }
            else{
                res--;
                j++;
            }
        }
        
        return k >= res;
    }
    
	public static void main(String[] args) {
	    int k = 2;
	    boolean C = false;
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<Integer> B = new ArrayList<Integer>();
        
        A.addAll(Arrays.asList(1, 3, 5, 7, 10));
        B.addAll(Arrays.asList(2, 6, 8, 9, 12));
        
        System.out.print("The number of rooms available are " + k + "\n");
        System.out.print("The arrival dates of the guests are :\n");
        for(int i = 0; i < A.size(); i++){
            System.out.print(A.get(i) + " ");
        }
        System.out.print("\nThe departure date of the guests are :\n");
        for(int i = 0; i < B.size(); i++){
            System.out.print(B.get(i) + " ");
        }
        
        Main performOps = new Main();
        C = performOps.hotelBookings(A, B, k);
        if(C){
            System.out.print("\nThe booking is possible.");
        }
        else{
            System.out.print("\nThe booking is not possible.");;
        }
	}
}
