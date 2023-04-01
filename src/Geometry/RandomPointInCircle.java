package Geometry;

import java.util.Random;
import java.lang.*;


public class RandomPointInCircle {
    public static void main(String[] args) {
    }

    class Solution {
        double radius;
        double x_center;
        double y_center;

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x_center = x_center;
            this.y_center = y_center;
        }

        public double[] randPoint() {

            Random random = new Random();
            double ymax = y_center + radius;
            double ymin = y_center - radius;
            double y = random.nextDouble(ymin, ymax);

            double xmax= Math.sqrt(radius * radius - Math.pow(y - y_center, 2)) + x_center;
            double xmin= -Math.sqrt(radius * radius - Math.pow(y - y_center, 2)) + x_center;

            double x = random.nextDouble(xmin, xmax);

            return new double[]{x, y};
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
}
