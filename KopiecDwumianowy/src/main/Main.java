package main;

import kopiec.Kopiec;
import kopiec.PustyKopiecException;

public class Main {

	public static void main(String[] args) throws PustyKopiecException {
		// TODO Auto-generated method stub
		Kopiec k1 = new Kopiec();
		k1.Insert(9);
		k1.Insert(8);
		k1.Insert(7);
		k1.Insert(19);
		k1.Insert(4);
		k1.Insert(6);
		k1.Insert(1);
		
		
		Kopiec k2 = new Kopiec();
		
		k2.Insert(21);
		k2.Insert(27);
		k2.Insert(20);
		k2.Insert(30);
		k2.Insert(5);
		k2.Insert(10);
		k2.Insert(3);
		
		Kopiec k3 = k1.Union(k1, k2);
		k3.Delete(20);
		
		System.out.println("");
	}

}
