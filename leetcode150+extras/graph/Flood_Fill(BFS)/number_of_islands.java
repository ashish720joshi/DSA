class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    bfs(grid, i, j);
                }
            }
        }

        return islands;
    }

    private void bfs(char[][] grid, int startRow, int startCol) {
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startRow, startCol });
        grid[startRow][startCol] = '0'; // mark start as visited

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];

            for (int i = 0; i < 4; i++) {
                int adjX = row + dr[i];
                int adjY = col + dc[i];

                if (adjX >= 0 && adjX < grid.length &&
                    adjY >= 0 && adjY < grid[0].length &&
                    grid[adjX][adjY] == '1') {

                    grid[adjX][adjY] = '0'; // mark as visited
                    queue.offer(new int[] { adjX, adjY });
                }
            }
        }
    }
}
