package week3.day19;

public class AdjacencyList {
    public static AdjacentMatrix matrix = new AdjacentMatrix();

    public static void main(String[] args) {
        for (int i = 0; i < matrix.matrix.length; i++) {
            System.out.print(matrix.node[i]);
            for (int j = 0; j < matrix.matrix[i].length; j++) {
                if (matrix.matrix[i][j] != 0) {
                    System.out.print(" -> " + matrix.node[j]);
                }
            }
            System.out.println();
        }
    }
}
