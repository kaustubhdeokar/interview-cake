import java.util.ArrayList;

public class reverseWords {

    public static void main(String[] args) {

        char[] chars = "cake thief true".toCharArray();
        //expected output -> true thief cake.
        reverse(chars, 0, chars.length - 1);

        int j = 0;
        for (int i = j; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, j, i - 1);
                j = i + 1;
            }
        }

        reverse(chars, j, chars.length - 1);

        for (char c : chars) {
            System.out.print(c);
        }

    }

    public static void reverse(char[] chars, int start, int end) {

        while (start < end) {

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

}
