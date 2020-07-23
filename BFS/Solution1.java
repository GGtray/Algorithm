package BFS;
import java.util.*;
public class Solution1 {
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    // idea:
    // best first search
    // data structure: maxHeap, element {i in a, j in b, l in c}
    // initialization: (0, 0, 0)
    // expand: the top of maxHeap (i, j, k)
    // generate: (i + 1, j, k) (i, j + 1, k) (i, j, k + 1)
    // termination: pop k times
    // deduplication: one element can not be generated twice
    // thus use hashset to dedup generation 
    PriorityQueue<Element> minHeap = makeHeap(a, b, c); //TODO:
    Set<Element> visited = new HashSet<>();
    List<Integer> res = new ArrayList<>();
    // init:
    Element init = new Element(0, 0, 0);
    minHeap.offer(init);
    visited.add(init);
    res = Arrays.asList(0,0,0);
    while (k > 0) {
      // expand:
      Element cur = minHeap.poll();
      res = Arrays.asList(cur.i, cur.j, cur.l);
      // generate, (dedup):
      Element gen = new Element(cur.i + 1, cur.j, cur.l);
      if (cur.i < a.length - 1 && visited.add(gen)) {
        minHeap.offer(gen);
      }
      gen = new Element(cur.i, cur.j + 1, cur.l);
      if (cur.j < b.length - 1 && visited.add(gen)) {
        minHeap.offer(gen);
      }
      gen = new Element(cur.i, cur.j, cur.l + 1);
      if (cur.l < c.length - 1 && visited.add(gen)) {
        minHeap.offer(gen);
      }
      k--;
    }
    // replace:
    res.set(0, a[res.get(0)]);
    res.set(1, b[res.get(1)]);
    res.set(2, c[res.get(2)]);
    return res;
  }

  // TODO: makeHeap
  private PriorityQueue<Element> makeHeap(int[] a, int[] b, int[] c) { //
    return new PriorityQueue<Element>(new Comparator<Element>() {
      @Override
      public int compare(Element e1, Element e2) {
        // double l1 = Math.sqrt(a[e1.i]*a[e1.i] + b[e1.j]*b[e1.j] + c[e1.l]*c[e1.l]);
        // double l2 = Math.sqrt(a[e2.i]*a[e2.i] + b[e2.j]*b[e2.j] + c[e2.l]*c[e2.l]);
        double l1 = distance(a[e1.i], b[e1.j], c[e1.l]);
        double l2 = distance(a[e2.i], b[e2.j], c[e2.l]);
        if (l1 == l2) {
          return 0;
        }
        return l1 < l2 ? -1 : 1;
      }
    });
  }
  private double distance(int x, int y, int z) {
    double dist = 0;
    dist += Math.pow(x, 2);
    dist +=  Math.pow(y, 2);
    dist +=  Math.pow(z, 2);
    return dist;
  }
  private class Element {
    int i;
    int j;
    int l;
    public Element(int i, int j, int l) {
      this.i = i;
      this.j = j;
      this.l = l;
    }
  }
  // {1, 4 , 6}
  // {2, 5}
  // {1, 3}
  // [<1, 2, 1>, <4,2,1>, ]
}
