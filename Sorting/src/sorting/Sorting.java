package sorting;

public abstract class Sorting {
	
	//----------QuickSort
	
	//Ni¿ej znajduje siê druga wersja, któr¹ wykorzystujê w interfejsie

	public static void QuickSort(int[] A) {
		quickSortHelp(A, 0, A.length-1);
	}
	
	private static int parametr(int[] A, int begin, int end) {
		
		int pivot = A[begin];
		int i = end + 1;
		
		for(int j = end; j > begin; j--) {
			if(A[j]>= pivot) {
				--i;
				swap(A,i,j);
			}
		}
		
		swap(A,i-1,begin);
		
		return i-1;
	}
	
	private static void quickSortHelp(int[] A, int begin, int end) {
		if(begin < end) {
			int partition = parametr(A,begin,end);
			
			quickSortHelp(A,begin,partition-1);
			quickSortHelp(A,partition+1,end);
		}
	}
	
	//----------MergeSort
	
	public static void MergeSort(int[] A) {
		mergeSortHelp(A, A.length);
	}
	
	private static void mergeSortHelp(int[] A, int length) {
		if(length<=1) {
			return;
		}
		else {
			int partition = length/2;
			
			int[] left = new int[partition];
			int[] right = new int[length-partition];
			
			for(int i = 0; i<length; i++) {
				if(i<partition) {
					left[i] = A[i];
				}
				else {
					right[i - partition] = A[i];
				}
			}
			
			mergeSortHelp(left, partition);
			mergeSortHelp(right, length-partition);
			
			mergingHelp(A,left,right,partition,length-partition);
		}
	}
	
	private static void mergingHelp(int[] MainArray, int[] left, int[] right, int leftLength, int rightLength) {
		
		int i = 0; //Dotyczy Left
		int j = 0; //Dotyczy Right
		int g = 0; //Dotyczy Main
		
		while(i<leftLength && j < rightLength) {
			if(left[i]<right[j]) {
				MainArray[g++] = left[i++];
			}
			else {
				MainArray[g++] = right[j++];
			}
		}
		while(i < leftLength) {
			MainArray[g++] = left[i++];
		}
		while(j < rightLength) {
			MainArray[g++] = right[j++];
		}
	}
	
	//----------CombSort
	
	public static void CombSort(int[] A) {
		int gap = A.length;
		boolean change = true;
		
		while(gap>1 || change) {
			gap = gapHelp(gap);
			change = false;
			for(int i = 0; i<A.length-gap;i++) {
				if(A[i]>A[i+gap]) {
					
					swap(A,i,i+gap);
                    
                    change = true;
				}
			}
		}
	}
	
	private static int gapHelp(int prevGap) {
		
		int newGap = prevGap*10/13; //ustalony shrink factor algorytmu
		
		if(newGap==9 || newGap==10) //znalezione po napisaniu programu, podobno przyœpiesza dzia³anie (CombSort11)
			newGap = 11;
		if(newGap<1)
			newGap = 1;
		
		return newGap;
	}
	
	//----------QuickSort v2 bierze œrodkowy element jako pivot
	
	public static void QuickSort2(int[] A) {
		quickSortHelp2(A,0,A.length-1);
	}
	
	private static void quickSortHelp2(int[] A, int begin, int end) {
		int i = begin;
		int j = end;
		
		int pivot = A[begin+(end-begin)/2];
		
		while(i<=j) {
			while (A[i] < pivot) {
                i++;
            }
            while (A[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(A,i, j);
                i++;
                j--;
            }
		}
		
		if (begin < j)
            quickSortHelp2(A,begin, j);
        if (i < end)
            quickSortHelp2(A,i, end);
		
	}
	
	//----------
	
	private static void swap(int[] A, int index1, int index2) {
		int temp = A[index1]; 
        A[index1] = A[index2]; 
        A[index2] = temp;
	}
	
}
