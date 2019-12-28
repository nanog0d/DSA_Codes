import java.util.ArrayList;

public class Main
{   // For a given ArrayList, return a ArrayList containing the indices with max sumn of its elements.
    ArrayList<Integer> maxSubArray(ArrayList<Integer> A){
        int countNeg = 0, max = A.get(0);
        int max_So_Far = 0, max_Ending_Here = 0;
        int s = 0, j = 0,end = 0, start = 0;
        ArrayList<Integer> B = new ArrayList<Integer>();
        
        for(int i = 0; i < A.size(); i++){
            if(A.get(i) < 0) countNeg++;
        }
        // If all the elements of the given ArrayList are negative, then return the max element in the ArrayList.
        if(countNeg == A.size()){
            for(int i = 0; i < A.size(); i++){
                if(A.get(i) > max){
                    max = A.get(i);
                    start = i;
                    end = i;
                } 
            }
            B.add(s);
            B.add(e);
        }
        // Using Kadane's algorithm.
        else{
            for(j = 0; j < A.size(); j++){
                max_Ending_Here = max_Ending_Here + A.get(j);
                if(max_Ending_Here > max_So_Far){
                    max_So_Far = max_Ending_Here;
                    end = j;
		    start = s;
                }
                if(max_Ending_Here < 0){
                    max_Ending_Here = 0;
                    s = j + 1;
                }
            }
            B.add(start);
            B.add(end);
        }
        System.out.print("Start Index = " + B.get(0) + " : " + "End Index = " + B.get(1));
        System.out.print("\n");
        
        return B;
    }
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		int maxSum = 0;
		
		A.add(-2);
		A.add(1);
		A.add(-3);
		A.add(4);
		A.add(-1);
		A.add(2);
		A.add(1);
		A.add(-5);
		A.add(4);
		
		for(int i = 0; i < A.size(); i++){
		    System.out.print(A.get(i) + " ");
		}
		System.out.printf("\n");
		Main addOneNumber = new Main();
		B = addOneNumber.maxSubArray(A);
		
		System.out.printf("The max sum contingous subarray is : ");
		for(int i = B.get(0); i <= B.get(1); i++){
		    System.out.print(A.get(i) + " ");
		    maxSum = maxSum + A.get(i);
		}
		System.out.print("\nMax Sum = " + maxSum);
	}
}
