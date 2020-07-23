package Array;
import java.util.*;

public class TwoSum {
    public List<List<Integer>> allPairs(int[] array, int target) {
        // return index, so can not sort
        // use hashmap: <value, list of index>
        // general idea: go over all elements, 
        // for a[i]
        // check target - a[i]: if not do nothing, if yes,
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> visited = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
          if (!visited.containsKey(array[i])) {
            visited.put(array[i], new ArrayList<Integer>(i));
          } else {
            visited.get(array[i]).add(i);
          }
        }
        for (int i = 0; i < array.length; i++) {
          if (visited.containsKey(target - array[i])) {
            List<Integer> list = visited.get(target - array[i]);
            // for (int j = 0; j < list.size(); j++) {
            //   res.add(Arrays.asList(i, list.get(j)));
            // }
            for (Integer index : list) {
              res.add(Arrays.asList(i, index));
            }
          }
        }
        return res;
      }
}