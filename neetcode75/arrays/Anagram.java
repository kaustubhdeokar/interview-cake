package arrays;

public class Anagram {

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        Anagram anagram = new Anagram();
        System.out.println(anagram.isAnagram(s, t));

    }

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] arr = new int[256];
        for (int i = 0; i < s.length(); i++) {
            int sInt = (int) s.charAt(i);
            arr[sInt] += 1;
            int tInt = (int) t.charAt(i);
            arr[tInt] -= 1;
        }

        for (int c : arr) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }


}
