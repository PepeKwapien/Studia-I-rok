package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sorting.Sorting;

class Tests {
	
	int[] first;
	int[] second;
	int[] third;
	int[] fourth;

	@BeforeEach
	void setUp() throws Exception {
		int[] first = {10,9,8,7,6,5,4,3,2,1,0};
		int[] second = {2,2,2,2,2};
		int[] third = {0,1,2,3,4,5,6,7,8,9,10};
		int[] fourth = {7,1,4,5,2,9};
		
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
	}

	@Test
	void Quicktest() {
		Sorting.QuickSort2(first);
		Sorting.QuickSort2(second);
		Sorting.QuickSort2(third);
		Sorting.QuickSort2(fourth);
		
		int[] expected1 = {0,1,2,3,4,5,6,7,8,9,10};
		assertArrayEquals(expected1, first);
		
		int[] expected2 = {2,2,2,2,2};
		assertArrayEquals(expected2, second);
		
		assertArrayEquals(first, third);
		
		int[] expected4 = {1,2,4,5,7,9};
		assertArrayEquals(expected4, fourth);
		
		
	}
	
	@Test
	void Mergetest() {
		Sorting.MergeSort(first);
		Sorting.MergeSort(second);
		Sorting.MergeSort(third);
		Sorting.MergeSort(fourth);
		
		int[] expected1 = {0,1,2,3,4,5,6,7,8,9,10};
		assertArrayEquals(expected1, first);
		
		int[] expected2 = {2,2,2,2,2};
		assertArrayEquals(expected2, second);
		
		assertArrayEquals(first, third);
		
		int[] expected4 = {1,2,4,5,7,9};
		assertArrayEquals(expected4, fourth);
	}
	
	@Test
	void Combtest() {
		Sorting.CombSort(first);
		Sorting.CombSort(second);
		Sorting.CombSort(third);
		Sorting.CombSort(fourth);
		
		int[] expected1 = {0,1,2,3,4,5,6,7,8,9,10};
		assertArrayEquals(expected1, first);
		
		int[] expected2 = {2,2,2,2,2};
		assertArrayEquals(expected2, second);
		
		assertArrayEquals(first, third);
		
		int[] expected4 = {1,2,4,5,7,9};
		assertArrayEquals(expected4, fourth);
	}

}
