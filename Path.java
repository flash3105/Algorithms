import java.util.Arrays;
import java.util.Scanner;

public class Path {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Input the size of the grid
        int N = input.nextInt();
        
        // Initialize the grid
        int[][] grid = new int[N][N];

        // Input the number of obstacles
        int Obs = input.nextInt();
        input.nextLine(); // Consume the newline character

        // Input the obstacle coordinates and mark them in the grid
        for (int i = 0; i < Obs; i++) {
            String[] coord = input.nextLine().split(" ");
            int row = Integer.parseInt(coord[0]);
            int col = Integer.parseInt(coord[1]);
            if (row >= 0 && row < N && col >= 0 && col < N) {  // Ensure valid obstacle coordinates
                grid[row][col] = 1; // Mark obstacle
            }
        }

        // Calculate unique paths
        int result = uniquePathsWithObstacles(grid);

        // Output the result
        System.out.println(result);
        
        input.close();
    }

    public static int uniquePathsWithObstacles(int[][] A) {
        int r = A.length;
        int c = A[0].length;

        // Create a 2D matrix for storing computed paths
        int[][] paths = new int[r][c];

        for (int i = 0; i < r; i++) {
            Arrays.fill(paths[i], -1);
        }

        return UniquePathHelper(0, 0, r, c, A, paths);
    }

    public static int UniquePathHelper(int i, int j, int r, int c, int[][] A, int[][] paths) {
        // Boundary conditions
        if (i >= r || j >= c) {
            return 0; // Out of bounds
        }
        if (A[i][j] == 1) {
            return 0; // Hit an obstacle
        }
        // Base case: reached the destination
        if (i == r - 1 && j == c - 1) {
            return 1; 
        }
        // Return memoized value if already computed
        if (paths[i][j] != -1) {
            return paths[i][j];
        }
        
        // Recursive calls to move down and right
        paths[i][j] = UniquePathHelper(i + 1, j, r, c, A, paths) + UniquePathHelper(i, j + 1, r, c, A, paths);
        return paths[i][j];
    }
}
