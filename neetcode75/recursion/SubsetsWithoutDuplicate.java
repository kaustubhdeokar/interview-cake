package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetsWithoutDuplicate {

    public static void main(String[] args) {

        SubsetsWithoutDuplicate subsetII = new SubsetsWithoutDuplicate();
        int[] nums = {1, 2, 2, 2, 5};
        List<List<Integer>> lists = subsetII.iterativeCombinations(nums);
        for (List<Integer> l : lists) {
            System.out.println(l);
        }

    }

    public List<List<Integer>> iterativeCombinations(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int start = 0;
        int prevInnerSize = 0;

        for (int i = 0; i < nums.length; i++) {

            List<List<Integer>> innerResult = new ArrayList<>();

            if (i > 0 && nums[i] == nums[i - 1]) {
                start = result.size() - prevInnerSize;
            } else {
                start = 0;
            }

            for (int j = start; j < result.size(); j++) {
                List<Integer> integers = new ArrayList<>(result.get(j));
                integers.add(nums[i]);
                innerResult.add(integers);
            }

            prevInnerSize = innerResult.size();
            result.addAll(innerResult);
        }
        return result;

    }

}
