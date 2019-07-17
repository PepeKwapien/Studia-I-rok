package test;

import sink.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lecture.EmptyStackException;

class SinkingStackTest {
	
	SinkingStack<Integer> sinking;
	

	@BeforeEach
	void setUp() throws Exception {
		sinking = new SinkingStack<>(4);
		sinking.push(1);
		sinking.push(2);
		sinking.push(3);
	}

	@Test
	void pop_pushTest() throws EmptyStackException {
		ArrayList<Integer> help = new ArrayList<Integer>();
		
		while(!sinking.isEmpty()) {
			help.add(sinking.pop());
		}
		
		for(Integer i: help) {
			sinking.push(i);
		}
		
		while(!sinking.isEmpty()) {
			help.add(sinking.pop());
		}
		
		assertIterableEquals(Arrays.asList(3, 2, 1, 1, 2, 3), help);
		
	}
	
	@Test
	void sinkingTest() throws EmptyStackException {
		ArrayList<Integer> help = new ArrayList<Integer>();
		
		sinking.push(4);
		sinking.push(5);
		sinking.push(6);
		
		while(!sinking.isEmpty()) {
			help.add(sinking.pop());
		}
		
		sinking.push(4);
		sinking.push(5);
		sinking.push(6);
		sinking.push(1);
		sinking.push(2);
		sinking.push(3);
		
		while(!sinking.isEmpty()) {
			help.add(sinking.pop());
		}
		
		assertIterableEquals(Arrays.asList(6, 5, 4, 3, 3, 2, 1, 6), help);
		
	}
	
	@Test
	void emptiness_fullnessTest() throws EmptyStackException {
		assertFalse(sinking.isEmpty());
		assertFalse(sinking.isFull());
		
		sinking.push(4);
		
		assertFalse(sinking.isEmpty());
		assertTrue(sinking.isFull());
		
		while(!sinking.isEmpty()) {
			sinking.pop();
		}
		
		assertTrue(sinking.isEmpty());
		assertFalse(sinking.isFull());
	}
	
	

}
