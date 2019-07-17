package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kopiec.Kopiec;
import kopiec.PustyKopiecException;

class Tests {
	
	Kopiec kopiec = new Kopiec();
	@BeforeEach
	void setUp() throws Exception {
		kopiec.Insert(6);
		kopiec.Insert(7);
		kopiec.Insert(20);
		kopiec.Insert(36);
	}

	@Test
	void MinimumTest() throws PustyKopiecException {
		assertEquals(kopiec.Minimum(),6);
	}
	
	@Test
	void ExtractMinimumTest() throws PustyKopiecException {
		kopiec.ExtractMinimum();
		assertEquals(kopiec.Minimum(),7);
	}
	
	@Test
	void InsertTest() throws PustyKopiecException {
		kopiec.Insert(18);
		kopiec.Insert(4);
		kopiec.Insert(5);
		assertEquals(kopiec.Minimum(),4);
	}
	
	@Test
	void UnionTest() throws PustyKopiecException {
		Kopiec temp = new Kopiec();
		temp.Insert(3);
		temp.Insert(17);
		temp.Insert(9);
		kopiec = kopiec.Union(temp, kopiec);
		assertEquals(kopiec.Minimum(),3);
	}
	
	@Test
	void DeleteTest() throws PustyKopiecException {
		Kopiec temp = new Kopiec();
		temp.Insert(3);
		temp.Insert(17);
		temp.Insert(9);
		kopiec = kopiec.Union(temp, kopiec);
		kopiec.Delete(3);
		assertEquals(kopiec.Minimum(),6);
	}
	
	@Test
	void DecreaseKeyTest() throws PustyKopiecException {
		kopiec.DecreaseKey(36, 1);
		assertEquals(kopiec.Minimum(),1);
	}

}
