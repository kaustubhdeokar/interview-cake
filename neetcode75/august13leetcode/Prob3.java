package august13leetcode;

import java.util.TreeSet;

public class Prob3 {
    public static void main(String[] args) {

        int[] nums = {61, 85, 196, 17};
        int x = 1;
        int lastElem = nums.length - 1;
        int minAbs = Integer.MAX_VALUE;

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(nums[lastElem]);

        for (int i = nums.length - x - 1; i >= 0; i--) {

            Integer ceiling = treeSet.ceiling(nums[i]);
            if (ceiling != null) {
                minAbs = Integer.min(Math.abs(nums[i] - ceiling), minAbs);

            }
            Integer floor = treeSet.floor(nums[i]);
            if (floor != null) {
                minAbs = Integer.min(Math.abs(nums[i] - floor), minAbs);
            }
            lastElem -= 1;
            treeSet.add(nums[lastElem]);
        }

        System.out.println(minAbs);


    }
}
