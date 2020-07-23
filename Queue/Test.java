package Queue;

import java.util.*;

class Test {
    public static void main(String[] args) {
        String input = "abc";
        deDup(input);
    }
    public static String deDup(String input) {
        // use stack check
        if (input == null || input.length() <= 1) {
          return input;
        }
    
        Deque<Character> stack = new ArrayDeque<>();
        char[] s = input.toCharArray();
        int i = 0;
        while (i < s.length) {
          char c = s[i];
          if (stack.size() > 0  && c == stack.peek()) {
            while (i < s.length && c == s[i]) {
              i++;
            }
            stack.pop();
          } else {
            stack.push(s[i]);
            i++;
          }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.poll());
        }
        return new String(res);
      }
      //  0123456
      // [aababab]
      //    i
      //| ba
}