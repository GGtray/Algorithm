package Knary;
public class Run {
    public static void main(String[] args) {
        MergeArray m1 = new MergeArray();
        int[][] a = new int[2][];
        int[][] b = new int[][] {
            {3},
            {1,2,3,4,5}
        };
        int[] res = m1.merge(b);
    }
}