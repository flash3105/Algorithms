import java.util.Scanner;
public class Modulus{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
      
        int N = input.nextInt();
        
        int Z = input.nextInt();

        int count =0;
      //solving by brute force 
        
      for(int i =1;i<N;i++){
        for(int j=1;j<=i;j++){
            if((i*j)%N==Z){
                if(i==j){
                    count++;
                   

                }
                else{
                    count+=2;
                    
                }
            }
        }
      }
      System.out.println(count);
    }
    
}