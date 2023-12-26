import java.util.Arrays;
import java.util.Scanner;

public class cowcollege {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] cows = new int[N];

        for(int i = 0; i<N; i++){
            cows[i] = sc.nextInt();
        }

        Arrays.sort(cows);

        int tut = 0;
        int finalTut = 0;
        long totalprofit = -1L;

        for(int i = N-1; i>=0; i--){
            long subProfit = 0L;
            int elements = N-i;
            tut = cows[i];

            subProfit = (long)elements * (long)tut;

            if(subProfit >= totalprofit){
                totalprofit = subProfit;
                finalTut = tut;
            }
        }

        System.out.println(totalprofit + " " + finalTut);

    }
}