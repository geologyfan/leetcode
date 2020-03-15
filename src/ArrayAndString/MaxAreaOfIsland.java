package ArrayAndString;

/**
 * @description:
 * @author: bin
 * @create: 2020/3/15
 */

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}}));
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int maxArea = 0;
        boolean[][] used = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !used[i][j]) {
                    maxArea = Math.max(maxArea, computeArea(grid, used, i, j));
                }
            }
        }
        return maxArea;
    }

    public int computeArea(int[][] grid, boolean[][] used, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || used[row][col] || grid[row][col] == 0)
            return 0;
        used[row][col] = true;
        return 1 + computeArea(grid, used, row - 1, col) + computeArea(grid, used, row + 1, col)
                + computeArea(grid, used, row, col - 1) + computeArea(grid, used, row, col + 1);
    }

}
