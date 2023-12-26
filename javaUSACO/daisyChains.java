import java.util.Scanner;
import java.util.Arrays;

public class daisyChains {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] petals = new int[N];

        for(int i = 0; i<N; i++){
            petals[i] = sc.nextInt();
        }

        //alg tiem
        int avgCount = 0;

        for(int i = 0; i<N; i++){
            for(int j = i; j<N; j++){
                //interval is i to j
                //first calcualte average
                int numTerms = j-i+1;
                int sum = 0;

                for(int k = i; k<=j; k++){
                    sum += petals[k];
                }

                double average = (double)sum/numTerms;

                //go thru interval to see if pic got average
                boolean avgFound = false;

                for(int k = i; k<=j; k++){
                    if(average == petals[k]){
                        avgFound = true;
                        break;
                    }
                }

                if(avgFound == true){
                    avgCount++;
                }

            }
        }

        System.out.print(avgCount);
    }
}