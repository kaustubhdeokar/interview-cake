package recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {

        Permutations permutations = new Permutations();
        int[] nums = {1, 2, 3};
        permutations.permute(nums);

        permutations.permute("ABC");

    }

    private List<String> permute(String S) {
        List<String> result = new ArrayList<>();

        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add("");

        findPermutations(S, result, queue);

        Comparator<String> comp = String::compareTo;
        result.sort(comp);

        return result;
    }

    public void findPermutations(String str, List<String> result, ArrayDeque<String> queue) {

        for (int i = 0; i < str.length(); i++) {

            char curr = str.charAt(i);

            int queueSize = queue.size();

            for (int j = 0; j < queueSize; j++) {

                String top = queue.remove();
                for (int k = 0; k <= top.length(); k++) {

                    String newString = top.substring(0, k) + String.valueOf(curr) + top.substring(k);
                    queue.add(newString);

                }

            }

        }

        while (!queue.isEmpty()) {
            result.add(queue.remove());
        }


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
