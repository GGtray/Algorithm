package Queue;
import java.util.*;
public class Test1 {
    public static void main(String args[]) {
        Test1 t1 = new Test1();
        LinkedList<Integer> input = new LinkedList<>();
        input.add(4);
        input.add(3);
        input.add(2);
        input.add(1);
        t1.sort(input);
    }
    public void sort(LinkedList<Integer> s1) {
      LinkedList<Integer> s2 = new LinkedList<Integer>();
      // 这题的clarify就很重要。duduplicate, output sort way
      // data structure
      // s1 : input
      // s2 : buffer + output
      // idea : simulate selection sort: iterate for min, then deal with the rest, the
      // sorting of the rest cannot distribe the sorted part.
      // shuffle all elements in input to buffer, find current min
      // then put all back except equals currentMin or less then it untill s1 is empty 
      // process: shuffle until s1 is empty
      // moveTo： move all element in s1 to s2
      // moveBck: move all elements in s2 back to s1, reserve the element less than current min
      // [4, 2, 4]
      // [1, ] min = 1
      // 
      // copy s2 to s1
      while(!s1.isEmpty()) {
        int currentMin = moveTo(s1,s2);
        moveBack(s1,s2, currentMin);
      }
      copyBack(s1, s2);
      return;
    }
    private int moveTo(LinkedList<Integer> s1, LinkedList<Integer> s2) {
      int currentMin = s1.peek();
      
      while (!s1.isEmpty()) {
        // Integer element = s1.poll();
        // if (element < currentMin) {
        //   currentMin = element;
        // } else if (element == currentMin) {
        // }
        // s2.offer(element);
        currentMin = Math.min(currentMin, s1.peek());
        s2.offer(s1.poll());
      }
      return currentMin;
    }
    private void moveBack(LinkedList<Integer> s1, LinkedList<Integer> s2, int currentMin) {
      int count = 0;
      while (!s2.isEmpty() && s2.peek() >= currentMin) {
        Integer element = s2.poll();
        if (element == currentMin) {
          count++;
        } 
        if (element > currentMin) {
          s1.offer(element);
        }
      }
      for (int i = count; i >= 1; i--) {
        s2.offer(currentMin);
      }
    }
    private void copyBack(LinkedList<Integer> s1, LinkedList<Integer> s2) {
      while (!s2.isEmpty()) {
        s1.offer(s2.poll());
      }
    }
  }