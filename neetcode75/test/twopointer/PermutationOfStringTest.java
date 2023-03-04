package twopointer;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PermutationOfStringTest {

    private final PermutationOfString m_permutationOfString = new PermutationOfString();

    @Test
    public void testPermutationOfString() {

        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean result = m_permutationOfString.checkInclusion(s1, s2);
        assertTrue(result);

    }

    @Test
    public void testPermutationOfStringNegative() {
        String s1 = "ab";
        String s2 = "eidboaoo";

        boolean result = m_permutationOfString.checkInclusion(s1, s2);
        assertFalse(result);

    }

}