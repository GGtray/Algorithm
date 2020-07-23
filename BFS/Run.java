package BFS;

import DFS.BillBord;

public class Run {
    public static void main(String[] args) {
        // Solution1 s1 = new Solution1();
        // // [[1,2,3],[2,4],[1,2],10]
        // int[] a = new int[]{1, 2, 3};
        // int[] b = new int[]{2, 4};
        // int[] c = new int[]{1, 2};
        // int k = 10;
        // s1.closest(a, b, c, k);
        // NumberOfIsland n1 = new NumberOfIsland();
        // char[][] input = new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        // n1.numIslands(input);
        BillBord b1 = new BillBord();
        int[] input = new int[]{1, 2, 3, 6};
        System.out.print(b1.findHighest(input));

    }
}