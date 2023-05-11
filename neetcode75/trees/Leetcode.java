package trees;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode {

    public static void main(String[] args) {

        int power = 0;
        int[] cost = {1, 5, 2, 2, 3, 3, 1};

        int j = 0;
        int totalCost = 0;
        while (j < cost.length) {

            int curr = (int) Math.pow(2, power);
            Comparator<Integer> c1 = (i1, i2) -> Integer.compare(i2, i1);
            PriorityQueue<Integer> queue = new PriorityQueue<>(c1);
            while (curr > 0 && j < cost.length) {
                System.out.print(cost[j] + " ");
                queue.add(cost[j]);
                j += 1;
                curr -=1;
            }
            System.out.println();
            int highest = -1;
            int diff = 0;
            while(!queue.isEmpty()) {
                if(highest == -1){
                    highest = queue.poll();
                }
                else{
                    diff += (highest - queue.poll());
                }
            }
            totalCost += diff;
            power+=1;
            System.out.println();
        }

    }

}
