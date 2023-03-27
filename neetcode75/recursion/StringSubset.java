package recursion;

import java.util.ArrayList;

public class StringSubset {

    public void subset(String s) {
        ArrayList<String> subsets = new ArrayList<>();
        subsets(s, "", 0, subsets);
        for (String itr : subsets) {
            System.out.print(itr + " ");
        }
    }

    public void subsets(String str, String current, int index, ArrayList<String> subset) {

        if (index == str.length()) {
            subset.add(current);
            return;
        }

        subsets(str, current + str.charAt(index), index + 1, subset);
        subsets(str, current, index + 1, subset);

    }

    public static void main(String[] args) {

        StringSubset stringSubset = new StringSubset();
        stringSubset.subset("abc");

    }


}
