package tests;

import Drzewo.Tree;
import Przechodzenie.Pch³a;
import Przechodzenie.Pch³aIsDeadException;
import Przechodzenie.ReachedBorderOfTreeException;

public class Main {

	public static void main(String[] args) throws Pch³aIsDeadException, ReachedBorderOfTreeException {
		// TODO Auto-generated method stub

		Tree tree = new Tree();
		
		
		tree.Insert(8);
		tree.Insert(4);
		tree.Insert(2);
		tree.Insert(6);
		tree.Insert(5);
		tree.Insert(13);
		tree.Insert(9);
		tree.Insert(10);
		tree.Insert(12);
		
		
		/*
		tree.Insert(40);
		tree.Insert(50);
		tree.Insert(30);
		tree.Insert(45);
		tree.Insert(90);
		tree.Insert(41);
		tree.Insert(49);
		*/

		
		Pch³a p = new Pch³a(1,tree);
		p.show();
		
		/*
		tree.Delete(9);
		
		p = new Pch³a(2,tree);
		System.out.println("*");
		p.show();
		*/
		/*
		tree.Delete(8);
		
		p = new Pch³a(1,tree);
		System.out.println("*");
		p.show();
		*/
	}

}
