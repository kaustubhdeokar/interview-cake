import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InBuiltBinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 4, 5, 7, 8, 11, 12, 13, 16, 20};
        InBuiltBinarySearch bs = new InBuiltBinarySearch();
        int key = bs.binarySearch(arr, 12);
        System.out.println(key);

        List<Integer> list = List.of(20, 16, 13, 12, 11, 8, 7, 5, 4, 1);
        key = bs.binarySearchCollection(list, 12);
        System.out.println(key);

    }

    /**
     * works on sorted array.
     */
    public int binarySearch(int[] arr, int key) {
        return Arrays.binarySearch(arr, key);
    }

    public int binarySearchCollection(List<Integer> list, int key) {
        return Collections.binarySearch(list, key, Collections.reverseOrder());
    }


}
