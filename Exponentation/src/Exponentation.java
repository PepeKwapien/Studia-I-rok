
public class Exponentation {
	public static void Exponentation(double x, int k) {
		double result = 1;
		String binaryk;
		
		/*-------------------------------------------------------------------------------------------*/
		
		System.out.print(x+" podniesione do potêgi "+k+" wynosi: ");
		try {
			binaryk = Integer.toBinaryString(k);
			k = Integer.parseInt(binaryk);
		}
		catch(NumberFormatException e) {
			System.out.println("NumberFormatException: " + e.getMessage());
			return;
		}
		catch(Exception e) {
			System.out.println("Error");
			return;
		}
		
		/*-------------------------------------------------------------------------------------------*/
		if(x==1) {
			System.out.println("Wynik potêgowania 1 jest równy 1");
		}
		else {
		
		while(k!=0) {
			if((k%10)==1) {
				result*=x;
			}
			x*=x;
			k/=10;
		}
		System.out.println(result);
	}
		}
	
	public static void main(String[] args) {
		Exponentation(7,3);
		Exponentation(2,8);
	}
}
