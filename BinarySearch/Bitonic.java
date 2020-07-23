package BinarySearch;
import java.util.*;

public class Bitonic {
    public int findBitonic(int[] array) {
        int left = 0, right = array.length - 1; // exists in [left, right]
        while (left < right - 1) {
          // case 1: found
          int mid = left + (right - left) / 2;
          if (array[mid] <= array[mid + 1] && array[mid] >= array[mid - 1]) {
            return mid;
          } else if (array[mid] > array[mid - 1] && array[mid] < array[mid + 1]) {
            left = mid;
          } else {
            right = mid;
          }
        }
        return left > right ? left : right;
        //  0 1 2 3 4  5 6
        // -2,0,6,7,8,10,1
        //          l
        //               r
        //            m
      }
}