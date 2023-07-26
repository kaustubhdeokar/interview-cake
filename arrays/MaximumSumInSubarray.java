

public class MaximumSumInSubarray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, -2, 5};
        long maximumSubarrayUsingKadanesAlgo = findMaximumSubarrayUsingKadanesAlgo(arr);

    }

    private static long findMaximumSubarrayUsingKadanesAlgo(int[] arr) {

        /*
        * The algorithm depends on selecting maximum of (current value , sum upto here + the current value)//1
        * and maximizing the output of the above step.//2
        *
        * */

        long maxSumTillHere = arr[0];
        long maxSum = maxSumTillHere;

        for (int i = 1; i < arr.length; i++) {
            maxSumTillHere = Long.max(maxSumTillHere + arr[i], arr[i]);//1
            maxSum = Long.max(maxSum, maxSumTillHere);//2
        }

        return maxSum;

    }


}
