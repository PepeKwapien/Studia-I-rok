package solution;

public class Solution {
	//NumberSolitaire

	public int solution(int[] A) {
		
		int[] sums = new int[A.length];
		sums[0] = A[0];
		
		for(int i = 1; i<A.length; i++) {
			
			int max = Integer.MIN_VALUE;
			
			for(int dice = 1; dice<=6;dice++) {
				if(i-dice>=0) {
					max = sums[i-dice]+A[i]>max ? sums[i-dice]+A[i] : max;
				}
				else {
					break;
				}
			}
			
			sums[i] = max;
		}
		
		
		return sums[A.length-1];
	}
}
