package domain;

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
		if (this.data == null || data == null || !lookup(data)) return false;

		if (data.compareTo(this.data) == 0) {
			if (this.isLeaf()) {
				this.data = null;
				return true;
			} else if (this.leftTree != null) {
				E leftDat = this.leftTree.searchGreatest();
				this.data = leftDat;
				boolean deleted = this.leftTree.removeNode(leftDat);
				if (deleted) {
					this.leftTree.cleanUp();
				}
				return deleted;
			} else {
				E rightDat = this.rightTree.searchGreatest();
				this.data = rightDat;
				boolean deleted = this.rightTree.removeNode(rightDat);
				if (deleted) {
					this.rightTree.cleanUp();
				}
				return deleted;
			}
		}

		if (data.compareTo(this.data) < 0) {
			if (this.leftTree != null) return this.leftTree.removeNode(data);
		} else {
			if (this.rightTree != null) return this.rightTree.removeNode(data);
		}

		return false;
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


	public E searchSmallest(){
		//ONELINER
		return (this.leftTree == null ? this.data : this.leftTree.searchSmallest());
		//
		//NIEUWE
		/*if (this.leftTree == null) {
			return this.data;
		} else {
			return this.leftTree.searchSmallest();
		}*/

		//OUDE METHODE
		/*else if (this.leftTree.data.compareTo(this.data) < 0) {
			return this.leftTree.searchSmallest();
		} else {
			return this.data;
		}*/
	}

	public E searchGreatest(){
		//ONELINER
		return (this.rightTree == null ? this.data : this.rightTree.searchGreatest());

		//NIEUWE
		/*if (this.rightTree == null) {
			return this.data;
		} else {
			return this.rightTree.searchGreatest();
		}*/

		//OUDE METHODE
		/*else if (this.rightTree.data.compareTo(this.data) > 0) {
			return this.rightTree.searchGreatest();
		} else {
			return this.data;
		}*/
	}
}


