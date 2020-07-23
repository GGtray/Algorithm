package Knary;

import java.util.Arrays;

public class MergeArray {
    public int[] merge(int[][] arrayOfArrays) {
       // corner case 
      if (arrayOfArrays == null || arrayOfArrays.length == 0) {
        return new int[0];
      } 
  
      // int[] res = new int[arrayOfArrays.length * arrayOfArrays[0].length];
      return dq(arrayOfArrays, 0, arrayOfArrays.length - 1);
      // return res;
      // binary reduction
      // like merge sort
      // use a recursion alog
      // step 1: binary cut
      // step 2:
      // recursion left
      // recursion right
      // step 3:
      // merge left and righ
    }
    private int[] dq(int[][] arrayOfArrays, int left, int right) {
      // parameter:
      // constant: arrayOfArrays
      // layer control: left, right
      // res: new int[arrayOfArrays.length * arrayOfArrays[0].length]
  
      // base case: left == right. return
      if (left == right) {
        return Arrays.copyOf(arrayOfArrays[left], arrayOfArrays[left].length);
      }
  
      int mid = left + (right - left) / 2;
      int[] leftA = dq(arrayOfArrays, left, mid);
      int[] rightA = dq(arrayOfArrays, mid + 1, right);
      return merge(leftA, rightA);
      // get left done, 
      // get right done,
      // merge left with right
      // return 
    }
    private int[] merge(int[] left, int[] right) {
      int[] res = new int[left.length + right.length];
      // init
      int i = 0, j = 0, k = 0;
      // move smaller
      while (i < left.length && j < right.length) {
        if (left[i] <= right[j]) {
          res[k++] = left[i++];
        } else {
          res[k++] = right[j++];
        }
      }
      // remain
      while (i < left.length) {
        res[k++] = left[i++];
      } 
      while (j < right.length) {
        res[k++] = right[j++];
      }
      return res;
    }
  }
  