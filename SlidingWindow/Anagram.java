package SlidingWindow;

import java.util.*;

public class Anagram {
    public List<Integer> allAnagrams(String sh, String lo) {

        List<Integer> res = new ArrayList<>();
        if (lo.length() == 0 || lo.length() < sh.length()) {
          return res;
        }
        // data structure 
        Map<Character, Integer> map = createMap(sh); // O(m), O(m)
        Map<Character, Integer> window = initWindow(map, lo, sh.length());
        // --------------------
        int match = matchIni(map, window);
        if (match == window.size()) {
            res.add(0);
        }
        int left = 0, right = sh.length();
        char[] array = lo.toCharArray();

        while (right < array.length - 1) {
          // right forward, window add a[right+1] 
          //edge case right + 1 == array.length
          if (map.containsKey(array[right + 1])) {
            Integer count = window.get(array[right + 1]);
            if (count == null) {
              window.put(array[right + 1], 1);
            } else {
              window.put(array[right + 1], count + 1);
            }
            if (map.get(array[right + 1]) == window.get(array[right + 1])) {
              match++;
            }
          } // else do nothing
          right++;
    
          // left forward, left++, map remove a[left]
          if (map.containsKey(array[left])) {
            Integer count = window.get(array[left]);
            if (count != null) {
              if (count > 1) {
                window.put(array[left], count - 1);
              } else {
                window.remove(array[left]);
              }
            }
            if (map.get(array[left]) == window.get(array[left])) {
              match--;
            } 
          } // else do nothing
          left++;
          // check, add
          if (match == window.size()) {
            res.add(left - 1); //edge case
          }
        }
        // --------------------
        return res;
        // O(n * m)
      }
      private Map<Character, Integer> createMap(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> map= new HashMap<>();
        for (char c : array) {
          Integer count = map.get(c);
          if (count == null) {
            map.put(c, 1);
          } else {
            map.put(c, count + 1);
          }
        }
        return map;
        // time: O(m), space: O(m)
      }
      private Map<Character, Integer> initWindow(Map<Character, Integer> map, String lo, int size) {
        Map<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < size; i++) {
          char c = lo.charAt(i);
          if (map.containsKey(c)) {
            Integer count = res.get(c);
            if (count == null) {
              res.put(c, 1);
            } else {
              res.put(c, count + 1);
            }
          }
          // else do nohting
        }
        return res;
      }
      private int matchIni(Map<Character, Integer> map, Map<Character, Integer> window) {
        // for (Character c : map.keySet()) {
    
        // }
        int match = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
          if (window.get(entry.getKey()) == entry.getValue()) {
            match++;
          } 
        }
        return match;
      }
}