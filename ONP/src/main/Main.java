package main;

import onp.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] string = {"5 2 +", "12 2 3 4 * 10 5 / + * +", "5 2 3 + -", "64 8 / 2 / 4 /", "4 3 1 - 2 3 * ^ / ", 
				"4 5 * 3", "4 5 4 3 *", "4 5 b", "3 2 -", "2 2 2 * +"
		};
		
		for(String s: string) {
			try {
				System.out.println(ONP.analyzeExpression(s));
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
		}
	}

}
