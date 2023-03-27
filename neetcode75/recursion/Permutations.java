package recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {

        Permutations permutations = new Permutations();
        int[] nums = {1, 2, 3};
        permutations.permute(nums);

    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> innerRes = List.of(nums[0]);
        result.add(innerRes);

        for (int i = 1; i < nums.length; i++) {

            int resSize = result.size();

            for (int j = 0; j < resSize; j++) {
                List<Integer> list = result.remove(0);

                for (int k = 0; k <= list.size(); k++) {

                    List<Integer> temp = new ArrayList<>(list);
                    temp.add(k, nums[i]);
                    result.add(temp);

                }


            }

        }

        return result;


    }
}
