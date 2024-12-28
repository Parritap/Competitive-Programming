package leetcode.problem_50;

public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (x == 1.0) return 1.0;
        if (x == -1.0) return (n % 2 == 0) ? 1.0 : -1.0;

        if (n == Integer.MIN_VALUE) {
            return 1.0 / (aux(x, Math.abs(Integer.MIN_VALUE + 1)) * n);
        }

        if (n < 1) {
            return 1.0 / aux(x, Math.abs(n));
        }

        return aux(x, Math.abs(n));
    }

    private double aux(double x, int n) {
        if (n == 1) return x;

        int div = n / 2;
        double pow = aux(x, div);

        return (n % 2 == 0) ? (pow * pow) : (pow * pow * x);
    }
}
