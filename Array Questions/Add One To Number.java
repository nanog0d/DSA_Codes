import java.util.ArrayList;

public class Main
{   // Add one to the units place in the given number.
	// Number is provided in the ArrayList format so take care of the corner cases.
    ArrayList<Integer> addOne(ArrayList<Integer> A){
        int carry = 0, count = 0;
        
        for(int i = A.size() - 1; i >=0; i--){
            if(i == A.size() - 1){
                if(A.get(i) + 1 == 10){
                    A.set(i, 0);
                    carry = 1;
                }
                else{
                    A.set(i, A.get(i) + 1);
                    carry = 0;
                }
            }
            else{
                if(A.get(i) + carry == 10){
                    A.set(i, 0);
                    carry = 1;
                }
                else{
                    A.set(i, A.get(i) + carry);
                    carry = 0;
                }
            }
        }
        for(int i = 0; i < A.size(); i++){
            if(A.get(i) == 0) count++;
        }
        if(count == A.size()){
            A.add(0, 1);
        }
        
        return A;
    }
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		
		A.add(9);
		A.add(9);
		A.add(9);
		A.add(9);
		A.add(9);
		
		for(int i = 0; i < A.size(); i++){
		    System.out.print(A.get(i));
		}
		System.out.printf("\n");
		Main addOneNumber = new Main();
		B = addOneNumber.addOne(A);
		
		for(int i = 0; i < B.size(); i++){
		    System.out.print(B.get(i));
		}
	}
}
