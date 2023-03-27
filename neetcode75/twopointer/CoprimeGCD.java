package twopointer;

import java.math.BigInteger;

public class CoprimeGCD {

    public static void main(String[] args) {

        int[] nums = {4, 7, 8, 15, 3, 5};
        //{557663, 280817, 472963, 156253, 273349, 884803, 756869, 763183, 557663, 964357, 821411, 887849, 891133, 453379, 464279, 574373, 852749, 15031, 156253, 360169, 526159, 410203, 6101, 954851, 860599, 802573, 971693, 279173, 134243, 187367, 896953, 665011, 277747, 439441, 225683, 555143, 496303, 290317, 652033, 713311, 230107, 770047, 308323, 319607, 772907, 627217, 119311, 922463, 119311, 641131, 922463, 404773, 728417, 948281, 612373, 857707, 990589, 12739, 9127, 857963, 53113, 956003, 363397, 768613, 47981, 466027, 981569, 41597, 87149, 55021, 600883, 111953, 119083, 471871, 125641, 922463, 562577, 269069, 806999, 981073, 857707, 831587, 149351, 996461, 432457, 10903, 921091, 119083, 72671, 843289, 567323, 317003, 802129, 612373};

        BigInteger zero = BigInteger.valueOf(0);
        BigInteger one = BigInteger.valueOf(1);
        BigInteger suffixProduct = BigInteger.valueOf(1);
        BigInteger product = BigInteger.valueOf(1);
        BigInteger prefixProduct = one;

        for (int i : nums) {
            product = product.multiply(BigInteger.valueOf(i));
        }

        BigInteger product2 = product;

        for (int i = 0; i < nums.length - 1; i++) {

            BigInteger curr = BigInteger.valueOf(nums[i]);
            suffixProduct = suffixProduct.multiply(curr);
            product = product.divide(curr);
            BigInteger gcd = gcd(suffixProduct, product, zero);

            if (gcd.equals(one)) {
                //return i;
                System.out.println(i);
                //break;
            }

            BigInteger lastCurr = BigInteger.valueOf(nums[nums.length - i - 1]);
            prefixProduct = prefixProduct.multiply(lastCurr);
            product2 = product2.divide(lastCurr);
            BigInteger gcd2 = gcd(prefixProduct, product2, zero);

            if (gcd2.equals(one)) {
                //return i;
                System.out.println(nums.length - i - 1);
                //break;
            }
        }
        //return -1;
    }

    public static BigInteger gcd(BigInteger num1, BigInteger num2, BigInteger zero) {
        if (num2.equals(zero)) return num1;
        return gcd(num2, num1.mod(num2), zero);
    }

}
