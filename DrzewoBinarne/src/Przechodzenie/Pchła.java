package Przechodzenie;

import java.util.ArrayList;

import Drzewo.Leaf;
import Drzewo.Tree;

public class Pch³a {
	
	//------
	
	private int tryb; //1 preorder, 2 postorder, 3 inorder
	private ArrayList<Leaf> ar;
	private int index = -1;
	private Tree tree = null;
	private boolean dead = false;

	//------Konstruktor
	
	public Pch³a(int tryb, Tree tree) {
		if(tryb<1||tryb>3)
			throw new IllegalArgumentException();
		this.tryb = tryb;
		this.tree = tree;
		ar = new ArrayList<Leaf>();
		tree.addPchla(this);
		if(tree.getRoot()!=null && tryb==1)
			PreorderX(tree.getRoot());
		if(tree.getRoot()!=null && tryb ==2)
			PostorderX(tree.getRoot());
		if(tree.getRoot()!=null && tryb ==3)
			InorderX(tree.getRoot());
	}
	
	//------Metody do "posortowania"
	
	private void PreorderX(Leaf l) {
		ar.add(l);
		if(l.getLeft()!=null) {
			PreorderX(l.getLeft());
		}
		if(l.getRight()!=null) {
			PreorderX(l.getRight());
		}
	}
	
	private void PostorderX(Leaf l) {
		if(l.getLeft()!=null)
			PostorderX(l.getLeft());
		if(l.getRight()!=null)
			PostorderX(l.getRight());
		ar.add(l);
	}
	
	private void InorderX(Leaf l) {
		if(l.getLeft()!=null) {
			InorderX(l.getLeft());
		}
		ar.add(l);
		if(l.getRight()!=null) {
			InorderX(l.getRight());
		}
	}
	
	//------Unieaktywnia pchle
	
	public void kill() {
		this.dead = true;
	}
	
	public boolean checkDead() {
		return dead;
	}
	
	//------Metody do przechodzenia
	
	public Leaf next() throws ReachedBorderOfTreeException, Pch³aIsDeadException {
		if(index==ar.size()-1)
			throw new ReachedBorderOfTreeException("Next element does not exist");
		if(dead)
			throw new Pch³aIsDeadException("Pch³a is dead!");
		return ar.get(++index);
	}
	
	public Leaf previous() throws ReachedBorderOfTreeException, Pch³aIsDeadException {
		if(index==-1) {
			throw new ReachedBorderOfTreeException("Previous element does not exist");
		}
		if(dead)
			throw new Pch³aIsDeadException("Pch³a is dead!");
		return ar.get(index--);
	}
	
	public void show() throws Pch³aIsDeadException {
		if(dead)
			throw new Pch³aIsDeadException("Pch³a is dead!");
		
		for(Leaf l:ar) {
			System.out.println(l);
		}
	}
	
	public int getSize() throws Pch³aIsDeadException {
		if(dead)
			throw new Pch³aIsDeadException("Pch³a is dead!");
		
		return ar.size();
	}
	
	public int getIndex() throws Pch³aIsDeadException {
		if(dead)
			throw new Pch³aIsDeadException("Pch³a is dead!");
		return index;
	}
	
	//------Zmiana metody przechodzenia
	
	public void zmienTryb(int tryb) {
		if(tryb<1||tryb>3)
			throw new IllegalArgumentException();
		this.tryb = tryb;
		index = -1;
		ar = new ArrayList<Leaf>();
		if(tree.getRoot()!=null && this.tryb==1)
			PreorderX(tree.getRoot());
		if(tree.getRoot()!=null && this.tryb ==2)
			PostorderX(tree.getRoot());
		if(tree.getRoot()!=null && this.tryb ==3)
			InorderX(tree.getRoot());
	}
}
