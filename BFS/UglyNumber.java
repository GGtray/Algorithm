package BFS;

import java.util.*;

public class UglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
      // best first search
      // data structure
      // class list
      // priorityqueue
      // set<Cell>
      // init
      // list(0, 0, 0, 0)
      // expand: cell, k--, if k == 0, out put the calculate(cur)
      // generate: cell.x + 1, cell.y + 1, cell.
      // not using cell, instead, using list
      List<Integer> cell = new ArrayList<>();
      for (int i = 0; i < primes.length; i++) {
        cell.add(0); // init
      }
      PriorityQueue<List<Integer>> minHeap = createPQ(primes);
      Set<List<Integer>> set = new HashSet<>();
      // init
      minHeap.offer(cell);
      set.add(cell);
      int res = 0;
      while (n >= 0 && !minHeap.isEmpty()) {
        // expand
        List<Integer> cur = minHeap.poll();
        n--;
        if (n == 0) {
          res = calcu(cur, primes);
        }
        // generate
        for (int i = 0; i < primes.length; i++) {
          List<Integer> neiCell = new ArrayList<>(cur);
          // neiCell.set(i, neiCell.get(i) + 1);
          int val = neiCell.get(i);
          neiCell.set(i, val++);
          if (set.add(neiCell)) {
            minHeap.offer(neiCell);
          }
        }
      }
      return res;
    }
    // createPQ
    private PriorityQueue<List<Integer>> createPQ(int[] primes) {
      PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>(){
        @Override
        public int compare(List<Integer> l1, List<Integer> l2) {
          int i1 = calcu(l1, primes);
          int i2 = calcu(l2, primes);
          if (i1 == i2) {
            return 0;
          }
          return i1 < i2 ? -1 : 1;
        }
      });
      return pq;
    }
    // calcu
    private int calcu(List<Integer> list, int[] primes) {
      int res = 1;
      for (int i = 0; i < primes.length; i++) {
        res *= Math.pow(primes[i], list.get(i));
      }
      return res;
    }
  }