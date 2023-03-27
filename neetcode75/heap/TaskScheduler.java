package heap;

import java.util.*;

public class TaskScheduler {

    class MapCharToNum {
        char c;
        int num;

        MapCharToNum(char c, int num) {
            this.c = c;
            this.num = num;
        }
    }

    public int leastInterval(char[] tasks, int n) {

        if (n == 0) return tasks.length;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        PriorityQueue<MapCharToNum> q = new PriorityQueue<>((m1, m2) -> Integer.compare(m1.num, m2.num));

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            q.add(new MapCharToNum(entry.getKey(), entry.getValue()));
        }

        ArrayDeque<Integer> putCharBackAtTime = new ArrayDeque<>();
        ArrayList<Character> resultList = new ArrayList<>();
        int currentTime = 1;

        while (true) {

            MapCharToNum top = q.remove();
            char topChar = top.c;
            int topCount = top.num;
            resultList.add(topChar);
            if (topCount == 1) {
                map.remove(topChar);
            }


        }


    }

}
