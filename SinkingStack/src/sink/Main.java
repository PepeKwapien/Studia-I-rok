package sink;

import lecture.EmptyStackException;

public class Main {

	public static void main(String[] args) throws EmptyStackException {
		// TODO Auto-generated method stub

		SinkingStack<Integer> ss = new SinkingStack<>(4);
		
		ss.push(1);
		ss.push(2);
		ss.push(3);
		ss.push(60);
		ss.push(7);
		ss.push(8);
		
		while(!ss.isEmpty()) {
			System.out.println(ss.pop());
		}
	}

}
