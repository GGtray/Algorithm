package DFS;
import java.util.*;

public class BillBord {
    int max = 0;
    private void dfs(int[] input, int level, int leftSum, int rightSum) {
        // base case
        if (level == input.length) {
            if (leftSum == rightSum) {
                max = Math.max(max, leftSum);
            }
            return;
        }
        // 3 branches, add left or right
        // add left
        dfs(input, level + 1, leftSum + input[level], rightSum);
        // add right
        dfs(input, level + 1, leftSum, rightSum + input[level]);
        dfs(input, level + 1, leftSum, rightSum);
        
        
    }
    public int findHighest(int[] input) {
        // corner case
        // assumption: no result return 0;
        if (input == null || input.length == 0) {
            return 0;	
        }
        // parameter:
        // constant: input 
        // level: index
        // cur & output: leftRods, rightRods
        dfs(input, 0, 0, 0);
        return max;
    }
}