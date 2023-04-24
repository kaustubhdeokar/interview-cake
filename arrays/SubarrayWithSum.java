import java.util.ArrayList;
import java.util.List;

public class SubarrayWithSum {

    static ArrayList<Integer> subarraySum(int[] arr, int n, int S) {
        int start = 0;
        int end = 1;
        int currSum = arr[0];

        while (start != end) {
            if (currSum < S) {
                currSum += arr[end];
                end += 1;
            } else if (currSum > S) {
                currSum -= arr[start];
                start += 1;
            } else {
                return (ArrayList<Integer>) List.of(start, end);
            }
        }


        return (ArrayList<Integer>) List.of(-1);
    }
}
