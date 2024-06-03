package leetcode.problem_2789;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JavaSolution {


    public static void main(String[] args) {
        try {
            int[] array = readArrayFromFile("src/leetcode/nums.txt");
            System.out.println("RESULT: " + maxArrayValue(array));
            for (int num : array) {
                System.out.print(num + ", ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long maxArrayValue(int[] nums) {
        long current = nums[nums.length - 1];

        for (int i = nums.length - 1; i > 0; i--) {
            if (current < nums[i - 1]) {
                current = nums[i - 1];
            } else {
                current += nums[i - 1];
            }
        }
        return current;
    }

    public static int[] readArrayFromFile(String url) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(url));
        String[] parts = lines.get(0).split(",");
        int[] array = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i].trim());
        }
        return array;
    }
}
