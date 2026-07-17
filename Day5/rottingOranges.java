import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class rottingOranges {

    public static int count(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Find all initially rotten oranges
        // and count fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int time = 0;

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();

                for (int[] d : dir) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];

                    if (x >= 0 && x < n &&
                        y >= 0 && y < m &&
                        grid[x][y] == 1) {

                        grid[x][y] = 2;
                        fresh--;
                        q.offer(new int[]{x, y});
                    }
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(count(grid));

        sc.close();
    }
}