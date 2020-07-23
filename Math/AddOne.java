package Math;
public class AddOne {
    public int[] plus(int[] digits) {
      // from back to start
      // 
      // if digits < 9, add 
      // else digits[i] = 0, 
      if (digits == null || digits.length == 0) {
        return digits;
      }
      int addOne = 0;
      for (int i = digits.length - 1; i >= 0; i--) {
        if (i == digits.length - 1) {
          if (digits[i] + 1 > 9) {
            addOne = 1;
            digits[i] = 0;
          } else {
            addOne = 0;
            digits[i] += 1;
          }
          continue;
        } 
        if (digits[i] + addOne > 9) {
          addOne = 1;
          digits[i] = 0;
        } else {
          addOne = 0;
          digits[i] += 1;
        }
      }
      if (addOne != 0) {
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
      }
      return digits;
      // ex
      // 8 9 9 9
      //   0 0 0      
      //  add one 1 
    }
  }