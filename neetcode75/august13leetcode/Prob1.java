package august13leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Prob1 {
    public static void main(String[] args) {

//        int[] nums = {51, 71, 17, 24, 42};
        int[] nums = {1, 7, 2, 4, 5};

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int maxPair = -1;
        for (int i = 0; i < nums.length; i++) {

            int maxDigit = maxDigit(nums[i]);

            if (map.get(maxDigit) == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(0);
                list.add(nums[i]);
                map.put(maxDigit, list);
            } else {
                List<Integer> integers = map.get(maxDigit);
                if (integers.get(0) < integers.get(1)) {
                    integers.remove(0);
                } else {
                    integers.remove(1);
                }
                integers.add(nums[i]);
                maxPair = Integer.max(maxPair, integers.get(0) + integers.get(1));
            }

        }

        System.out.println(maxPair);

    }

    private static int maxDigit(int num) {
        int max = -1;
        while (num > 0) {
            if (num % 10 == 9) return 9;
            max = Integer.max(num % 10, max);
            num = num / 10;
        }
        return max;
    }
}
