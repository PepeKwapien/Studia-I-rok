package main;

import java.util.ArrayList;
import java.util.Collections;

import lecture.OneWayLinkedListWithHead;

public class Test {

	public static void main(String[] args) {
		OneWayLinkedListWithHead<Integer> list = new OneWayLinkedListWithHead();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		
		list.show();
		System.out.println("------");
		
		list.reverse();
		list.add(69);
		list.show();
	}
}
