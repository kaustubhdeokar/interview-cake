import java.util.Arrays;

public class SieveOfEratosthenes {

    public static void main(String[] args) {

        int number = 1000;
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        boolean[] nums = sieveOfEratosthenes.calculatePrimeTill(number);


        for (int i = 2; i < 10; i++) {
            System.out.println(i + ":" + nums[i] + " ");
        }
    }

    public boolean[] calculatePrimeTill(int n) {
        boolean[] nums = new boolean[n + 1];
        Arrays.fill(nums, true);

        for (int i = 2; i * i <= n; i++) {
            if (nums[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    nums[j] = false;
                }
            }
        }
        return nums;
    }

}
