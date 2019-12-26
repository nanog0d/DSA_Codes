import java.util.ArrayList;

public class Main
{   // Given an ArrayList from 1 to n, one element is missing and one element is repeating.
    // Find the missing and repeating element. Another version of the question passes a final ArrayList
    // in which modifications to given ArrayList is prohibited. So use a hash map or another ArrayList
    // to store the modified elements of the given ArrayList.
    ArrayList<Integer> missAndRepeat(ArrayList<Integer> A){
        
        ArrayList<Integer> B = new ArrayList<Integer>();
        
        for(int i = 0; i < A.size(); i++){
            if(A.get(Math.abs(A.get(i)) - 1) > 0){
                A.set(Math.abs(A.get(i)) - 1, -A.get(Math.abs(A.get(i)) - 1));
            }
            else{
                B.add(Math.abs(A.get(i)));
            }
        }
        for(int i = 0; i < A.size() ; i++){
            if(A.get(i) > 0){
                B.add(i + 1);
                break;
            }
        }
        
        return B;
    }
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();

        A.add(1);
        A.add(4);
        A.add(6);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(7);
        A.add(9);
        A.add(10);
        A.add(8);
		
		for(int i = 0; i < A.size(); i++){
		    System.out.print(A.get(i) + " ");
		}
		System.out.printf("\n");
		Main performOps = new Main();
		B = performOps.missAndRepeat(A);
		
		System.out.printf("The repeating number is : " + B.get(0));
		System.out.printf("\nThe missing number is : " + B.get(1));
	}
}
