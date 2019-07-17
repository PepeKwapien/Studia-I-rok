package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import onp.ONP;
import onp.ZlaNotacjaException;

class ONPTest {

	@Test
	void adding() throws ArithmeticException, ZlaNotacjaException {
		String s = "1 2 3 4 5 5 4 3 2 1 + + + + + + + + +";
		
		assertEquals(30, ONP.analyzeExpression(s));
	}
	
	@Test
	void dividing() throws ArithmeticException, ZlaNotacjaException {
		String s1 = "64 8 / 2 / 4 /";
		String s2 = "2 0 /";
		
		assertEquals(1, ONP.analyzeExpression(s1));
		assertThrows(ArithmeticException.class, ()->{ ONP.analyzeExpression(s2); } );
	}
	
	@Test
	void substraction() throws ArithmeticException, ZlaNotacjaException{
		String s = "7 5 3 1 -20 - - - -";
		
		assertEquals(-16, ONP.analyzeExpression(s));
	}
	
	@Test
	void multiplication() throws ArithmeticException, ZlaNotacjaException{
		String s = "2 3 4 5 * * *";
		String s1 = "2 3 * 4 * 5 *";
		
		assertEquals(120, ONP.analyzeExpression(s));
		assertEquals(ONP.analyzeExpression(s1), ONP.analyzeExpression(s));
	}
	
	@Test
	void exponentiation() throws ArithmeticException, ZlaNotacjaException {
		String s = "2 2 3 ^ ^ 2 -8 ^ *";
		
		assertEquals(1, ONP.analyzeExpression(s));
	}
	
	@Test
	void everything() throws ArithmeticException, ZlaNotacjaException {
		String s = "7 3 + 5 2 - 2 ^ * 10 / 2 ^";
		
		assertEquals(81, ONP.analyzeExpression(s));
	}
	
	@Test
	void syntax() {
		String s1 = "7 3 4 +";
		String s2 = "7 3 + 4";
		String s3 = "7 +";
		
		assertThrows(ZlaNotacjaException.class, ()->{ ONP.analyzeExpression(s1); } );
		assertThrows(ZlaNotacjaException.class, ()->{ ONP.analyzeExpression(s2); } );
		assertThrows(ZlaNotacjaException.class, ()->{ ONP.analyzeExpression(s3); } );
	}

}
