class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1) freshCount++;
            }
        }

        if (freshCount == 0) return 0;
        int minutes = -1;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] d : dirs) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                        freshCount--;
                    }
                }
            }
        }
        return freshCount == 0 ? minutes : -1;
    }
}