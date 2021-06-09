package domain;

public class Graph {

    public Integer isVergeetPut(int[][] verbindingsMatrix) {
        for (int i = 0; i < verbindingsMatrix.length; i++) {
            boolean vergeetPutGevonden = true;
            for (int j = 0; j < verbindingsMatrix.length; j++) {
                if (verbindingsMatrix[i][j] == 1) vergeetPutGevonden = false;
            }

            if (vergeetPutGevonden) return i;
        }

        return null;
    }



}
