package DFS;
import java.util.*;
public class ValidParentheses {
    public List<String> validParentheses(int l, int m, int n) {
      // dfs
      // recursion tree:
      //          []
      //     /   | | |   | \
      //     (   ) < >  {   }
      // layer: in total at most 2 ( l + m + n), 
      // layer index: determine which buffer[index]
      // branches: all the possibility that buffer[index] take
      // branch j: which paranthese buffer[index] is
      // pruning: yes, use stack
      // how ? add ( < {, if stack is null for stack.peek == ) > }
      // add ) > } if 
      // parameter: 
      // constant: l, m, n
      // layer & pruning: index,  stack
      // buffer & res: sb, list<String> 
      // initialize: stack, index = 0, sb, list
      List<String> res = new ArrayList<>();
      Deque<Character> stack = new ArrayDeque<>();
      StringBuilder sb = new StringBuilder();
      int[] count = new int[6];
      dfs(l, m, n, 0, count, stack, sb, res);
      return res;
    }
    private void dfs(int l, int m, int n, int index, int[] count, Deque<Character> stack, StringBuilder sb, List<String> res) {
      // base case
      if (index == 2 * (l + m + n)) {
        res.add(sb.toString());
        return;
      }
      // ()
      if (count[0] < l) {
        stack.push('(');
        sb.append('(');
        count[0]++;
        dfs(l, m, n, index + 1, count, stack, sb, res);
        count[0]--;
        sb.deleteCharAt(sb.length() - 1);
        stack.pop();
      }
      if (!stack.isEmpty() && stack.peek() == '(') {
        stack.push(')');
        sb.append(')');
        count[1]++;
        dfs(l, m, n, index + 1, count, stack, sb, res);
        count[1]--;
        sb.deleteCharAt(sb.length() - 1);
        stack.pop();
      }
      // <>
      if (count[2] < m) {
        stack.push('<');
        sb.append('<');
        count[2]++;
        dfs(l, m, n, index + 1, count, stack, sb, res);
        count[2]--;
        sb.deleteCharAt(sb.length() - 1);
        stack.pop();
      }
      if (!stack.isEmpty() && stack.peek() == '<') {
        stack.push('>');
        sb.append('>');
        count[3]++;
        dfs(l, m, n, index + 1, count, stack, sb, res);
        count[3]--;
        sb.deleteCharAt(sb.length() - 1);
        stack.pop();
      }
      // {}
      if (count[4] < n) {
        stack.push('{');
        sb.append('{');
        count[4]++;
        dfs(l, m, n, index + 1, count, stack, sb, res);
        count[4]--;
        sb.deleteCharAt(sb.length() - 1);
        stack.pop();
      }
      if (!stack.isEmpty() && stack.peek() == '{') {
        stack.push('}');
        sb.append('}');
        count[4]++;
        dfs(l, m, n, index + 1, count, stack, sb, res);
        count[4]--;
        sb.deleteCharAt(sb.length() - 1);
        stack.pop();
      }
    }
  }
  