package day19;

public class AdjacentMatrix {
    /**
     * Initialize the adjacency matrix information
     */
    public final String[] node = {"v1", "v2", "v3", "v4", "v5", "v6", "v7", "v8", "v9", "v10", "v11"};
    public final int[][] matrix = {{0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
            {0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0}};
    public final int nudeNum = 11;
    public final int border = 22;
}
