package DynamicProgramming;
public class Solution {
    public static void main(final String[] args) {
        // System.out.print(“ready”);
        // System.out.print('s');
        Solution s1 = new Solution();
        int[] stones= new int[]{4, 3, 3, 4};
        int res = s1.minCost(stones);
        // System.out.println(res);
    }

  private int minCost(final int[] stones) {
    // Write your solution here
    // define dp[i][j]: the minimum cost to merge from i to j
    // dp[i][j] = min(dp[i][k] + dp[k][j] | k = ) + sum[i to j]
    final int n = stones.length;
    final int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      dp[i][i] = stones[i];
    }

    for (int i = 0; i < n - 1; i++) {
      dp[i][i + 1] = stones[i] + stones[i + 1];
    }
    final int[] prefix = new int[n];
    prefix[0] = stones[0];
    for (int i = 1; i < n - 1; i++) {
      prefix[i] = prefix[i - 1] + stones[i];
    }

    for (int i = 0; i < n - 1; i++) {
      for (int j = i; j <= n - 1; j++) {
        dp[i][j] = 10;
        for (int k = i; k < j; k++) {
          dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + prefix[j] - prefix[i] + stones[i]);
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <n ; j++) {
        System.out.print(dp[i][j]);
      }
      System.out.println();
    }

    return dp[1][n - 2];
  }
  // 4  7  0  0
  // 0 10 10 10
  // 0  0 10  7
  // 0  0  0  4
}
