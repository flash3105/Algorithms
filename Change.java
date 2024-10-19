import java.util.Scanner;

public class Change {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input string
        String s = scanner.nextLine();
        scanner.close();

        // Calculate the length of the longest palindromic subsequence
        int length = longestPalindromicSubsequence(s);

        // Print the result
        System.out.println(length);
    }

    public static int longestPalindromicSubsequence(String s) {
        int n = s.length();
        // Create a 2D array to store lengths of palindromic subsequences
        int[][] dp = new int[n][n];

        // Every single character is a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Build the dp array
        for (int length = 2; length <= n; length++) { // length of the substring
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1; // Ending index of the current substring

                if (s.charAt(i) == s.charAt(j)) {
                    // If characters match, extend the length of the palindrome
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    // If characters don't match, take the maximum length by ignoring one of the characters
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // The length of the longest palindromic subsequence is found at dp[0][n-1]
        return dp[0][n - 1];
    }
}

