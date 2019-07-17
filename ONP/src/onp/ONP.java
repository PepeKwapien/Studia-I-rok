package onp;

import java.util.Stack;
import java.lang.Exception;
import java.util.EmptyStackException;

public abstract class ONP {
	
	public static double analyzeExpression(String wyrazenie) throws ZlaNotacjaException, ArithmeticException {
		
		Stack<Double> stack = new Stack<>();
		
		String[] splitWyrazenie = wyrazenie.split("\\s+");
		
		
		for(int i = 0; i<splitWyrazenie.length; i++) {
			
			try {
				double push = Double.parseDouble(splitWyrazenie[i]);
				stack.push(push);
			}
			catch(NumberFormatException e) {
				
				try {
					
					Double operator_1 = stack.pop();
					Double operator_2 = stack.pop();
					
					switch(splitWyrazenie[i]) {
					case "+":
						stack.push(operator_1+operator_2);
						break;
					case "-":
						stack.push(operator_2-operator_1);
						break;
					case "*":
						stack.push(operator_1*operator_2);
						break;
					case "/":
						if(operator_1 == 0.0) {
							throw new ArithmeticException("Cannot divide by zero!");
						}
						else {
							stack.push(operator_2/operator_1);
							break;
						}
					case "^":
						stack.push(Math.pow(operator_2, operator_1));
	                    break;
					default:
						throw new ZlaNotacjaException("Next time use one of these: +,-,*,/,^!");
					}
				}
				catch(EmptyStackException ex) {
					throw new ZlaNotacjaException("Operator could not find enough arguments!");
				}	
			}
		}
		
		if(stack.size()!= 1) {
			throw new ZlaNotacjaException("Too many numbers!");
		}
		else {
			return stack.pop();
		}
		
	}
}
