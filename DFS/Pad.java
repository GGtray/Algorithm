package DFS;
import java.util.*;
public class Pad {
    public String[] combinations(int number) {
      // based on dfs
      // find digits[] 
      int[] digits = findDigits(number);
      // dfs
      Map<Integer, String> map = createMap();
      List<String> res= new ArrayList<>();
      StringBuilder sb = new StringBuilder();
      dfs(digits, map, 0, sb, res);
      // list -> array, sorted, return
      String[] result = new String[res.size()];
      for (int i = 0; i < res.size(); i++) {
          result[i] = res.get(i);
      }
      Arrays.sort(result);
      return result;
    }
    // dfs
    // recursion tree:
    //          [23]
    //      /     |    \
    //2:    a     b .   c
    // .   /|\   /|\   /|\
    //3   d e f d e f d e f
    // layers index: choose the char correspond with number[index]
    // branch i: list[index].get(i)
    // pruning: no need
    private void dfs(int[] digits, Map<Integer, String> map, int lyr, StringBuilder sb, List<String> res) {
      // base case 
      if (lyr == digits.length) {
        // res.add(sb.toString());
        res.add(sb.toString());
        return;
      }
      if (digits[lyr] <= 1) {
          res.add(sb.toString());
          return;
      }
      String s = map.get(digits[lyr]);
      char[] array = s.toCharArray();
      for (int i = 0; i < array.length; i++) {
        sb.append(array[i]);
        dfs(digits, map, lyr + 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
    // parameter: 
    // constant: digits[], map<key = digits, value = list<char>
    // layer : lyr
    // buffer & res: sb, list
    // initialize: find digits, create map, lyr = 0, new sb, new list
    // base case: lyr == digits.length, add to res, return
    // branhes = map.get(lyr)
    // traverse over branches, for each branch i:
    // sb.append(branches[i])
    // edge case map to ""
  
    private Map<Integer, String> createMap() {
      Map<Integer, String> map = new HashMap<>();
      map.put(0, "");
      map.put(1, "");
      map.put(2, "abc");
      map.put(3, "def");
      map.put(4, "ghi");
      map.put(5, "jkl");
      map.put(6, "mno");
      map.put(7, "pqrs");
      map.put(8, "tuv");
      map.put(9, "wxyz");
      return map;
    }
  
    // find digits
    private int[] findDigits(int number) {
      List<Integer> digits = new ArrayList<>();
      // ex 231
      // 1 = 231 % 10, 
      // 231 / 10 = 23
      // 3 = 23 % 10
      while (number > 0) {
        digits.add(number % 10);
        number /= 10;
      }
      // to array, reverse 
      int[] res = new int[digits.size()];
      for (int i = 0; i < digits.size(); i++) {
        res[i] = digits.get(digits.size() - 1 - i);
      }
      return res;
    }
  }
  