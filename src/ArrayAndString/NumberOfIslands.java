package ArrayAndString;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/15
 */

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        int count = 0;
        boolean[][] used = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !used[i][j]) {
                    count++;
                    walk(grid, used, i, j);
                }

            }
        }
        return count;
    }

    public void walk(char[][] grid, boolean[][] used, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || used[row][col] || grid[row][col] == '0')
            return;
        used[row][col] = true;
        walk(grid, used, row - 1, col);
        walk(grid, used, row + 1, col);
        walk(grid, used, row, col - 1);
        walk(grid, used, row, col + 1);
    }

}
