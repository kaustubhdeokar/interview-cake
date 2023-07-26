package trees;

import java.util.ArrayList;
import java.util.Arrays;

public class ModeOfTree {

    public static void main(String[] args) {

        returnInt();
    }

    public static int[] returnInt() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        int[] arr = {1, 1, 2, 3, 4, 0, 0};

        int[] ints = Arrays.copyOf(arr, 10);
        for (int i : ints) {
            System.out.print(i + ":");
        }
        return ints;
    }

}
