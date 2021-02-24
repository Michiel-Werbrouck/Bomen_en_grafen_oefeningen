package ui;

import domain.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTreeDriver {

	public static void main(String[] args) {
		//2.1 Boom
		BinaryTree<String> nodeC = new BinaryTree<>("C");
		BinaryTree<String> nodeE = new BinaryTree<>("E");
		BinaryTree<String> nodeH = new BinaryTree<>("H");
		BinaryTree<String> nodeA = new BinaryTree<>("A");

		BinaryTree<String> nodeD = new BinaryTree<>("D", nodeC, nodeE);
		BinaryTree<String> nodeI = new BinaryTree<>("I",nodeH,null);

		BinaryTree<String> nodeB = new BinaryTree<>("B", nodeA, nodeD);
		BinaryTree<String> nodeG = new BinaryTree<>("G",null,nodeI);

		BinaryTree<String> root = new BinaryTree<>("F", nodeB, nodeG);

		System.out.println(root.contains("A"));

		//Oude Boom
		/*BinaryTree<String> nodeD = new BinaryTree<>("D");
		BinaryTree<String> nodeF = new BinaryTree<>("F");
		BinaryTree<String> nodeB = new BinaryTree<>("B");
		BinaryTree<String> nodeH = new BinaryTree<>("H");
		
		// knoop A heeft links D en rechts F
		BinaryTree<String> nodeA = new BinaryTree<>("A",nodeD, nodeF);
		// knoop E heeft links H
		BinaryTree<String> nodeE = new BinaryTree<>("E",nodeH,null);
		// knoop G heeft links E en rechts B
		BinaryTree<String> nodeG = new BinaryTree<>("G",nodeE, nodeB);
		
		// boom heeft root C en heeft links A en rechts G
		BinaryTree<String> boom = new BinaryTree<>("C",nodeA, nodeG);
		boom.printPreorder();*/
	}

}
