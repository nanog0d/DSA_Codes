import java.util.ArrayList;

public class Main
{   // Cover all the points (Ax, By) from start till end and in order in minimum steps.
    // You can move as (x, y), (x+ 1, y), (x, y + 1), (x - 1, y), (x, y - 1), , (x + 1, y + 1)
    // and so on but just one step in either or in both direction.
    Integer minSteps(ArrayList<Integer> A, ArrayList<Integer> B){
        int miniSteps = 0, i;
        
        for(i = 1; i < A.size() && i < B.size(); i++){
            if( (A.get(i) - A.get(i - 1) > 0) && (B.get(i) - B.get(i - 1) > 0) ){
                miniSteps += Math.max(A.get(i) - A.get(i - 1), B.get(i) - B.get(i - 1));
            }
            else if( (A.get(i) - A.get(i - 1) > 0) && (B.get(i) - B.get(i - 1) < 0) ){
                miniSteps += Math.max(A.get(i) - A.get(i - 1), -B.get(i) + B.get(i - 1));
            }
            else if( (A.get(i) - A.get(i - 1) < 0) && (B.get(i) - B.get(i - 1) < 0) ){
                miniSteps += Math.max(-A.get(i) + A.get(i - 1), -B.get(i) + B.get(i - 1));
            }
            else if( (A.get(i) - A.get(i - 1) < 0) && (B.get(i) - B.get(i - 1) > 0) ){
                miniSteps += Math.max(-A.get(i) + A.get(i - 1), B.get(i) - B.get(i - 1));
            }
        }
        for(int j = i ; i < A.size() ; i++){
            if(A.get(i) - A.get(i - 1) > 0){
                miniSteps += A.get(i) - A.get(i - 1);
            }
            else{
                miniSteps += -A.get(i) + A.get(i - 1);
            }
        }
        for(int j = i ; i < B.size() ; i++){
            if(B.get(i) - B.get(i - 1) > 0){
                miniSteps += B.get(i) - B.get(i - 1);
            }
            else{
                miniSteps += -B.get(i) + B.get(i - 1);
            }
        }
        
        return miniSteps;
    }
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		int steps = 0;
		
		A.add(1);
		A.add(2);
		A.add(-3);
		A.add(4);
		A.add(5);
		
		B.add(3);
		B.add(5);
		B.add(1);
		B.add(6);
		//B.add(3);
		Main minStepsMain = new Main();
		System.out.println(minStepsMain.minSteps(A, B));
	}
}
