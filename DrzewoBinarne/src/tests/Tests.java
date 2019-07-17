package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Drzewo.EmptyTreeException;
import Drzewo.Leaf;
import Drzewo.Tree;
import Przechodzenie.Pch³a;
import Przechodzenie.Pch³aIsDeadException;
import Przechodzenie.ReachedBorderOfTreeException;

class Tests {

	Tree tree = new Tree();
	ArrayList<Integer> ar = null;
	
	@BeforeEach
	void setUp() throws Exception {
		
		ar = new ArrayList<Integer>();
		
		tree.Insert(100);
		tree.Insert(90);
		tree.Insert(98);
		tree.Insert(77);
		tree.Insert(34);
		tree.Insert(80);
		tree.Insert(132);
		tree.Insert(117);
		tree.Insert(157);
		tree.Insert(200);
		tree.Insert(190);
	}

	@Test
	void preorderTest() throws Pch³aIsDeadException, ReachedBorderOfTreeException {
		Pch³a p = new Pch³a(1,tree);
		
		for(int i = 0; i<p.getSize();i++) {
			ar.add(p.next().getKey());
		}
		
		assertIterableEquals(Arrays.asList(100,90,77,34,80,98,132,117,157,200,190), ar);
	}
	
	@Test
	void postorderTest() throws Pch³aIsDeadException, ReachedBorderOfTreeException {
		Pch³a p = new Pch³a(2,tree);
		
		for(int i = 0; i<p.getSize();i++) {
			ar.add(p.next().getKey());
		}
		
		assertIterableEquals(Arrays.asList(34,80,77,98,90,117,190,200,157,132,100), ar);
	}
	
	@Test
	void inorderTest() throws Pch³aIsDeadException, ReachedBorderOfTreeException {
		Pch³a p = new Pch³a(3,tree);
		
		for(int i = 0; i<p.getSize();i++) {
			ar.add(p.next().getKey());
		}
		
		assertIterableEquals(Arrays.asList(34,77,80,90,98,100,117,132,157,190,200), ar);
	}
	
	@Test
	void insertTest() throws Pch³aIsDeadException, ReachedBorderOfTreeException {
		tree.Insert(1);
		tree.Insert(49);
		tree.Insert(140);
		tree.Insert(300);
		
		Pch³a p = new Pch³a(3,tree);
		
		for(int i = 0; i<p.getSize();i++) {
			ar.add(p.next().getKey());
		}
		
		assertIterableEquals(Arrays.asList(1,34,49,77,80,90,98,100,117,132,140,157,190,200,300), ar);
	}
	
	@Test
	void deleteTest() throws ReachedBorderOfTreeException, Pch³aIsDeadException {
		tree.Delete(200);
		tree.Delete(132);
		tree.Delete(98);
		tree.Delete(90);
		
		Pch³a p = new Pch³a(3,tree);
		
		for(int i = 0; i<p.getSize();i++) {
			ar.add(p.next().getKey());
		}
		
		assertIterableEquals(Arrays.asList(34,77,80,100,117,157,190), ar);
	}
	
	@Test
	void killingPch³aTest() throws Pch³aIsDeadException, ReachedBorderOfTreeException {
		Pch³a p1 = new Pch³a(1,tree);
		Pch³a p2 = new Pch³a(2,tree);
		Pch³a p3 = new Pch³a(3,tree);
		
		tree.Insert(13);
		tree.Delete(90);
		
		Pch³a p4 = new Pch³a(3,tree);
		
		assertTrue(p1.checkDead());
		assertTrue(p2.checkDead());
		assertTrue(p3.checkDead());
		assertTrue(!p4.checkDead());
		
		for(int i = 0; i<p4.getSize();i++) {
			ar.add(p4.next().getKey());
		}
		
		assertIterableEquals(Arrays.asList(13,34,77,80,98,100,117,132,157,190,200), ar);
	}
	
	@Test
	void previousTest() throws Pch³aIsDeadException, ReachedBorderOfTreeException {
		Pch³a p = new Pch³a(3,tree);
		for(int i = 0; i<p.getSize();i++) {
			p.next();
		}
		for(int i = p.getIndex();i>-1;i--) {
			ar.add(p.previous().getKey());
		}
		assertIterableEquals(Arrays.asList(200,190,157,132,117,100,98,90,80,77,34), ar);
	}
	
	@Test
	void lowerTest() throws EmptyTreeException {
		assertEquals(tree.Lower(210),200);
		assertEquals(tree.Lower(114),100);
		assertEquals(tree.Lower(89),80);
		assertEquals(tree.Lower(140),132);
		assertThrows(IllegalArgumentException.class, ()->{ tree.Lower(0); });
	}
	
	@Test
	void upperTest() throws EmptyTreeException {
		assertEquals(tree.Upper(30),34);
		assertEquals(tree.Upper(114),117);
		assertEquals(tree.Upper(89),90);
		assertEquals(tree.Upper(140),157);
		assertThrows(IllegalArgumentException.class, ()->{ tree.Upper(300); });
	}
	
	@Test
	void deleteNothingTest() {
		assertTrue(!tree.Delete(12));
	}
	
	@Test
	void emptyTreeTest() {
		Tree tree1 = new Tree();
		assertThrows(EmptyTreeException.class, ()-> { tree1.Upper(1); });
	}
	
	@Test
	void treeBorderTest() throws ReachedBorderOfTreeException, Pch³aIsDeadException {
		Tree tree1 = new Tree(new Leaf(2));
		Pch³a p = new Pch³a(1,tree1);
		
		assertThrows(ReachedBorderOfTreeException.class, ()-> { p.previous(); });
		p.next();
		assertThrows(ReachedBorderOfTreeException.class, ()-> { p.next(); });
	}
	
	@Test
	void zmienTrybTest() throws ReachedBorderOfTreeException, Pch³aIsDeadException {
		ArrayList<Integer> ar1 = new ArrayList<Integer>();
		ArrayList<Integer> ar2 = new ArrayList<Integer>();
		
		Pch³a p = new Pch³a(1,tree);
		for(int i = 0; i<p.getSize();i++) {
			ar.add(p.next().getKey());
		}
		assertIterableEquals(Arrays.asList(100,90,77,34,80,98,132,117,157,200,190), ar);
		
		p.zmienTryb(3);
		for(int i = 0; i<p.getSize();i++) {
			ar1.add(p.next().getKey());
		}
		assertIterableEquals(Arrays.asList(34,77,80,90,98,100,117,132,157,190,200), ar1);
		
		p.zmienTryb(2);
		for(int i = 0; i<p.getSize();i++) {
			ar2.add(p.next().getKey());
		}
		assertIterableEquals(Arrays.asList(34,80,77,98,90,117,190,200,157,132,100), ar2);
	}
	
	@Test
	void deleteRootTest() throws Pch³aIsDeadException, ReachedBorderOfTreeException {
		tree.Delete(100);
		tree.Delete(117);
		
		Pch³a p = new Pch³a(3,tree);
		
		for(int i = 0; i<p.getSize();i++) {
			ar.add(p.next().getKey());
		}
		
		assertIterableEquals(Arrays.asList(34,77,80,90,98,132,157,190,200), ar);
	}
	
	@Test
	void deleteAndInsert() throws Pch³aIsDeadException, ReachedBorderOfTreeException {
		tree.Delete(190);
		tree.Insert(190);
		
		Pch³a p = new Pch³a(1,tree);
		
		for(int i = 0; i<p.getSize();i++) {
			ar.add(p.next().getKey());
		}
		
		assertIterableEquals(Arrays.asList(100,90,77,34,80,98,132,117,157,200,190), ar);
	}
}
