package BFS;
import java.util.*;
public class NumberOfIsland {
    int rows;
    int cols;
    private class Cell {
      int x;
      int y;
      public Cell(int x, int y) {
        this.x = x;
        this.y = y;
      }
    }
    public int numIslands(char[][] grid) {
      if (grid == null || grid.length == 0 || grid[0].length == 0) {
        return 0;
      }
      // dfs
      rows = grid.length;
      cols = grid[0].length;
      boolean[][] visited = new boolean[rows][cols];
      int result = 0;
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          result += bfs(grid, i, j, visited);
        }
      }
      return result;
    }
    private int bfs(char[][] grid, int x, int y, boolean[][] visited) {
      if (grid[x][y] == '0' || visited[x][y] == true) {
        return 0;
      }
      Deque<Cell> queue = new ArrayDeque<>();
      // init
      queue.offer(new Cell(x, y));
      visited[x][y] = true;
      while (!queue.isEmpty()) {
        Cell cur = queue.poll();
        grid[cur.x][cur.y] = '0';
        if (cur.x + 1 < rows && grid[cur.x + 1][cur.y] != '0') {
          if (!visited[cur.x + 1][cur.y]) {
            queue.offer(new Cell(cur.x + 1, cur.y));
            visited[cur.x + 1][cur.y] = true;
          }
        }
        if (cur.y - 1 >= 0 && grid[cur.x][cur.y - 1] == '1') {
            if (!visited[cur.x][cur.y + 1]) {
              queue.offer(new Cell(cur.x, cur.y + 1));
              visited[cur.x][cur.y + 1] = true;
            }
          }
        if (cur.y + 1 < cols && grid[cur.x][cur.y + 1] == '1') {
          if (!visited[cur.x][cur.y + 1]) {
            queue.offer(new Cell(cur.x, cur.y + 1));
            visited[cur.x][cur.y + 1] = true;
          }
        }
      }
      return 1;
    }
    
  }