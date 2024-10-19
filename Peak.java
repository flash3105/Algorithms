import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Peak {
    
    // Method to calculate the greatest number of newly infected populations in any one day
    public static int maxNewlyInfected(String[][] grid, int startRow, int startCol) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Directions for up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol}); // Initial infection
        grid[startRow][startCol] = "I"; // Mark as infected

        int maxNewInfected = 0; // To track the max new infections per day
        
        while (!queue.isEmpty()) {
            int newlyInfectedToday = 0; // Count of newly infected cells today
            int currentQueueSize = queue.size(); // Number of infected cells to process today
            
            for (int i = 0; i < currentQueueSize; i++) {
                int[] current = queue.poll(); // Get current infected cell
                int r = current[0];
                int c = current[1];
                
                // Check all 4 directions
                for (int[] direction : directions) {
                    int newRow = r + direction[0];
                    int newCol = c + direction[1];
                    
                    // Check bounds and if the cell is healthy
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                        && grid[newRow][newCol].equals("P")) {
                        grid[newRow][newCol] = "I"; // Infect the cell
                        queue.add(new int[]{newRow, newCol}); // Add to queue for next day's processing
                        newlyInfectedToday++; // Increment count of newly infected
                    }
                }
            }

            // Update the maximum count of newly infected populations
            maxNewInfected = Math.max(maxNewInfected, newlyInfectedToday);
        }

        return maxNewInfected; // Return the maximum number of new infections in a day
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Read grid size (rows and columns)
        String gridSize = input.nextLine();
        String[] size = gridSize.split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        // Read initial infection point (row and column)
        String L = input.nextLine();
        int lr = Integer.parseInt(L.split(" ")[0]);
        int lc = Integer.parseInt(L.split(" ")[1]);

        // Initialize the grid
        String[][] data = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = input.nextLine();
            for (int j = 0; j < cols; j++) {
                data[i][j] = String.valueOf(line.charAt(j)); // Read character directly
            }
        }

        // Calculate the maximum number of newly infected populations in one day
        int maxNewInfected = maxNewlyInfected(data, lr, lc);
        
        // Output the result
        System.out.println(maxNewInfected);

        input.close();
    }
}
