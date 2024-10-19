import java.util.Scanner;

public class Cycling {

    // Function to calculate the maximum possible score
    public static int calculateMaxScore(int[] signs, int N) {
        // Initialize variables for Kadane's Algorithm
        int maxCurrent = 0;
        int maxGlobal = 0;

        // Apply Kadane's algorithm to find the maximum sum of a contiguous subarray
        for (int i = 0; i < N; i++) {
            // Choose to include the current sign in the subarray or start a new subarray
            maxCurrent = Math.max(signs[i], maxCurrent + signs[i]);
            // Track the global maximum
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }

        // If the maximum score is negative, the best option is to not cycle (score of 0)
        return maxGlobal;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input array size
        int N = input.nextInt();
        int[] signs = new int[N];

        // Input array elements (sign values)
        for (int i = 0; i < N; i++) {
            signs[i] = input.nextInt();
        }
        input.close();

        // Calculate the maximum score
        int ans = calculateMaxScore(signs, N);
        System.out.println(ans);
    }
}
