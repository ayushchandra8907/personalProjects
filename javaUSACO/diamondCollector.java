import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class diamondCollector {
    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("diamond.in")); //all the input commands
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out"))); //all the output commands

        //line 1
        StringTokenizer st = new StringTokenizer(br.readLine()); //takes each line to read (re initialize this for eqach new line)
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] diamonds = new int[N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            diamonds[i] = Integer.parseInt(st.nextToken());
        }

        //alg time
        int maxDiamonds = 0;

        Arrays.sort(diamonds);

        for(int i = 0; i<diamonds.length; i++){
            int diamondCount = 0;
            int min = diamonds[i];
            int upperB = min+K;

            for(int k = i; k<diamonds.length; k++){
                if(diamonds[k] <= upperB){
                    diamondCount++;
                } else {
                    break;
                }
            }

            maxDiamonds = Math.max(maxDiamonds, diamondCount);

        }



        //answer
        pw.print(maxDiamonds);
        pw.close();
    }
}