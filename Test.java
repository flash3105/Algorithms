import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the grid
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Initialize the grid
        char[][] grid = new char[N][N];

        // Read the N×N grid of characters
        for (int i = 0; i < N; i++) {
            grid[i] = scanner.nextLine().toCharArray();
        }

        // Calculate the length of the largest square patch
        int largestSquare = findLargestSquare(grid, N);

        // Print the result
        System.out.println(largestSquare);
    }

    private static int findLargestSquare(char[][] grid, int N) {
        if (N == 0) return 0;

        // Create a 2D array to store the size of the largest square ending at (i, j)
        int[][] dp = new int[N][N];
        int maxSquareLength = 0;

        // Fill the dp array
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // If we are on the first row or first column, the largest square is at most 1
                if (i == 0 || j == 0) {
                    dp[i][j] = 1; // Each single cell is a 1x1 square
                } else {
                    // Check if the current cell matches the cells above, to the left, and diagonally above-left
                    if (grid[i][j] == grid[i - 1][j] && grid[i][j] == grid[i][j - 1] && grid[i][j] == grid[i - 1][j - 1]) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    } else {
                        dp[i][j] = 1; // This is a 1x1 square
                    }
                }
                // Update the maximum square length found
                maxSquareLength = Math.max(maxSquareLength, dp[i][j]);
            }
        }

        return maxSquareLength;
    }
}
