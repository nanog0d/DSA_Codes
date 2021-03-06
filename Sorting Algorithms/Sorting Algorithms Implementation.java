import java.util.List;
import java.util.ArrayList;
public class Main
{
    void swap(int minValInd, int i, ArrayList<Integer> A){
        int temp;
        
        temp = A.get(i);
        A.set(i, A.get(minValInd));
        A.set(minValInd, temp);
    }
    int findMin(ArrayList<Integer> A, int ind){
        int minValInd = ind;
        
        for(int i = ind + 1; i < A.size(); i++){
            if(A.get(i) < A.get(minValInd)){
                minValInd = i;
            }
        }
        
        return minValInd;
    }
    // Regular brute force algorithm comparing each value with the other and swapping if required. (O(n^2))
    void selectionSort(ArrayList<Integer> A){
        int minValInd;
        
        for(int i = 0; i < A.size(); i++){
            minValInd = findMin(A, i);
            swap(minValInd, i, A);
        }
    }
    // Create two subset in the same array, the left subset will be sorted and the right subset will be unsorted.
    // Pick each element from the right(unsorted) subset and put it in the sorted array as per its precendence over the already present
    // element in the left(sorted) subset. (O(n^2))
    void insertionSort(ArrayList<Integer> A){
        int key, j;
        
        for(int i = 1 ; i < A.size(); i++){
            key = A.get(i);
            j = i - 1;
            while(j >= 0 && A.get(j) > key){
                A.set(j + 1, A.get(j));
                j--;
            }
            A.set(j + 1, key);
        }
    }
    // The largest element in the array will bubble up at the end by swapping it all the way to the end. (O(n^2))
    void bubbleSort(ArrayList<Integer> A){
        int m = A.size() - 1;
        
        for(int i = 1 ; i < A.size() - 1 ; i++){ // Starting index will be 1 as j goes from 0 till m.
            int flag = 0;
            
            for(int j = 0 ; j < m; j++){
                if(A.get(j) > A.get(j + 1)){
                    swap(j + 1, j, A); // Parameters "minValInd" == j + 1 and "i" == j in the function swap.
                    flag = 1;
                }
            }
            if(flag == 0) break; // If the ArrayList is sorted then no need for redundant iterations.
            m--; //We dont have to run all the way to the end as we already know that the end part would be sorted.
        }
    }
    // Merge function will add the elements from left and right subarrays into their parent array`
    // while comparing the elements from left and right subarrays and sorting their parent array.
    void merge(ArrayList<Integer> left, ArrayList<Integer> right, ArrayList<Integer> A){
        int i = 0, j = 0, k = 0;
        int nLeft = left.size();
        int nRight = right.size();
        
        while(i < nLeft && j < nRight){
            if(left.get(i) < right.get(j)){
                A.set(k, left.get(i));
                i++;
                k++;
            }
            else{
                A.set(k, right.get(j));
                j++;
                k++;
            }
        }
        while(i < nLeft){ // When there are no elements left in the right subarray but still present in the left subarray.
            A.set(k, left.get(i));
            i++;
            k++;
        }
        while(j < nRight){ // When there are no elements left in the left subarray but still present in the right subarray.
            A.set(k, right.get(j));
            j++;
            k++;
        }
    }
    // Divide the given array into left and right subarrays till only one element is left in the left and right subarray.
    // Then call the merge function to merge the left and right subarray while sorting them. (O(n*log(n)))
    void mergeSort(ArrayList<Integer> A){
        int n = A.size();
        int mid = n/2;
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        
        if(n < 2) return; // Base Condition to return.
        for(int i = 0 ; i < mid ; i++){ // left subarray
            left.add(A.get(i));
        }
        for(int j = mid ; j < n ; j++){ // right subarray
            right.add(A.get(j));
        }
        
        mergeSort(left); // this call will make the left subarray as the parent array.
        mergeSort(right); // this call will make the right subarray as the parent array.
        merge(left, right, A);
    }
    Integer partition(int startInd, int endInd, ArrayList<Integer> A){
        //if(A.size() == 1) return A.get(startInd);
        int pivot = A.get(endInd);
        int partInd = startInd;
        
        for(int i = startInd ; i < endInd ; i++){
            if(A.get(i) <= pivot){
                swap(partInd, i, A);
                partInd++;
            }
        }
        swap(endInd, partInd, A);
        
        return partInd;
    }
    void quickSort(int startInd, int endInd, ArrayList<Integer> A){
        //if(A.size() <= 1) return; This wont work as the following will be a corner case.
        if(startInd >= endInd) return;
        int partInd;
        
        partInd = partition(startInd, endInd, A);
        quickSort(startInd, partInd - 1, A); // quickSort on left partition.
        quickSort(partInd + 1, endInd, A); // quickSort on right partition.
    }
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		Main m = new Main();
		
		A.add(6);
		A.add(1);
		A.add(5);
		A.add(3);
		A.add(8);
		A.add(2);
		A.add(4);
		//m.mergeSort(A);
		m.quickSort(0,6, A);
		for(int num : A){
		    System.out.printf("%d ", num);
		}
	}
}
