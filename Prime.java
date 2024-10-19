import java.util.Scanner;

    
    public class Prime{
        // Function to check if a number is prime
        public static boolean isPrime(int num) {
            if (num < 2) return false;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    
        // Function to check if a number contains zero
        public static boolean containsZero(int num) {
            return String.valueOf(num).contains("0");
        }
    
        // Function to check if all substrings are prime
        public static boolean allSubstringsArePrime(int num) {
            String strNum = String.valueOf(num);
            for (int i = 0; i < strNum.length(); i++) {
                int subNum = Integer.parseInt(strNum.substring(i));
                if (!isPrime(subNum)) {
                    return false;
                }
            }
            return true;
        }
    
        // Main function to find the largest prime below N that satisfies the conditions
        public static int findLargestPrime(int N) {
            // Iterate downwards from N-1
            for (int i = N - 1; i >= 2; i--) {
                if (isPrime(i) && !containsZero(i) && allSubstringsArePrime(i)) {
                    return i;  // Return the first prime that meets the conditions
                }
            }
            return -1;  // No prime found
        }
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            scanner.close();
    
            int result = findLargestPrime(N);
            System.out.println(result);
        }  
}
    


