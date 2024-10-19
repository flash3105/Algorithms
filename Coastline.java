import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Coastline {

    public static int calculate(String[][] a, int r, int c) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[a.length][a[0].length]; // To track visited cells
        queue.add(new int[]{r, c});
        visited[r][c] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            // Check all four directions
            for (int i = 0; i < 4; i++) {
                int newR = row + dr[i];
                int newC = col + dc[i];

                // Check if the new coordinates are inside the grid
                if (newR >= 0 && newC >= 0 && newR < a.length && newC < a[0].length) {
                    if (a[newR][newC].equals("O")) {
                        // If it's water, it's part of the coastline
                        count++;
                    } else if (!visited[newR][newC] && a[newR][newC].equals("L")) {
                        // If it's land and not visited, continue exploring
                        visited[newR][newC] = true;
                        queue.add(new int[]{newR, newC});
                    }
                } else {
                    // If we're out of bounds, it's a coastline (implies water outside)
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] coord = input.nextLine().split(" ");

        int lr = Integer.parseInt(coord[0]);
        int lc = Integer.parseInt(coord[1]);

        String[] L = input.nextLine().split(" ");
        int row = Integer.parseInt(L[0]);
        int col = Integer.parseInt(L[1]);
        String[][] grid = new String[row][col];

        // Read in the grid data
        for (int i = 0; i < row; i++) {
            String[] data = input.nextLine().split("");
            for (int j = 0; j < col; j++) {
                grid[i][j] = data[j];
            }
        }

        int ans = calculate(grid, lr, lc);

        System.out.println(ans);
    }
}
