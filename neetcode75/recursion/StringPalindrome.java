package recursion;

import java.util.ArrayList;
import java.util.List;

public class StringPalindrome {

    public static void main(String[] args) {

        StringPalindrome stringPalindrome = new StringPalindrome();
        List<String> res = stringPalindrome.partition("aab");

        for (String res1 : res) {
            System.out.println(res1);
        }

    }

    public List<String> partition(String s) {

        StringBuilder current = new StringBuilder();
        return partitionString(s, current, 0);

    }

    private List<String> partitionString(String str, StringBuilder curr, int index) {

        List<String> result = new ArrayList<>();
        if (index == str.length()) {
            if(isPalindrome(curr.toString())) {
                result.add(curr.toString());
            }
            return result;
        }

        curr.append(str.charAt(index));
        result.addAll(partitionString(str, curr, index + 1));
        curr.deleteCharAt(curr.length() - 1);

        result.addAll(partitionString(str, curr, index + 1));

        return result;
    }

    private boolean isPalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start += 1;
            end -= 1;
        }
        return true;
    }

}
