import java.util.ArrayList;
import java.util.Scanner;

public class Scoring {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> values = new ArrayList<>();
        
        // Start the program
        int N = input.nextInt(); // Number of values
        
        while (N > 0) {
            values.add(input.nextInt());
            N--;
        }
        
        int T = input.nextInt(); // Target score
        input.close();
        // Initialize an ArrayList to track the possible scores
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(1); // Start with a score of 1
        
        // Loop through each value in the input list
        for (int value : values) {
            // Create a temporary list to store the new possible scores
            ArrayList<Integer> newScores = new ArrayList<>();
            
            // For each score in the current list of scores, calculate both addition and multiplication results
            for (int score : scores) {
                int added = score + value;  // Add the value
                int multiplied = score * value;  // Multiply by the value
                
                // If the result of addition is less than T, add it to the new scores list
                if (added < T) {
                    newScores.add(added);
                }
                
                // If the result of multiplication is less than T, add it to the new scores list
                if (multiplied < T) {
                    newScores.add(multiplied);
                }
            }
            
            // Update the scores list with the new possible scores
            scores = newScores;
        }
        
        // Find the maximum score from the final list of scores
        int maxScore = 0;
        for (int score : scores) {
            if (score > maxScore) {
                maxScore = score;
            }
        }
        
        System.out.println(maxScore);
    }
}
