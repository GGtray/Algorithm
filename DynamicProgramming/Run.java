package DynamicProgramming;
public class Run {
    public static void main(String[] args) {
        int[][] input = new int[][]{{3,1,1,2},{2,0,0,2},{2,0,0,0},{1,1,0,0}};
        Match m1 = new Match();
        m1.largestSquareOfMatches(input);
    }
}