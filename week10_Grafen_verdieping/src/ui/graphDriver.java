package ui;

import domain.Graph;

public class graphDriver {
    public static void main(String[] args) {
        int[][] testVerbindingsMatrix = {{0,1,1,0,0},{1,0,1,1,1},{0,0,1,0,0},{0,1,0,0,1},{0,0,0,0,0}};
        Graph graph = new Graph();
        System.out.println(graph.isVergeetPut(testVerbindingsMatrix));
    }
}
