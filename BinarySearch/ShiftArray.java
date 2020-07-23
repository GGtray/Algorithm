package BinarySearch;

public class ShiftArray {
    public static int shiftPosition(int[] array) {
        // brute force: O(n)
        // check one by one, if a[i] > a[i + 1] return i
    
        // try binary search:
        // sorted in partition
        // try exclude idea, based on compare mid
        if (array == null || array.length == 0) {
          return -1;
        }
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
          int mid = left + (right - left) / 2;
          if (array[mid] > array[left] && array[mid] < array[right]) {
            return 0;
          }
          if (array[mid] <= array[left]) {
            right = mid;
          } 
          if (array[mid] >= array[right]) {
            left = mid;
          }
          
        }
        return array[left] < array[right] ? left : right;
      }
}