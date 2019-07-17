package bit;



public abstract class BitAdding {
	
	public static void addBit(int[] tab) throws ArrayIndexOutOfBoundsException, ArithmeticException {
		
		if(tab.length == 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else if(tab[0] != 0 && tab[0] != 1) {
			throw new ArithmeticException();
		}
		else {
			if(tab[0] == 0) {
				tab[0] = 1;
			}
			else {
				tab[0] = 0;
				try {
					moveBitAdd(tab, 1);
				} catch (ArrayIndexOutOfBoundsException e) {
					// TODO Auto-generated catch block
					
				} catch (ArithmeticException e) {
					// TODO Auto-generated catch block
					System.out.println("Binary numbers:\n\tAm I a joke to you?");
				}
			}
		}
		
	}
	
	private static void moveBitAdd(int[] tab, int index) throws ArrayIndexOutOfBoundsException, ArithmeticException {
		
		if(index<0 || index>= tab.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else if(tab[index] != 0 && tab[index] != 1) {
			throw new ArithmeticException();
		}
		else {
			
			try {
				if(tab[index] == 0) {
					tab[index] = 1;
				}
				else if(tab[index] == 1) {
					tab[index] = 0;
					moveBitAdd(tab, ++index);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				
			} catch(ArithmeticException e) {
				System.out.println("Binary numbers:\n\tAm I a joke to you?");
			}
			
		}
		
	}
	
	public static void substractBit(int tab[]) throws ArrayIndexOutOfBoundsException, ArithmeticException {
		
		if(tab.length == 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else if(tab[0] != 0 && tab[0] != 1) {
			throw new ArithmeticException();
		}
		else {
			if(tab[0] == 1) {
				tab[0] = 0;
			}
			else {
				tab[0] = 1;
				moveBitSubstract(tab, 1);
			}
		}
		
	}
	
	private static void moveBitSubstract(int tab[], int index) throws ArrayIndexOutOfBoundsException, ArithmeticException {
		

		if(index<0 || index>= tab.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else if(tab[index] != 0 && tab[index] != 1) {
			throw new ArithmeticException();
		}
		else {
			try {
				if(tab[index] == 1) {
					tab[index] = 0;
				}
				else {
					tab[index] = 1;
					moveBitSubstract(tab, ++index);
				}
				
			} catch(ArrayIndexOutOfBoundsException e) {
				
			} catch(ArithmeticException e) {
				System.out.println("Binary numbers:\n\tAm I a joke to you?");
			}
		}
		
	}
	
	public static void showAsBinary(int tab[]) {
		System.out.print("[");
		for(int i = tab.length-1; i >= 0; i--) {
			if(tab[i] != 0 && tab[i] != 1) {
				System.out.print("|!->|"+tab[i]+"|<-!|");
			}
			else {
				System.out.print(tab[i]);
			}
		}
		System.out.println("]");
	}
	
	public static int returnDecimal(int tab[]) {
		int exponent = 1;
		int sum = 0;
		for(int i = 0;i < tab.length;i++) {
			if(tab[i] != 0 && tab[i] != 1) {
				throw new ArithmeticException();
			}
			else {
				sum += exponent*tab[i];
			}
			exponent *= 2;
		}
		
		return sum;
	}

}
