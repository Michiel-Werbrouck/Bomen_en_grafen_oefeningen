package domain;

import java.util.ArrayList;

public class BinaryTree<E>{
	E data;
	BinaryTree<E> leftTree, rightTree;
	
	public BinaryTree(E data){
		this(data,null,null);
	}
	
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
		if (data == null) {
			throw new IllegalArgumentException();
		}
		this.data= data;
		this.leftTree= leftTree;
		this.rightTree= rightTree;
	}
	
	public void printInorder(){
			if (this.leftTree != null) this.leftTree.printInorder();
			System.out.print(this.data + " ");
			if (this.rightTree != null) this.rightTree.printInorder();
	}

	public void printInorder(){
		if (this.leftTree != null) this.leftTree.printInorder();
		System.out.print(this.data + " ");
		if (this.rightTree != null) this.rightTree.printInorder();
	}

	public boolean isLeaf() {
		return (this.leftTree == null && this.rightTree == null);
	}

	public int count(E geg) {
		if (geg == null) {
			return 0;
		}
		return (this.data.equals(geg) ? 1 : 0)
				+ (this.leftTree != null ? this.leftTree.count(geg) : 0)
				+ (this.rightTree != null ? this.rightTree.count(geg) : 0);
	}

	public ArrayList<E> getNodesAtDistance(int k) {
		if (k < 0) {
			throw new IllegalArgumentException("Foute waarde voor afstand!");
		}
		ArrayList<E> res = new ArrayList<>();
		if (k == 0) {
			res.add(this.data);
		} else {
			if (this.leftTree != null) {
				res = this.leftTree.getNodesAtDistance(k - 1);
			}
			if (this.rightTree != null) {
				ArrayList<E> rechtsteLijst = this.rightTree.getNodesAtDistance(k - 1);
				res.addAll(rechtsteLijst);
			}
		}
		return res;
	}

	//*ONDERSTAANDE METHODES NIET IMPLEMENTEREN! DEZE MOETEN GEIMPLEMENTEERD WORDEN IN DE BinarySearchTree file!*//
	boolean lookup(E data) {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	boolean addNode(E data) {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	boolean removeNode(E data){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	E searchSmallest(){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	E searchGreatest(){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	void cleanUp() {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

}
