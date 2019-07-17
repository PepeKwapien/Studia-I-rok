package Drzewo;

public class Leaf {

	//-----
	
	private Leaf left = null;
	private Leaf right = null;
	private Leaf parent = null;
	private int key;
	
	//-----Konstruktory
	
	public Leaf(int k) {
		this.key = k;
	}
	
	/*
	public Leaf(int k, Leaf r) {
		this.key = k;
		this.parent = r;
	}
	*/

	//-----Getery i Setery
	
	public Leaf getLeft() {
		return left;
	}

	public void setLeft(Leaf left) {
		this.left = left;
	}

	public Leaf getRight() {
		return right;
	}

	public void setRight(Leaf right) {
		this.right = right;
	}

	public Leaf getParent() {
		return parent;
	}

	public void setParent(Leaf parent) {
		this.parent = parent;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	//-----Metoda do znajdowania najmniejszej wartoœci poczynaj¹c od obecnego liœcia
	
	public Leaf returnMinLeaf() {
		if(left == null) {
			return this;
		}
		else {
			return left.returnMinLeaf();
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+key;
	}
	
	
	
}
