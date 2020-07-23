package Array;
import java.util.*;
public class LongestValidParentheses {
    public int longestValidParentheses(String input) {
      if (input == null) {
        return 0;
      }
      char[] chars = input.toCharArray();
      int global = 0;
      for (int i = 0; i < chars.length; i++) {     
        if (chars[i] == '(') {
          int end = valid(chars, i);
          global = Math.max(global, end - i);
        }             
      }
      return global;
    }
    private int valid(char[] chars, int start) {
      int end = start; // [start, end) is the valid parenthese, 
      Deque<Character> stack = new ArrayDeque<>();
      while (end < chars.length) {    
        if (chars[end] == ')') {
          if (stack.isEmpty()) {
            return end;
          }
          stack.pollFirst();
          end++;
        } else {
          stack.offerFirst('(');
          end++;
        }
      }
      if (stack.isEmpty()) {
        return end;
      } else {
        return start;
      }
    }
  }
  