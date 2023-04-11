package graph;

public class NumberOfIslands {

    public static void main(String[] args) {

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numberOfIslands.numIslands(grid));

    }

    public int numIslands(char[][] grid) {

        int islands = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length; j++){
                if(grid[i][j]== '1'){
                    islands += 1;
                    countIslands(grid, i, j);
                }
            }
        }

        return islands;

    }

    private void countIslands(char[][] grid, int i, int j) {
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]=='1'){
            grid[i][j] = '0';
            countIslands(grid, i-1, j);
            countIslands(grid, i+1, j);
            countIslands(grid, i, j+1);
            countIslands(grid, i, j-1);
        }
    }

}
