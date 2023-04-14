package InterviewQuestions.arrays;

import java.util.Arrays;

public class RemoveDuplicates {


    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        int k = removeDuplicates(nums);
        System.out.println(k + ", nums = " + Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] arr) {
        Integer previous = null;
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            var e = arr[i];

            if (previous == null || e != previous) {
                arr[c] = e;
                c++;
                previous = e;
            }
        }
        return c;
    }
}