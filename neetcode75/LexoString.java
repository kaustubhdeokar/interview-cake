import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class LexoString {

    static class Nums {
        int n1;
        int n2;

        int getSum() {
            return n1 + n2;
        }

        public Nums(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

        @Override
        public String toString() {
            return "n1=" + n1 + ", n2=" + n2;
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {39, 61, 85};
        int[] nums2 = {80, 37, 14};
        int[][] queries = {{42, 10}};

        Comparator<Nums> comp1 = (n1, n2) -> Integer.compare(n2.getSum(), n1.getSum());
        PriorityQueue<Nums> q = new PriorityQueue<>(comp1);

        for (int i = 0; i < nums1.length; i++) {
            q.add(new Nums(nums1[i], nums2[i]));
        }

        Iterator<Nums> iterator1 = q.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        while (!q.isEmpty()) {
            System.out.println(q.poll().toString());
        }


        int[] res = new int[queries.length];
        int resPtr = 0;

        for (int i = 0; i < queries.length; i++) {
            int lLim = queries[i][0];
            int rLim = queries[i][1];

            Iterator<Nums> iterator = q.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
            boolean valueAdd = false;
            while (iterator.hasNext()) {
                Nums next = iterator.next();
                if (next.n1 >= lLim && next.n2 >= rLim) {
                    res[resPtr] = next.getSum();
                    valueAdd = true;
                    break;
                }

            }
            if (!valueAdd) {
                res[resPtr] = -1;
            }
            resPtr += 1;
        }

        for (int r : res) {
            System.out.print(r + " ");
        }
    }

}
