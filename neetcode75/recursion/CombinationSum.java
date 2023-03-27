package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    //a number can be used multiple times.

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> curr = new ArrayList<>();
        return combinationSum(candidates, target, 0, curr);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target, int index, List<Integer> curr) {

        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return result;
        } else if (target < 0) {
            return result;
        } else if (index == candidates.length) {
            return result;
        }


        curr.add(candidates[index]);
        result.addAll(combinationSum(candidates, target - candidates[index], index, curr));
        curr.remove(curr.size() - 1);

        result.addAll(combinationSum(candidates, target, index + 1, curr));

        return result;
    }

    public static void main(String[] args) {

        CombinationSum combinationSum = new CombinationSum();
        int[] arr = {1, 2, 2, 2, 5};
        int target = 5;
        List<List<Integer>> lists = new ArrayList<>();

        lists = combinationSum.combinationSum(arr, target);
        for (List<Integer> l : lists) {
            System.out.println(l);
        }

    }
}
