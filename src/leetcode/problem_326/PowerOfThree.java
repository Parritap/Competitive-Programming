package leetcode.problem_326;

public class PowerOfThree {

    public static void main(String[] args) {
        final PowerOfThree powerOfThree = new PowerOfThree();
        System.out.println(powerOfThree.isPowerOfThree(27));
        System.out.println(powerOfThree.isPowerOfThree(0));
        System.out.println(powerOfThree.isPowerOfThree(9));
        System.out.println(powerOfThree.isPowerOfThree(45));
        System.out.println(powerOfThree.isPowerOfThree(81));
        System.out.println(powerOfThree.isPowerOfThree(2147483647));
        // Integer.MAX_VALUE = 2147483647
    }

    public boolean isPowerOfThree(int n) {
        int pow = 1;
        int i = 0;
        while (pow < n && i++ < 22) {
            pow += (pow << 1);
        }
        return pow == n;
    }
}
