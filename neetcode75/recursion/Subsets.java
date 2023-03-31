package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        Subsets subsets = new Subsets();

        List<List<Integer>> result = subsets.subsets(nums);

        for (List<Integer> outer : result) {
            System.out.println(outer);
        }

    }

    public List<List<Integer>> subsets(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();
        return subsets(nums, list, 0);
    }

    private List<List<Integer>> subsets(int[] nums, ArrayList<Integer> list, int index) {

        List<List<Integer>> result = new ArrayList<>();
        if(index == nums.length){
            result.add(new ArrayList<>(list));
            return result;
        }

        result.addAll(subsets(nums, list, index+1));

        list.add(nums[index]);
        result.addAll(subsets(nums, list, index+1));
        list.remove(list.size()-1);


        return result;
    }

}
