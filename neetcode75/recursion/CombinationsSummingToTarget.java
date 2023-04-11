package recursion;

import java.util.ArrayList;

public class CombinationsSummingToTarget {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        recursive(15, new int[]{4, 5, 6}, result, list);

        for (ArrayList<Integer> ans : result) {
            System.out.println(ans);
        }

    }

    private static void recursive(int target, int[] arr, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {

        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(list));
        }

        for (int i = 0; i < arr.length; i++) {
            if (target - arr[i] < 0) {
                break;
            }
            list.add(arr[i]);
            recursive(target - arr[i], arr, result, list);
            list.remove(list.size()-1);
        }

    }


}