package arrays;

import org.junit.Assert;

import java.util.HashMap;

public class ContinuousSubarraySum {

    public static void main(String[] args) {
        ContinuousSubarraySum continuousSubarraySum = new ContinuousSubarraySum();
        Assert.assertTrue("expected true:", continuousSubarraySum.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        Assert.assertFalse("expected false:", continuousSubarraySum.checkSubarraySum(new int[]{23,2,6,4,7}, 13));

    }

    public boolean checkSubarraySum(int[] nums, int k) {

        int len = nums.length;
        int[] prefixSum = new int[nums.length];
        int sum = 0;
        HashMap<Integer, Integer> mapRemainderToIndex = new HashMap<>();

        mapRemainderToIndex.put(0, 0);

        for (int i = 0; i < len; i++) {
            sum += nums[i];
            prefixSum[i] = sum;

            int remainder = prefixSum[i] % k;

            if (!mapRemainderToIndex.containsKey(remainder)) {
                mapRemainderToIndex.put(remainder, i + 1);
            } else if (mapRemainderToIndex.get(remainder) < i) {
                return true;
            }
        }

        return false;
    }
}
