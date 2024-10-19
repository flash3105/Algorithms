import java.util.Scanner;

public class Transpose {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Get the dimensions of the matrix
        int rows = input.nextInt();
        int cols = input.nextInt();
        input.nextLine();  // Consume the leftover newline after reading integers

        // Initialize the transpose matrix
        int[][] transpose = new int[cols][rows];

        // Read the matrix and transpose simultaneously
        for (int i = 0; i < rows; i++) {
            String rowInput = input.nextLine();
            String[] elements = rowInput.split(" "); // Split the row by spaces

            // Parse each element and immediately assign to the transposed matrix
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = Integer.parseInt(elements[j]);
            }
        }

        // Print the transposed matrix
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }

        input.close();  // Close the scanner
    }
}
