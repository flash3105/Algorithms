import java.util.Scanner;

public class Pricing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long N = input.nextLong();  // Read the target value
        long K = 0;
        long func = 0;

        // Iterate over possible values of K until func exceeds N
        while (func <= N) {
            K++;
            func = calculateFunction(K);
        }

        // Output the largest value of K where f(K) <= N
        System.out.println(K - 1);  // K is now too large, so output K - 1
    }

    // Optimized function to calculate f(K)
    public static long calculateFunction(long K) {
        long func = 0;
        for (long j = 1; j <= K; ) {
            long div = K / j;
            long nextJ = K / div + 1;  // The next value of j where the division changes
            func += div * (nextJ - j);  // Add div for all js in the range [j, nextJ)
            j = nextJ;
        }
        return func;
    }
}
