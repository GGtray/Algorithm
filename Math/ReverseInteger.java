package Math;
public class ReverseInteger {
    public int reverse(int x) {
      // 
      // step 1: x -> char array
      // step 2: reverse this char array
      // step 3: char array -> int
      // corner case check
      // 
      char[] intChars = intToChars(x);
      // reverse(intChars);
      return toInts(intChars);
    }
    // step 1: int x to chars
    private char[] intToChars(int x) {
      // find out how many digits are there
      int nums = 0;
      for (int i = x; i > 0; i /= 10) {
        nums++;
      }
      // 12 - 2 - 0
      char[] res = new char[nums];
      int index = 0;
      for (int i = x; i > 0; i /= 10) {
        res[index++] = (char) (i % 10);
        // 0 1
        // 2 1
      } 
      return res;
    }
    
    // step 3: char array to int
    private int toInts(char[] chars) {
      // iterate from tail to head, 
      // sum += digit * bit
      // bit *= 10;
      int sum = 0, bit = 1;
      for (int i = chars.length - 1; i >= 0; i--) {
        int digit = (int)(chars[i] - '0');
        if (sum + digit * bit >= Integer.MAX_VALUE) {
          return 0;
        }
        sum += digit * bit;
        bit *= 10;
      }
      return sum;
    } 
  }