package DFS;
import java.util.*;


public class Factor {
    public List<List<Integer>> combinations(int target) {
      // find all factor
      if (target <= 0) {
        return new ArrayList<List<Integer>>();
      }
      List<Integer> factors = findFactor(target);
      List<Integer> cur =new ArrayList<>();
      List<List<Integer>> res = new ArrayList<>();
      Set<List<Integer>> set = new HashSet<>();
      dfs(target, factors, 0, 1, cur, res, set);
      return res;
    }
    private void dfs(int target, List<Integer> factors, int index, int prefixProduct, List<Integer> cur,
    List<List<Integer>> res, Set<List<Integer>> set) {
      // base case:
      if (prefixProduct >= target) {
        if (prefixProduct == target) {
            List<Integer> sol = new ArrayList<>(cur);
            Collections.sort(sol);
            if (set.add(sol)) {
                res.add(sol);
            }
          
        } 
        return;
      }
  
      // 
      for (int i = 0; i < factors.size(); i++) {
        cur.add(factors.get(i));
        dfs(target, factors, index + 1, prefixProduct * factors.get(i), cur, res, set);
        cur.remove(cur.size() - 1);
      }
    }
    // 
    private List<Integer> findFactor(int target) {
      List<Integer> res = new ArrayList<>();
      for (int i = 2; i * 2 <= target; i++) {
        if (target % i == 0) {
          res.add(i);
        } 
      }
      return res;
    }
  }
  