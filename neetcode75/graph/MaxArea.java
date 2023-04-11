package graph;

public class MaxArea {
    public static void main(String[] args) {

        MaxArea maxArea = new MaxArea();
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        System.out.println(maxArea.maxAreaOfIsland(grid));

    }

    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = Integer.MIN_VALUE;
        int currentArea;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    currentArea = computeAreaOfIsland(grid, i, j);
                    System.out.println("Current area:" + currentArea);
                    maxArea = Integer.max(maxArea, currentArea);
                }
            }
        }

        return maxArea;

    }

    private int computeAreaOfIsland(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return 0;
        else {
            int area = 1;
            grid[i][j] = 0;
            area += computeAreaOfIsland(grid, i - 1, j);
            area += computeAreaOfIsland(grid, i + 1, j);
            area += computeAreaOfIsland(grid, i, j + 1);
            area += computeAreaOfIsland(grid, i, j - 1);
            return area;
        }
    }


}
