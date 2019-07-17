package Drzewo;

import java.util.ArrayList;
import java.util.HashSet;

import Przechodzenie.Pch³a;


public class Tree {

	//------
	
	private Leaf root = null;
	private HashSet<Integer> keys;
	private ArrayList<Pch³a> pchly;
	
	//------Konstruktory
	
	public Tree() {
		keys = new HashSet<Integer>();
		pchly = new ArrayList<Pch³a>();
	}
	
	public Tree(Leaf root) {
		keys = new HashSet<Integer>();
		pchly = new ArrayList<Pch³a>();
		this.root = root;
		keys.add(root.getKey());
	}
	
	//------Metody z listy
	
	public void Insert(int x) {
		if(keys.add(x)) {
			Leaf newLeaf = new Leaf(x);
			
			for(Pch³a p: pchly) {
				p.kill();
			}
			
			if(root == null) {
				root = newLeaf;
			}
			else {				
				InsertX(root,newLeaf);
			}
		}
	}
	
	private void InsertX(Leaf obecny, Leaf newLeaf) {
		if(newLeaf.getKey()<obecny.getKey()) {
			if(obecny.getLeft()==null) {
				obecny.setLeft(newLeaf);
				newLeaf.setParent(obecny);
			}
			else {
				InsertX(obecny.getLeft(),newLeaf);
			}
		}
		else {
			if(obecny.getRight()==null) {
				obecny.setRight(newLeaf);
				newLeaf.setParent(obecny);
			}
			else {
				InsertX(obecny.getRight(),newLeaf);
			}
		}
	}
	
	public boolean Delete(int x) {
		if(!keys.contains(x)) {
			return false;
		}
		else {
			
			for(Pch³a p: pchly) {
				p.kill();
			}
			
			if(root.getKey()==x) {
				if(root.getLeft()==null && root.getRight()==null) {
					root = null;
				}
				else if(root.getLeft()==null && root.getRight()!=null) {
					root.getRight().setParent(null);
					root = root.getRight();
				}
				else if(root.getLeft()!=null && root.getRight()==null) {
					root.getLeft().setParent(null);
					root = root.getLeft();
				}
				else {
					Leaf newNode = root.getRight().returnMinLeaf();
					
					if(newNode.getKey()==root.getRight().getKey()) {
						newNode.setLeft(root.getLeft());
						root.getLeft().setParent(newNode);
						newNode.setParent(null);
						root = newNode;
					}
					else {
						newNode.getParent().setLeft(null);
						if(newNode.getRight()!=null) {
							newNode.getParent().setLeft(newNode.getRight());
							newNode.getRight().setParent(newNode.getParent());
						}
						newNode.setParent(null);
						newNode.setLeft(root.getLeft());
						root.getLeft().setParent(newNode);
						newNode.setRight(root.getRight());
						root.getRight().setParent(newNode);
						root = newNode;
					}
				}
			}
			
			else if(x<root.getKey()) {
				DeleteX(root.getLeft(),x);
			}
			else
				DeleteX(root.getRight(),x);
			
			keys.remove(x);
			return true;
		}
	}
	
	private void DeleteX(Leaf obecny,int x) {
		if(x<obecny.getKey()) {
			DeleteX(obecny.getLeft(),x);
		}
		else if(x>obecny.getKey()) {
			DeleteX(obecny.getRight(),x);
		}
		else {
			if(obecny.getLeft()==null && obecny.getRight()==null) {
				if(x>obecny.getParent().getKey()) {
					obecny.getParent().setRight(null);
				}
				else
					obecny.getParent().setLeft(null);
			}
			else if(obecny.getLeft()==null && obecny.getRight()!=null) {
				obecny.getRight().setParent(obecny.getParent());
				if(x>obecny.getParent().getKey()) {
					obecny.getParent().setRight(obecny.getRight());
				}
				else
					obecny.getParent().setLeft(obecny.getRight());
			}
			else if(obecny.getLeft()!=null && obecny.getRight()==null) {
				obecny.getLeft().setParent(obecny.getParent());
				if(x>obecny.getParent().getKey()) {
					obecny.getParent().setRight(obecny.getLeft());
				}
				else
					obecny.getParent().setLeft(obecny.getLeft());
			}
			else {
				Leaf newNode = obecny.getRight().returnMinLeaf();
				
				if(newNode.getKey()==obecny.getRight().getKey()) {
					newNode.setLeft(obecny.getLeft());
					obecny.getLeft().setParent(newNode);
					newNode.setParent(obecny.getParent());
					if(x>obecny.getParent().getKey()) {
						obecny.getParent().setRight(newNode);
					}
					else {
						obecny.getParent().setLeft(newNode);
					}
				}
				else {
					newNode.getParent().setLeft(null);
					if(newNode.getRight()!=null) {
						newNode.getParent().setLeft(newNode.getRight());
						newNode.getRight().setParent(newNode.getParent());
					}
					newNode.setParent(obecny.getParent());
					if(x>obecny.getParent().getKey()) {
						obecny.getParent().setRight(newNode);
					}
					else {
						obecny.getParent().setLeft(newNode);
					}
					newNode.setLeft(obecny.getLeft());
					newNode.setRight(obecny.getRight());
					obecny.getLeft().setParent(newNode);
					obecny.getRight().setParent(newNode);
				}
			}
		}
	}
	
	public int Upper(int x) throws EmptyTreeException {
		if(root == null) {
			throw new EmptyTreeException();
		}
		int returned = UpperX(root, x, Integer.MAX_VALUE);
		if(returned == Integer.MAX_VALUE)
			throw new IllegalArgumentException("x w funkcji Upper by³ za du¿y!");
		return returned;
	}
	
	private int UpperX(Leaf obecny, int x, int up) {
		int newUp = up;
		if(obecny.getKey()==x)
			return x;
		else if(obecny.getKey()>x&&obecny.getKey()<up) {
			newUp = obecny.getKey();
		}
		
		if(x>obecny.getKey() && obecny.getRight()!=null) {
			return UpperX(obecny.getRight(),x,newUp);
		}
		else if(x<obecny.getKey() && obecny.getLeft()!=null) {
			return UpperX(obecny.getLeft(),x,newUp);
		}
		return newUp;
	}
	
	public int Lower(int x) throws EmptyTreeException {
		if(root == null) {
			throw new EmptyTreeException();
		}
		int returned = LowerX(root,x,Integer.MIN_VALUE);
		if(returned == Integer.MIN_VALUE)
			throw new IllegalArgumentException("x w funkcji Lower by³ za ma³y!");
		return returned;
	}
	
	private int LowerX(Leaf obecny, int x, int down) {
		int newDown = down;
		if(obecny.getKey()==x) {
			return x;
		}
		else if(obecny.getKey()>down && obecny.getKey()<x) {
			newDown = obecny.getKey();
		}
		
		if(x>obecny.getKey() && obecny.getRight()!=null) {
			return LowerX(obecny.getRight(),x,newDown);
		}
		else if(x<obecny.getKey() && obecny.getLeft()!=null) {
			return LowerX(obecny.getLeft(),x,newDown);
		}
		
		return newDown;
	}
	
	//------Metoda na potrzebe zabijania pche³
	
	public void addPchla(Pch³a p) {
		pchly.add(p);
	}
	
	//------Geter i Seter Korzenia
	
	public Leaf getRoot() {
		return root;
	}

	public void setRoot(Leaf root) {
		this.root = root;
	}
}
