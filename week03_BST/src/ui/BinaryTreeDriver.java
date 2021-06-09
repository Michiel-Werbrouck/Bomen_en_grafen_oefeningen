package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {

    public static void main(String[] args) {
        //4.1 Boom
        BinaryTree<String> nodeA = new BinaryTree<>("A");
        BinaryTree<String> nodeE1 = new BinaryTree<>("E");
        BinaryTree<String> nodeE2 = new BinaryTree<>("E");
        BinaryTree<String> nodeE3 = new BinaryTree<>("E");
        BinaryTree<String> nodeE4 = new BinaryTree<>("E");

        BinaryTree<String> nodeC = new BinaryTree<>("C", null, nodeE1);
        BinaryTree<String> nodeH3 = new BinaryTree<>("H", nodeE3, null);

        BinaryTree<String> nodeH2 = new BinaryTree<>("H", nodeC, nodeE2);
        BinaryTree<String> nodeI = new BinaryTree<>("I", nodeH3, nodeE4);

        BinaryTree<String> nodeH1 = new BinaryTree<>("H", nodeA, nodeH2);
        BinaryTree<String> nodeG = new BinaryTree<>("G",null,nodeI);

        BinaryTree<String> root = new BinaryTree<>("A", nodeH1, nodeG);

        System.out.println(root.getNodesAtDistance(0));
        System.out.println(root.getNodesAtDistance(4));
    }
}
