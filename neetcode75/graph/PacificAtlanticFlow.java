package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PacificAtlanticFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        maxForEachRow(heights);

        return null;
    }

    public void maxForEachRow(int[][] heights){

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<heights.length;i++){

            int highest = -1;
            for(int j=0;j<heights[i].length;j++){
                if(heights[i][j]>highest){
                    map.put(i, new ArrayList<>(j));
                    highest = heights[i][j];
                }
                else if(heights[i][j]==highest){
                    map.get(i).add(j);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){

            int key = entry.getKey();
            List<Integer> value = entry.getValue();

            for(int val: value){
            }

        }

    }

}
