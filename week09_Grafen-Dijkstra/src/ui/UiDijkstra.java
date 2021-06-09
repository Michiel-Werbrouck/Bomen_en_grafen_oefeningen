package ui;

import domain.Graph;

public class UiDijkstra {

	public static void main(String[] args) {
		// voorbeeld uit de cursus met extra knoop 9. In deze knoop komt geen
		// enkele verbinding aan.
		int[][] gewichtenMatrix = {
				{ 0,8, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE },
				{ 8, 0, 4, 7, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
				{ Integer.MAX_VALUE, 4, 0, 6, 10, Integer.MAX_VALUE, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, 7, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 9, Integer.MAX_VALUE },
				{ 4, Integer.MAX_VALUE, 10, Integer.MAX_VALUE, 0, 6,3 },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 9, 6, 0, Integer.MAX_VALUE},
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3, 11, 0},
		};
		Graph g = new Graph(gewichtenMatrix);
		System.out.println(g.berekenPaden(1));
	}

}
