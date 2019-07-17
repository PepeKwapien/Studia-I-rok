package test;

import listInGeneral.*;
import person.*;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		MyOwnList<Person> list = new MyOwnList<Person>();
		
		Person p1 = new Person("Kowalski", 1);
		Person p2 = new Person("Nowak", 2);
		Person p3 = new Person("Kwapieñ", 3);
		Person p4 = new Person("Scene", 4);
		Person p5 = new Person("Olszewski", 5);
		Person p6 = new Person("Hazard", 6);
		
		list.add(p1);
		list.add(p2);
		list.add(0,p3);
		list.add(0,p4);
		list.add(p5);
		list.add(p6);
		
		Iterator<Person> itp = list.iterator();
		while(itp.hasNext()) {
			System.out.println(itp.next());
		}
		itp.remove();
		
		System.out.println("*********************************************************************************");
		
		for(Person p: list) {
			System.out.println(p);
		}
		
		
		System.out.println("*********************************************************************************");
		
		System.out.println(list.contains(p3));
		System.out.println(list.contains(p6));
		list.remove(1);
		System.out.println(list.contains(p3));
		
		System.out.println("*********************************************************************************");
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(3));
		
		System.out.println("*********************************************************************************");
		
		System.out.println(list.indexOf(p4));
		System.out.println(list.indexOf(p6)+"\n");
		
		list.set(0, p6);
		list.add(p4);
		
		System.out.println(list.indexOf(p4));
		System.out.println(list.indexOf(p6)+"\n");
		
		list.remove(4);
		list.add(0, new Person("Drogba", 7));
		
		System.out.println(list.indexOf(p4));
		System.out.println(list.indexOf(p6));
		
		System.out.println("*********************************************************************************");
		
		System.out.println(list.size());
		
		list.clear();
		
		System.out.println(list.size());
		
		list.add(p1);
		list.add(p6);
		
		System.out.println(list.size());
		
		
	}

}
