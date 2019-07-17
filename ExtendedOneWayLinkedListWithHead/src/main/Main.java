package main;

import extended.*;

import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExtendedOneWayLinkedListWithHead<Person> list = new ExtendedOneWayLinkedListWithHead<Person>();
		
		Person p1 = new Person("Kowalski", 1);
		Person p2 = new Person("Nowak", 2);
		Person p3 = new Person("Kwapieñ", 3);
		Person p4 = new Person("Scene", 4);
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		ListIterator<Person> lii = list.listIterator();
		
		while(lii.hasNext()) {
			System.out.println(lii.next());
		}
		
		System.out.println("***");
		
		while(lii.hasPrevious()) {
			System.out.println(lii.previous());
		}
		
		System.out.println("***");
		
		while(lii.hasNext()) {
			System.out.println(lii.next());
			lii.add(p4);
			System.out.println(lii.previous());
			System.out.println(lii.next());
		}
		
		System.out.println("***");
		
		for(Person p: list) {
			System.out.println(p);
		}
		
		System.out.println("***");
		
		lii.remove();
		
		for(Person p: list) {
			System.out.println(p);
		}
		
		System.out.println("***");
		
		System.out.println(lii.nextIndex());
		
		while(lii.hasPrevious()) {
			lii.previous();
		}
		
		System.out.println(lii.nextIndex());
		System.out.println(lii.previousIndex());
		
		lii.next();
		
		System.out.println(lii.nextIndex());
		System.out.println(lii.previousIndex());
		
		lii.previous();
		
		System.out.println("***");
		
		lii.remove();
		
		for(Person p: list) {
			System.out.println(p);
		}
		
		System.out.println("***");
		
		lii.add(p3);
		
		for(Person p: list) {
			System.out.println(p);
		}
		
		
		//list.add(p4);
		//lii.next();
		
	}

}
