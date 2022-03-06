import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
//https://www.interviewcake.com/question/java/permutation-palindrome?course=fc1&section=hashing-and-hash-tables
public class Solution {

    public static boolean hasPalindromePermutation(String theString) {

        //CAN BE IMPROVED WITH USE OF HASHSET.
        Map<Character, Integer> mapCharToCount = new HashMap<>();
        for (int i = 0; i < theString.length(); i++) {

            if (mapCharToCount.get(theString.charAt(i)) == null) {
                mapCharToCount.put(theString.charAt(i), 1);
            } else {
                mapCharToCount.put(theString.charAt(i), mapCharToCount.get(theString.charAt(i)) + 1);
            }
        }

        int oddCharCount = 0;
        for (Map.Entry<Character, Integer> entry : mapCharToCount.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddCharCount += 1;
            }
        }
        return oddCharCount <= 1;
    }


    // tests

    @Test
    public void permutationWithOddNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabcbcd");
        assertTrue(result);
    }

    @Test
    public void permutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabccbdd");
        assertTrue(result);
    }

    @Test
    public void noPermutationWithOddNumberOfChars() {
        final boolean result = hasPalindromePermutation("aabcd");
        assertFalse(result);
    }

    @Test
    public void noPermutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabbcd");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = hasPalindromePermutation("");
        assertTrue(result);
    }

    @Test
    public void oneCharacterStringTest() {
        final boolean result = hasPalindromePermutation("a");
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}


