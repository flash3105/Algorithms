import java.util.Scanner;

public class Modu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Problem 1: Longest Common Subsequence
        System.out.println("Longest Common Subsequence: ");
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int lcsLength = longestCommonSubsequence(s1, s2);
        System.out.println("Length: " + lcsLength);

        // Problem 2: Fibonacci
        System.out.println("Fibonacci: ");
        int n = 10; // Find the 10th Fibonacci number
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));

        // Problem 3: Coin Change
        System.out.println("Coin Change: ");
        int[] coins = {1, 2, 5};
        int amount = 11;
        int ways = coinChange(coins, amount);
        System.out.println("Ways to make change for " + amount + ": " + ways);

        // Problem 4: Knapsack Problem
        System.out.println("0/1 Knapsack Problem: ");
        int[] weights = {1, 2, 3};
        int[] values = {10, 15, 40};
        int capacity = 6;
        int maxProfit = knapsack(weights, values, capacity);
        System.out.println("Maximum profit: " + maxProfit);

        // Problem 5: Longest Increasing Subsequence
        System.out.println("Longest Increasing Subsequence: ");
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        int lisLength = longestIncreasingSubsequence(arr);
        System.out.println("Length of LIS: " + lisLength);

        // Problem 6: Minimum Path Sum
        System.out.println("Minimum Path Sum: ");
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int minPathSum = minPathSum(grid);
        System.out.println("Minimum path sum: " + minPathSum);

        // Problem 7: Edit Distance
        System.out.println("Edit Distance: ");
        String word1 = "horse";
        String word2 = "ros";
        int editDist = minDistance(word1, word2);
        System.out.println("Edit Distance: " + editDist);

        // Problem 8: Unique Paths
        System.out.println("Unique Paths: ");
        int uniquePaths = uniquePaths(3, 7); // 3 rows, 7 columns
        System.out.println("Unique paths: " + uniquePaths);
    }

    // Problem 1: Longest Common Subsequence
    private static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    // Problem 2: Fibonacci
    private static int fibonacci(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Problem 3: Coin Change
    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

    // Problem 4: 0/1 Knapsack Problem
    private static int knapsack(int[] weights, int[] values, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity];
    }

    // Problem 5: Longest Increasing Subsequence
    private static int longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Each element is an increasing subsequence of length 1
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    // Problem 6: Minimum Path Sum
    private static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    // Problem 7: Edit Distance
    private static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j; // If first string is empty
                } else if (j == 0) {
                    dp[i][j] = i; // If second string is empty
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // No operation needed
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])); // Insert, Remove, or Replace
                }
            }
        }
        return dp[m][n];
    }

    // Problem 8: Unique Paths
    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1; // Only one way to reach any cell in the first row or column
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // Sum of paths from top and left cells
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

