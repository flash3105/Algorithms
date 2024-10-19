import java.util.Scanner;

public class Trans {

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        int cols = input.nextInt();
        input.nextLine();
        //accepting the transpose values and store
        int [][] matrix = new int[cols][rows];
        for(int i = 0;i<rows;i++){
            String value =input.nextLine();
            String []splitted = value.split(" ");

            for(int j=0;j<cols;j++){
                matrix[j][i]=Integer.parseInt(splitted[j]);
            }
        }
        input.close();
        //print the matrix out 
        for(int i =0;i<cols;i++){
            for(int j=0;j<rows;j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
    
}
