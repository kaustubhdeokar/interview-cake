import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        int[] resultArr = new int[2];

        for (int i = 1; i < nums.length; i++) {

            if(map.get(target-nums[i])!=null){

                int pos1 = map.get(target-nums[i]);
                return new int[] {pos1,i};
            }
            map.put(nums[i],i);
        }
        return resultArr;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        int[] nums = {2,7,11,15};
        int target = 9;
        for(Integer i:twoSum.twoSum(nums,target)){
            System.out.print(i+" ");
        }
        System.out.println();
        int[] nums2 = {3,2,4};
        target = 6;
        for(Integer i:twoSum.twoSum(nums2,target)){
            System.out.print(i+" ");
        }

    }


}
