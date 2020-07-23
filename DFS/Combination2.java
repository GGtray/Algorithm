package DFS;
import java.util.*;
public class Combination2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> buffer = new ArrayList<>();
        dfs(n, k, 1, buffer, res);
        return res;
    }
    private void dfs(int n, int k, int index, List<Integer> buffer, List<List<Integer>> res) {
        if (buffer.size() == k) {
            
            res.add(new ArrayList<Integer>(buffer));
            // return;
        } 
        if (buffer.size() > k) {
            return;
        }
        for (int i = index; i <= n; i++) {
            buffer.add(i);
            dfs(n, k, index + 1, buffer, res);
            buffer.remove(buffer.size() - 1);
        }
    }
}