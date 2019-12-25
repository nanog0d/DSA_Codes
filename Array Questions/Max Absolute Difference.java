import java.util.ArrayList;

public class Main
{   // For a given ArrayList, return the max absolute difference of the array.
    // The max absolute difference of the array is :
    // f(i, j) = |A[i] - A[j]| + |i - j|
    // Hint : f(i, j) = f(j, i)
    
    // Use the brute force method.
    ArrayList<Integer> maxAbsoluteDifference(ArrayList<Integer> A){
        int maxDiff = 0;
        int n = A.size()/2;
        int m = A.size()/2 + 2;
        int ind1 = 0, ind2 = 0;
        ArrayList<Integer> B = new ArrayList<Integer>();
        
        for(int i = 0; i < (A.size()); i++){
            for(int j = 0; j < A.size(); j++){
                if((A.get(i) - A.get(j) + i - j) > 0 && (A.get(i) - A.get(j) + i - j) > maxDiff ) {
                    maxDiff = (A.get(i) - A.get(j) + i - j);
                    ind1 = i;
                    ind2 = j;
                }
                else if((A.get(i) - A.get(j) - i + j) > 0 && (A.get(i) - A.get(j) - i + j) > maxDiff) {
                    maxDiff = (A.get(i) - A.get(j) - i + j);
                    ind1 = i;
                    ind2 = j;
                }
                else if((-A.get(i) + A.get(j) - i + j) > 0 && (-A.get(i) + A.get(j) - i + j) > maxDiff) {
                    maxDiff = (-A.get(i) + A.get(j) - i + j);
                    ind1 = i;
                    ind2 = j;
                }
                else if((-A.get(i) + A.get(j) + i - j) > 0 && (-A.get(i) + A.get(j) + i - j) > maxDiff) {
                    maxDiff = (-A.get(i) + A.get(j) + i - j);
                    ind1 = i;
                    ind2 = j;
                }
            }
        }
        B.add(ind1);
        B.add(ind2);
        B.add(maxDiff);
        return B;
    }
    
    // Use the properties of the modulus.
    // |Aj - Ai| + |j - i| = Aj - Ai + j - i
    //                     = (Aj + j) - (Ai + i) => Differences of sum
    //          Or 
    // |Aj - Ai| + |j - i| = Aj - Ai - j + i
    //                     = (Aj - j) - (Ai - i) => Differences of differnce
    // In the end, we only need to calculate (Ai + i) and (Ai - i).
    // So, the problem can be solved in O(n).
    ArrayList<Integer> maxAbsoluteDifference2(ArrayList<Integer> A){
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        int ind1 = 0;
        int ind2 = 0;
        ArrayList<Integer> B = new ArrayList<Integer>();
        
        for(int i = 0; i < A.size(); i++){
            if(max1 < A.get(i) + i){
                max1 = A.get(i) + i;
                ind1 = i;
            }
            if(min1 > A.get(i) + i){
                min1 = A.get(i) + i;
                ind2 = i;
            }
            if(max1 < A.get(i) - i){
                max1 = A.get(i) - i;
                ind1 = i;
            }
            if(min2 > A.get(i) - i){
                min2 = A.get(i) - i;
                ind2 = i;
            }
            max1 = Math.max(max1, A.get(i) + i);
            min1 = Math.min(min1, A.get(i) + i);
            max2 = Math.max(max2, A.get(i) - i);
            min2 = Math.min(min2, A.get(i) - i);
        }
        B.add(ind1);
        B.add(ind2);
        B.add( Math.max(max1 - min1, max2 - min2));
        
        return B;
    }
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		int maxDiff = 0;

        //A : [ -70, -64, -6, -56, 64, 61, -57, 16, 48, -98 ]
        A.add(-70);
        A.add(-64);
        A.add(-6);
        A.add(-56);
        A.add(64);
        A.add(61);
        A.add(-57);
        A.add(16);
        A.add(48);
        A.add(-98);
		
        // A.add(3);
        // A.add(-2);
        // A.add(5);
        // A.add(-4);

// 		A.add(1);
// 		A.add(3);
// 		A.add(-1);
		
		for(int i = 0; i < A.size(); i++){
		    System.out.print(A.get(i) + " ");
		}
		System.out.printf("\n");
		Main performOps = new Main();
		B = performOps.maxAbsoluteDifference(A);
		
		System.out.printf("The max absolute difference is : " + B.get(2));
		System.out.printf("\nThe first index is : " + B.get(0));
		System.out.printf("\nThe second index is : " + B.get(1));
	}
}
