
public class Functions {
	
	/*-------------------------------------------------------------------------------------------*/
	
	public static double E_X(double x, double eps) {
		double Suma = 1;
		double W = 1;
		int k = 1;
		double xhelp = x;
		
		if(x<0) {
			xhelp*=(-1);
		}
		
		while(W>eps) {
			W*=xhelp;
			W/=k;
			Suma+=W;
			k++;
		}
		
		if(x<0) {
			return (1.0)/(Suma);
		}
		
		return Suma;
	}
	
	/*-------------------------------------------------------------------------------------------*/
	
	public static double Sin_X(double x, double eps) {
		int k = 1;
		double xhelp = x;
		
		if(x<0) {
			xhelp = (-1)*x;
		}
		
		double Suma = xhelp;
		double W = xhelp;
		
		while(W>eps) {
			W = W*xhelp*xhelp;
			W = W/(2*k*(2*k + 1));
			if((k%2)==0) {
				Suma+=W;
			}
			else {
				Suma-=W;
			}
			k++;
		}
		if(x<0) {
			return (-1)*Suma;
		}
		return Suma;
	}
	
	/*-------------------------------------------------------------------------------------------*/
	
	public static double Cos_X(double x, double eps) {
		double Suma = 1;
		double W = 1;
		int k = 1;
		double xhelp = x;
		
		if(x<0) {
			xhelp = -x;
		}
		
		while(W>eps) {
			W = W*xhelp*xhelp;
			W = W/(2*k*(2*k - 1));
			if((k%2)==0) {
				Suma+=W;
			}
			else {
				Suma-=W;
			}
			k++;
		}
		
		return Suma;
	}
	
	/*-------------------------------------------------------------------------------------------*/
	
	public static void main(String[] args) {
		double x = 3.14;
		double eps = 0.00001;
		System.out.println(x+" | e^x: "+E_X(x,eps)+" | sin(x): "+Sin_X(x,eps)+" | cos(x): "+Cos_X(x,eps)+" |");
		System.out.println(x+" | e^x: "+Math.exp(x)+" | sin(x): "+Math.sin(x)+" | cos(x): "+Math.cos(x)+" |");
	}
}
