package day19;

public class WeightedAdjacentMatrix {
    public String start;
    public String end;
    public int weight;

    public WeightedAdjacentMatrix() {
        this.start = null;
        this.end = null;
        this.weight = 0;
    }

    public WeightedAdjacentMatrix(String start, String end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
