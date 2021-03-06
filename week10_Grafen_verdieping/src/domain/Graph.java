package domain;

import java.util.ArrayList;

public class Graph {
    private final int[][] verbindingsMatrix;

    public Graph(int[][] matrix) {
        /*if (!isGeldigeVerbindingsMatrix(matrix))
            throw new IllegalArgumentException("No valid verbindingsmatrix");*/

        this.verbindingsMatrix = matrix.clone();
    }

    private boolean isGeldigeVerbindingsMatrix(int[][] matrix) {
        if (matrix == null || matrix.length != matrix[0].length)
            return false;

        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][i] != 0)
                return false;

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                if (matrix[i][j] != 0 && matrix[i][j] != 1)
                    return false;
        return true;
    }

    public Integer isVergeetPut() {
        for (int i = 0; i < verbindingsMatrix.length; i++) {
            boolean vergeetPutGevonden = true;
            for (int j = 0; j < verbindingsMatrix.length; j++) {
                if (verbindingsMatrix[i][j] == 1) vergeetPutGevonden = false;
            }

            if (vergeetPutGevonden) return i;
        }

        return null;
    }

    private int getAantalKnopen() {
        return verbindingsMatrix.length;
    }

    public ArrayList<Double> verdeel(int i, double bedrag) {
        ArrayList<Double> verdeelt = new ArrayList<>();
        ArrayList<Integer> delers = new ArrayList<>();
        for (int j = 0; j < this.getAantalKnopen(); j++) {
            if (i == j) {
                verdeelt.add(bedrag);
                delers.add(i);
            } else {
                verdeelt.add(0.0);
            }
        }
        return verdeelHelper(verdeelt, delers);
    }

    private ArrayList<Double> verdeelHelper(ArrayList<Double> verdeelt, ArrayList<Integer> delers) {
        if (delers.size() == 0) {
            return verdeelt;
        } else {
            ArrayList<Integer> nieuweDelers = new ArrayList<>();
            for (int deler : delers) {
                int[] kinderen = this.verbindingsMatrix[deler];
                ArrayList<Integer> deelMetKinderen = new ArrayList<>();
                for (int j = 0; j < kinderen.length; j++) {
                    if (kinderen[j] == 1 && verdeelt.get(j) == 0.0) {
                        deelMetKinderen.add(j);
                    }
                }
                if (deelMetKinderen.size() != 0) {
                    double verdeelValue = verdeelt.get(deler) / 2;
                    verdeelt.set(deler, verdeelValue);
                    verdeelValue /= deelMetKinderen.size();
                    for (int kind : deelMetKinderen) {
                        verdeelt.set(kind, verdeelValue);
                        if (!nieuweDelers.contains(kind)) nieuweDelers.add(kind);
                    }
                }
            }
            return verdeelHelper(verdeelt, nieuweDelers);
        }
    }

    public boolean isBrug(int van, int naar) {
        if(!zijnVerbonden(van,naar)) return false;
        int[][] res = this.verbindingsMatrix;
        int count = 0;
        if (zijnVerbonden(van, naar)) {
            for (int i = 0; i < res.length; i++) {
                if ((verbindingsMatrix[van - 1][i] == 1 && verbindingsMatrix[naar - 1][i] == 1) ){
                    return false;
                }

            }
            for(int j = 0; j < res.length; j++){
                if(verbindingsMatrix[van-1][j] == 1 && j != naar-1){
                    for(int k = 0; k<res.length; k++){
                        if(verbindingsMatrix[naar-1][k] == 1 && k != van-1){
                            if(verbindingsMatrix[j][k] != 0){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public int aantalBruggen() {
        int[][] res = this.verbindingsMatrix;
        int count = 0;
        for (int i = 1; i < res.length; i++) {
            for (int j = i + 1; j <= res.length; j++) {
                if (isBrug(i, j)) count++;
            }
        }
        return count;
    }

    private boolean zijnVerbonden(int knoop1, int knoop2) {
        return this.verbindingsMatrix[knoop1-1][knoop2-1] == 1;
    }
}
