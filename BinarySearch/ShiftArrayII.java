package BinarySearch;

public class ShiftArrayII {
    private int findShift(int[] array) {
      // data structure: [left, right] represents search space
      // shifted point must exists within this range
      // algorithm: 
      // bisect, compare with the left and right,
      // left >= right, if left < right, then return left edge case
      // case 1: a[mid] > a[left], on rising track, the shift point is right side
      // case 2: a[mid] < a[right], shift point is on left side
      // case 3: a[mid] = a[left] = a[right]. search right ?
      // case 4: a[mid] < left, a[mid] > right
      int left = 0, right = array.length - 1;
  
      if (array[left] < array[right]) {
        return 0;
      }
      while (left < right - 1) {
        int mid = left + (right - left) / 2;
        if (array[mid] >= array[left]) {
          left = mid;
        } else {
          right = mid;
        }
      }
      return array[left] <= array[right] ? left : right;
      // if (array[left] < array[left - 1] && array[left + 1] > array[left]) {
      //   // [3 1 1]
      //   //  l
      //   //    r
      //   //    m
      //   return left;
      // } else {
      //   return right;
      // }
    }
    public int search(int[] array, int target) {
      if(array.length == 0) {
        return -1;
      }
      // assumptions: return the first occurance of target if duplicate
      // step 1: find shifted point
      // step 2: search in 2 different range, both of them are sorted
      int shift = findShift(array);
      // data structure: [0, shift] ascending, [shift, right] ascending
      // step 1: search first occurance in left half, 
      // if return -1, search right part
      int res = searchFirst(array, 0, shift, target);
      if (res == -1) {
        return searchFirst(array, shift, array.length - 1, target);
      }
      return res;
    }
    private int searchFirst(int[] array, int left, int right, int target) {
      // edge case, if left >= right - 1 input
      // may need not to handle, becuse, left right will handle, plus left, right
      // will not out of boundry themselves
      while (left < right - 1) { 
  
        int mid = left + (right - left) / 2;
        if (target <= array[mid]) {
          right = mid;
        } else {
          left = mid;
        }
      }
      if (array[left] == target) {
        return left;
      } else if (array[right] == target) {
        return right;
      } else {
        return -1;
      }
    }
  }