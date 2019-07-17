package solution;

public class Solution {
	//TiedRopes

	public int Solution(int K, int[] A) {
		int record = 0;
		int sum = 0;
		for(int i = 0; i<A.length; i++) {
			sum += A[i];
			if(sum>=K) {
				record++;
				sum = 0;
			}
		}
		
		return record;
	}
	
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = {1,2,3,4,1,1,3};
		System.out.println(s.Solution(7, A));
	}
}
