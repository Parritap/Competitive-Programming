package leetcode.problem_342;

public class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 0 || Integer.bitCount(n) > 1) return false;
        int comparator = 1;
        for (int i = 1; i <= 16; i++) {
            if (n == comparator) return true;
            comparator = comparator << 2;
        }
        return false;
    }
}
