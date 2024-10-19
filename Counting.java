import java.util.Scanner;

public class Counting {

    // Class to hold the counts of zeros and ones
    static class Count {
        long zeros;  // Count of printed zeros
        long ones;   // Count of printed ones

        Count(long zeros, long ones) {
            this.zeros = zeros;
            this.ones = ones;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of test cases
        int M = scanner.nextInt();
        
        // Process each case
        for (int i = 0; i < M; i++) {
            int Ni = scanner.nextInt();
            Count count = unknown(Ni);
            // Print the result for this test case
            System.out.println(count.zeros + " " + count.ones);
        }

        scanner.close();
    }

    public static Count unknown(int n) {
        // Base cases for recursion
        if (n <= 0) {
            return new Count(1, 0); // 1 zero printed for n <= 0
        } else if (n == 1) {
            return new Count(0, 1); // 1 one printed for n = 1
        } else {
            // Recursive calls
            Count count1 = unknown(n - 1);
            Count count2 = unknown(n - 3);
            // Sum up the counts from both recursive branches
            long totalZeros = count1.zeros + count2.zeros;
            long totalOnes = count1.ones + count2.ones;
            return new Count(totalZeros, totalOnes);
        }
    }
}
