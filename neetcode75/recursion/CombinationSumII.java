package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        List<List<Integer>> result = combinationSum(candidates, target, 0, curr);

        return result;

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target, int index, List<Integer> curr) {

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = List.of();
        resultList.add(list);
        int prevSize = 0;

        for (int i = 0; i < candidates.length; i++) {

            int resultSize = resultList.size();
            int start;

            if (i > 0 && candidates[i] == candidates[i - 1]) {
                start = prevSize;
            } else {
                start = 0;
            }


            for (int j = start; j < resultSize; j++) {

                List<Integer> temp = new ArrayList<>(resultList.get(j));
                temp.add(candidates[i]);
                resultList.add(temp);

            }

            prevSize = resultSize;

        }

        return resultList;
    }

    public static void main(String[] args) {

        CombinationSumII combinationSumII = new CombinationSumII();
        int[] arr = {1, 2, 2, 2, 5};
        int target = 8;
        List<List<Integer>> lists = combinationSumII.combinationSum2(arr, target);
        for (List<Integer> l : lists) {
            System.out.println(l);
        }
    }

}
