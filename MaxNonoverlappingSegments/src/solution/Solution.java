package solution;

public class Solution {
	//Segments

	public int Solution(int[] A, int[] B) {
		//B is sorted!
		
		if(A.length<1) {
			return 0;
		}
		else {
			int record = 1;
			int lastTail = B[0];
			
			for(int i = 1;i<A.length;i++) {
				if(A[i]>lastTail) {
					record++;
					lastTail = B[i];
				}
			}
			
			
			return record;
		}
	}
	
	public static void main(String[] args) {
		int[] A = {1,3,7,9,9};
		int[] B = {5,6,8,9,10};
		Solution s = new Solution();
		System.out.println(s.Solution(A, B));
	}
}
