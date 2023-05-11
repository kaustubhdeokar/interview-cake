import java.util.HashMap;
import java.util.Map;

public class Capitalise {
    public static void main(String[] args) {

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        int[] arr = {2,8,7,4,1,3,5,6,9};
        int[][] mat = {{3,2,5}, {1,4,6}, {8,7,9}};
        double[] rowSum = new double[mat.length];
        double[] colSum = new double[mat[0].length];

        HashMap<Integer, Integer> innerMap;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                innerMap = new HashMap<>();
                innerMap.put(i, j);
                map.put(mat[i][j], new HashMap<>(innerMap));
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }

        for (Map.Entry<Integer, HashMap<Integer, Integer>> mapEntry : map.entrySet()) {
            System.out.println(mapEntry.getKey() + ":" + mapEntry.getValue());
        }

        HashMap<Integer, Integer> rowCol = map.get(1);
        Map.Entry<Integer, Integer> next = rowCol.entrySet().iterator().next();
        System.out.println(next.getKey()+":"+next.getValue());

    }
}
