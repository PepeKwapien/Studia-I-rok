package bit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("**");
		int tab[] = {0, 1, 1};
		BitAdding.showAsBinary(tab);
		BitAdding.addBit(tab);
		BitAdding.showAsBinary(tab);
		
		System.out.println("**");
		int tab1[] = {1, 1, 1, 1, 1, 1, 1, 0};
		BitAdding.showAsBinary(tab1);
		BitAdding.addBit(tab1);
		BitAdding.showAsBinary(tab1);
		System.out.println("**");
		
		int tab2[] = {1, 2, 1};
		BitAdding.showAsBinary(tab2);
		
		System.out.println("**");
		int tab3[] = {1, 1, 1};
		BitAdding.addBit(tab3);
		BitAdding.showAsBinary(tab3);
		System.out.println("**");
		
		 int[] tab4 = { 1, 1, 1};
		 BitAdding.showAsBinary(tab4);
		 BitAdding.substractBit(tab4);
		 BitAdding.showAsBinary(tab4);
		 System.out.println(BitAdding.returnDecimal(tab4));
		 System.out.println("**");
		 
		 int[] tab5 = {0, 0, 0};
		 BitAdding.showAsBinary(tab5);
		 BitAdding.substractBit(tab5);
		 BitAdding.showAsBinary(tab5);
		 System.out.println("**");
		 
		 int[] tab6 = {1, 2};
		 BitAdding.addBit(tab6);
		 System.out.println("**");
		 
		 int[] tab7 = {1,0,0,1};
		 System.out.println(BitAdding.returnDecimal(tab7));
	}

}
