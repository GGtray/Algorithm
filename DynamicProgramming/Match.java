package DynamicProgramming;
import java.util.*;

public class Match {
    //
    int rows;
    int cols;
    // res[i][j]: the vertical match from up, inclusive
    private int[][] countUp(int[][] matrix) {
      int[][] res = new int[rows][cols];
      for (int j = 0; j < cols; j++) {
        for (int i = 0; i < rows; i++) {
          // edge case
          if (i == 0) {
            res[i][j] = 0;
            continue;
          }
          if (matrix[i - 1][j] == 1 || matrix[i - 1][j] == 0) {
            res[i][j] = 0;
          } else {
            res[i][j] = res[i - 1][j] + 1;
          }
        }
      }
      return res;
    }
    // res[i][j]: the horizon match from left, inclusive
    private int[][] countLeft(int[][] matrix) {
      int[][] res = new int[rows][cols];
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols;j ++) {
          // edge case
          if (j == 0) {
            res[i][j] = 0;
            continue;
          }
          if (matrix[i][j - 1] == 2 || matrix[i][j - 1] == 0) {
            res[i][j] = 0;
          } else {
            res[i][j] = res[i][j - 1] + 1;
          }
        }
      }
      return res;
    }
    public int largestSquareOfMatches(int[][] matrix) {
      rows = matrix.length;
      cols = matrix[0].length;
      if (rows == 1) {
        return 0;
      }
      int[][] left = countLeft(matrix);
      int[][] up = countUp(matrix);
      int max = 0;
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          if (matrix[i][j] == 3) {
            for (int len = 0; i + len < rows && j + len < cols; len++) {
            if (left[i][j + len] >= len + 1 // up is all vertical matches
            && left[i + len][j + len] >= len + 1 // down is all vertical matches
            && up[i + len][j] >= len + 1 // left is all vertical matches
            && up[i + len][j + len] >= len + 1) {
              // update the max
              max = Math.max(max, len + 1);
            }
          } 
          }
          
        }
      }
      return max;
  
    }
    // {3,1,1,2},
    // {2,0,0,2},
    // {2,0,0,0},
    // {1,1,0,0}
  }