package vts;

import java.util.ArrayList;

import lecture.EmptyStackException;

public class Main {

	public static void main(String[] args) throws EmptyStackException, VTSException {
		// TODO Auto-generated method stub

		
		VTS<Integer> vel = new VTS<>(4);
		vel.push(1);
		vel.push(2);
		vel.push(3);
		vel.push(4);
		vel.push(5);
		
		while(!vel.isEmpty()) {
			System.out.println(vel.pop());
		}
		
		vel = new VTS<>(4);
		
		vel.push(1);
		vel.push(2);
		vel.push(3);
		
		ArrayList<Integer> list = new ArrayList<>();
		
		vel.cursorDown();
		vel.cursorDown();
		
		vel.push(4);
		
		vel.cursorDown();
		vel.cursorDown();
		vel.cursorDown();
		
		list.add(vel.pop());
		
		vel.cursorDown();
		vel.cursorDown();
		
		list.add(vel.pop());
		
		vel.cursorDown();
		
		list.add(vel.pop());
		
		System.out.println(list);
		
	}

}
