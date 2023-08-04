package InterviewQuestions.arrays;

import java.sql.SQLOutput;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII_80 {
    public static void main(String[] args) {
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        int result = removeDuplicates(nums3);
        System.out.println("Result: " + result);
        System.out.println(Arrays.toString(nums3));

    }


    public static int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        int in = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[in - 2]) {
                nums[in++] = nums[i];
            }
        }
        return in;
    }


    public static void move(int[] array, int i, int j) {
        int aux;
        for (int e = i; e < j; e++) {
            aux = array[e + 1];
            array[e + 1] = array[e];
            array[e] = aux;
        }
    }
}
