package finding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Finding {

	private int divideAndConquer(ArrayList<Integer> ar, int k, int begin, int end) throws ArrayIndexOutOfBoundsException {
		if(k+begin>end+1) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else {
			int v = ar.get(begin);
			int i = end+1;
			int duplicate = 1;
			//left = i - begin;
			for(int j = end; j>begin;j--) {
				if(ar.get(j)>= v) {
					if(ar.get(j)==v)
						duplicate++;
					--i;
					int temp = ar.get(i);
					ar.set(i, ar.get(j));
					ar.set(j, temp);
				}
			}
			
			--i;
			int temp = ar.get(i);
			ar.set(i, ar.get(begin));
			ar.set(begin, temp);
			
			int wynik = 0;
			
			if(k<=i - begin) {
				wynik = this.divideAndConquer(ar, k, begin, i-1);
			}
			else if(k<=i+duplicate-begin) {
				wynik = v;
			}
			else {
				k = k-i-duplicate+begin;
				this.groupAllDuplicates(ar, i+1, end, v);
				wynik = this.divideAndConquer(ar, k, i+duplicate, end);
			}
			
			
			return wynik;
		}
	}
	
	private void groupAllDuplicates(ArrayList<Integer> ar, int  begin, int end, int v) {
		
		int i = end +1;
		
		for(int j = end; j>=begin;j--) {
			if(ar.get(j)>v) {
				--i;
				int temp = ar.get(i);
				ar.set(i, ar.get(j));
				ar.set(j, temp);
			}
		}
		
	}
	
	public int FindingKth(ArrayList<Integer> ar, int k) throws IllegalArgumentException {
		if(k<=0) {
			throw new IllegalArgumentException("Smallest possible k = 1");
		}
		
		int wynik = this.divideAndConquer(ar, k, 0,ar.size()-1);
		return wynik;
	}
	
	public static void main(String[] args) {
		Finding find = new Finding();
		ArrayList<Integer> ar = new ArrayList<Integer>();
		
		int[] tab = {8,1,5,4,8,7,8,2,4,9,8,8,5,1}; // [1, 1, 2, 4, 4, 5, 5, 7, 8, 8, 8, 8, 8, 9] <-- 14 elementów, indeksy liczone "po ludzku" od 1
		for(int a: tab) {
			ar.add(a);
		}
		System.out.println(find.FindingKth(ar, 9));
	}
}
