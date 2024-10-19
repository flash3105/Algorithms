import java.util.Scanner;

public class Sum{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read two space-separated integers m and n
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.close();

        // Calculate the result of Summify(m, n)
        long result = summify(m, n);

        // Print the result
        System.out.println(result);
    }

    // Recursive method to compute Summify(m, n)
    public static long summify(int m, int n) {
        // Base case: Summify(0, n) = n for all n >= 0
        if (m == 0) {
            return n;
        }

        long sum = 0;
        // Compute the sum for Summify(m-1, k) for k from 1 to n
        for (int k = 1; k <= n; k++) {
            sum += summify(m - 1, k);
        }

        return sum;
    }
}

