package august27;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Prob3 {

    public static void main(String[] args) {
        Prob3 prob3 = new Prob3();
        ArrayList<Integer> ints = new ArrayList<>();
        ints.addAll(List.of(1, 32, 1, 2));
//        prob3.minOperations(ints, 22);
    }

    private HashSet<Long> getRequiredSet(long n) {
        int closestPowerOf2 = 1;
        while (Math.pow(2, closestPowerOf2) <= n) {
            closestPowerOf2 += 1;
        }
        closestPowerOf2 -= 1;

        HashSet<Long> requiredNums = new HashSet<>();
        while (n > 0) {
            long pow = (long) Math.pow(2, closestPowerOf2);
            if (pow <= n) {
                requiredNums.add(pow);
                n -= pow;
            }
            closestPowerOf2 -= 1;
        }
        return requiredNums;
    }

//    public int minOperations(List<Integer> nums, int target) {
//
//        HashSet<Long> requiredNums = getRequiredSet(target);
//        nums.sort((c1, c2) -> Integer.compare(c1, c2));
//
//        int operations = 0;
//        System.out.println(requiredNums);
//        int minOfRequired = Integer.MAX_VALUE;
//        int maxOfRequiredNums = Integer.MIN_VALUE;
//        for (long num : nums) {
//            if(requiredNums.contains(num)){
//                requiredNums.remove(num);
//            }
//            else{
//                maxOfRequiredNums = Integer.max(maxOfRequiredNums, num);
//            }
//            System.out.print(num+" ");
//        }
//
//        System.out.println(requiredNums);
//        return 0;
//
//    }

}
