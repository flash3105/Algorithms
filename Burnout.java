import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Burnout {
    
    // Recursive function to calculate the number of cells that can be infected
    public static int calculate(String[][] a, int r, int col) {
        // Count starts with the current infected cell
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,col});

        int [] dcol={-1,1,0,0};
        int [] drow={0,0,-1,1};

        
        
        while(!queue.isEmpty()){
        int[] current = queue.poll();
        int row = current[0];
        int c = current[1];
        
        for (int i = 0; i < 4; i++) {
            int newRow = row + drow[i];
            int newCol = c + dcol[i];
            
            // Check if the new position is within bounds and is healthy ('P')
            if (newRow >= 0 && newRow < a.length && newCol >= 0 && newCol < a[0].length && a[newRow][newCol].equals("P")) {
                a[newRow][newCol] = "I"; // Mark as infected
                count++;
                queue.add(new int[]{newRow, newCol}); // Add new position to the queue
            }
        }
    }
        // Boundary checks: Don't go out of grid bounds
      return count;  
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Read grid size (rows and columns)
        String grid = input.nextLine();
        String[] ind = grid.split(" ");
        int row = Integer.parseInt(ind[0]);
        int col = Integer.parseInt(ind[1]);

        // Read initial infection point (lr, lc)
        String L = input.nextLine();
        int lr = Integer.parseInt(L.substring(0, 1));
        int lc = Integer.parseInt(L.substring(2));    

        // Initialize the grid
        String[][] data = new String[row][col];

        for (int i = 0; i < row; i++) {
            String line = input.nextLine();
            String[] dataLine = line.split(""); 
            for (int j = 0; j < col; j++) {
                data[i][j] = dataLine[j];  
            }
        }

        // Infect the initial position
        data[lr][lc] = "I";

        // Calculate the total number of infected cells
        int ans = calculate(data, lr, lc);
        
        // Output the result
        System.out.println(ans);

        input.close();
    }
}
