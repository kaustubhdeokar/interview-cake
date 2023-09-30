package august20leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem3 {


    static class OrderingHouses {
        int start;
        int end;
        int cost;

        public OrderingHouses(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        static Comparator<OrderingHouses> comparator = (c1, c2) -> {

            if (((c1.end - c1.start)/c1.cost) == ((c2.end - c2.start)/c2.cost)) return Integer.compare(c2.end, c1.end);
            return Integer.compare(((c1.end - c1.start)/c1.cost) , ((c2.end - c2.start)/c2.cost));
        };

        @Override
        public String toString() {
            return "OrderingHouses{" +
                    "start=" + start +
                    ", end=" + end +
                    ", cost=" + cost +
                    '}';
        }
    }

    public int optimizeCost(int houses, List<List<Integer>> offers) {

        List<OrderingHouses> orderingHouses = new ArrayList<>();
        for (List<Integer> list : offers) {
            orderingHouses.add(new OrderingHouses(list.get(0), list.get(1), list.get(2)));
        }


        orderingHouses.sort(OrderingHouses.comparator);
        System.out.println(orderingHouses);

        OrderingHouses current = orderingHouses.get(0);

        for (int i = 1; i < orderingHouses.size(); i++) {
            OrderingHouses itr = orderingHouses.get(i);
            if (!(itr.end >= current.start && itr.end <= current.end) && !(itr.start >= current.start && itr.start <= current.end)
                    && !(itr.start < current.start && itr.end > current.end)) {
                current.cost += itr.cost;
                current.start = Integer.min(current.start, itr.start);
                current.end = Integer.max(current.end, itr.end);
            }

        }

        return current.cost;

    }

    public static void main(String[] args) {

        int houses = 5;
        List<List<Integer>> ints = List.of(List.of(0, 6, 5), List.of(2, 9, 4), List.of(0, 9, 2), List.of(3, 9, 3), List.of(1, 6, 10),
                List.of(0, 1, 3), List.of(3, 8, 9),List.of(4, 8, 3),List.of(2, 6, 5), List.of(0, 4, 6));
        Problem3 problem3 = new Problem3();
        int cost = problem3.optimizeCost(houses, ints);
        System.out.println(cost);

    }
}
