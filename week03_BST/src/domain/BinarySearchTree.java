package domain;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree) {
		super(data, leftTree, rightTree);
	}
			
	public BinarySearchTree(E data) {
		super(data);
	}

	public boolean lookup(E data) {
		if (data == null) {
			return false;
		}
		if (data.compareTo(this.data) == 0) {
			return true;
		} else {
			if (data.compareTo(this.data) < 0) {
				return (this.leftTree != null && this.leftTree.lookup(data));
			} else {
				return (this.rightTree != null && this.rightTree.lookup(data));
			}
		}
	}

	public boolean addNode(E data) {
		if (data == null) {
			throw new IllegalArgumentException();
		}
		if (data.compareTo(this.data) == 0) {
			return false;
		} else if (data.compareTo(this.data) < 0 ) {
			if (this.leftTree == null) {
				this.leftTree = new BinarySearchTree<E>(data);
				return true;
			}

			return this.leftTree.addNode(data);
		} else {
			if (this.rightTree == null) {
				this.rightTree = new BinarySearchTree<E>(data);
				return true;
			}

			return this.rightTree.addNode(data);
		}
	}

	public boolean removeNode(E data) {
		if (data == null) {
			throw new IllegalArgumentException("data is leeg");
		}
		if (this.data == null) {
			return false;
		}
		if (this.data.compareTo(data) == 0) {//data gevonden
			if (this.isLeaf()) {
				this.data = null;
				return true;
				// in dit geval blijft een leeg blaadje achter
				// clean kan dan enkel via gehele boom
			} else {
				if (this.leftTree != null) {//linkerboom is niet leeg
					E grootsteLinks = this.leftTree.searchGreatest();
					this.data = grootsteLinks;
					boolean verwijderenGelukt = this.leftTree.removeNode(grootsteLinks);
					if (verwijderenGelukt) {
						this.leftTree.cleanUp();
					}
					return verwijderenGelukt;
				} else {//rechterboom is niet leeg
					E kleinsteRechts = this.rightTree.searchGreatest();
					this.data = kleinsteRechts;
					boolean verwijderenGelukt = this.rightTree.removeNode(kleinsteRechts);
					if (verwijderenGelukt) {
						this.rightTree.cleanUp();
					}
					return verwijderenGelukt;
				}
			}
		}

		else {
			if (this.data.compareTo(data) > 0) {//zoek in linkerboom
				return (this.leftTree == null ? false : this.leftTree.removeNode(data));
			} else {//zoek in rechterboom
				return (this.rightTree == null ? false : this.rightTree.removeNode(data));
			}
		}
	}

	public void cleanUp() {
		if (this.data != null) {
			if (this.leftTree != null) {
				if (this.leftTree.data == null) {
					this.leftTree = null;
				} else {
					this.leftTree.cleanUp();
				}
			}
			if (this.rightTree != null) {
				if (this.rightTree.data == null) {
					this.rightTree = null;
				} else {
					this.rightTree.cleanUp();
				}
			}
		}
	}

	public ArrayList<E> getPath(E data) {
		if (!lookup(data)) {//data komt niet voor in BST
			return null;
		}
		ArrayList<E> pad = new ArrayList<>();
		if (this.data.compareTo(data) == 0){
			pad.add(data);
			return pad;
		} else {
			pad.add(this.data);
			if (this.data.compareTo(data) > 0) {//ga links, data komt zeker voor!
				pad.addAll(this.leftTree.getPath(data));
			} else {// ga rechts, data zit daar gegarandeerd
				pad.addAll((this.rightTree.getPath(data)));
			}
		}
		return pad;
	}

	public E searchSmallest(){
		return (this.leftTree == null ? this.data : this.leftTree.searchSmallest());
	}

	public E searchGreatest(){
		return (this.rightTree == null ? this.data : this.rightTree.searchGreatest());
	}
}


