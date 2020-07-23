package Math;

public class HappyNumber {
    private int process(int n) {
        // find all digit
        int res = 0;
        // 19 -> 9, 10 ->
        for (int i = n; i > 0; i /= 10) {
            res += Math.pow(i % 10, 2);
        }
        return res;
    }
    public boolean isHappy(int n) {
        // naive solution6
        // step 1, given a number, find all its digits, 
        // step 2, sum up the square of these digits, get another number
        // let another number do this again
        
        // 2-> 4 -> 16 -> 37 -> 9 + 49 = 58 -> 25 + 64 = 89 -> 
        int cur = n, next = n;
        for (int i = 0; i < 5 ; i++) {
            next = process(cur);
            if (next == 1) {
                return true;
            }
            cur = next;
        }
        return false;
    }
}