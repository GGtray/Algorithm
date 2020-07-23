package DFS;
import java.util.*;
public class Combination {
    public List<List<Integer>> combine(int n, int k) {
      // dfs
      // recursion tree
      //               [1, 2, 3]
      //            /     |          \
      //        [1]       [2]       [3]
      //       / | \      / | \       / | \  
      // .   [12] [13]  [21] [22][23] [31] [32][33]
      // layer: choose the layer-th integer 
      // branch i: the layer-th, is the i-th in [1,2,3]
      // dedup: use hashset <sorted list> 
  
      // dfs parameter:
      // constant: n
      // buffer & result: list, list of list
      // layer & pruning: layer, hashset
  
      // base case: return when buffer size == k, sorted res.add if set.add(buffer)
      // at layer layer: 
      // for i = 1 to n, 
      // .in   buffer add, i
      // out buffer remove
      List<Integer> buffer = new ArrayList<>();
      List<List<Integer>> res = new ArrayList<>();
      Set<List<Integer>> set = new HashSet<>();
      dfs(n, k, 0, set, buffer, res);
      return res;
    }
    private void dfs(int n, int k, int lyr, Set<List<Integer>> set, List<Integer> buffer, List<List<Integer>> res) {
      // base case
      if (buffer.size() >= k) {
        List<Integer> sol = new ArrayList<>(buffer);
        Collections.sort(sol);
        if (set.add(sol)) {
          res.add(sol);
        }
        return;
      }
      // 
      for (int i = lyr + 1; i <= n; i++) {
          
        buffer.add(i);
        dfs(n, k, lyr + 1, set, buffer, res);
        buffer.remove(buffer.size() - 1);
      }
    }
  }