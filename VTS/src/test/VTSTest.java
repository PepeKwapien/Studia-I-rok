package test;

import vts.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lecture.EmptyStackException;

class VTSTest {
	
	VTS<Integer> vel;

	@BeforeEach
	void setUp() throws Exception {
		vel = new VTS<>(4);
		vel.push(1);
		vel.push(2);
		vel.push(3);
	}

	@Test
	void cursorDown_Test() throws VTSException, EmptyStackException {
		ArrayList<Integer> list = new ArrayList<>();
		
		vel.cursorDown();
		vel.cursorDown();
		list.add(vel.peek());
		list.add(vel.pop());
		vel.cursorDown();
		list.add(vel.peek());
		list.add(vel.pop());
		list.add(vel.pop());
		
		assertIterableEquals(Arrays.asList(1, 3, 1, 2, 1), list);
	}
	
	@Test
	void push_popTest() throws VTSException, EmptyStackException {
		ArrayList<Integer> list = new ArrayList<>();
		
		vel.cursorDown();
		vel.cursorDown();
		
		vel.push(4);
		
		vel.cursorDown();
		vel.cursorDown();
		vel.cursorDown();
		
		list.add(vel.pop());
		
		vel.cursorDown();
		vel.cursorDown();
		
		list.add(vel.pop());
		
		vel.cursorDown();
		
		list.add(vel.pop());
		list.add(vel.top());
		list.add(vel.pop());
		
		assertIterableEquals(Arrays.asList(4, 3, 2, 1, 1), list);
	}
	
	@Test
	void cursorToTopTest() throws VTSException, EmptyStackException {
		
		vel.cursorDown();
		vel.cursorDown();
		
		vel.cursorToTop();
		
		vel.cursorDown();
		
		assertEquals(new Integer(2), vel.peek());
		
	}
	
	@Test
	void exceptionTest() throws EmptyStackException {
		vel.pop();
		vel.pop();
		
		assertThrows(VTSException.class, ()->{ vel.cursorDown(); } );
		
		vel.pop();
		
		assertThrows(EmptyStackException.class, ()->{ vel.pop(); } );
		assertThrows(EmptyStackException.class, ()->{ vel.cursorDown(); } );
	}
	
	@Test
	void push_peekTest() throws EmptyStackException {
		
		vel.pop();
		
		assertEquals(new Integer(2), vel.peek());
		
	}

}
