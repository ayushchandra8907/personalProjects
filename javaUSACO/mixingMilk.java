import java.util.*;
import java.io.*;
import java.util.Arrays;

public class mixingMilk {
    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("mixmilk.in")); //all the input commands
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out"))); //all the output commands

        //lines
        int[][] bucketStats = new int[3][2];

        StringTokenizer st = new StringTokenizer(br.readLine()); //takes each line to read (re initialize this for eqach new line)
        bucketStats[0][0] = Integer.parseInt(st.nextToken());
        bucketStats[0][1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        bucketStats[1][0] = Integer.parseInt(st.nextToken());
        bucketStats[1][1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        bucketStats[2][0] = Integer.parseInt(st.nextToken());
        bucketStats[2][1] = Integer.parseInt(st.nextToken());

        //alg time

        for(int pour = 0; pour<100; pour++){
            //bucket that milk is leaving
            int buck1 = pour%3;
            int buck2 = (pour+1)%3;


            //first check, is this going to fill the other bucket or drain our current bucket?
            int amt1 = bucketStats[buck1][1];
            int amt2 = bucketStats[buck2][1];
            int cap1 = bucketStats[buck1][0];
            int cap2 = bucketStats[buck2][0];


            if(amt1 + amt2 > cap2){ //then overflow
                bucketStats[buck2][1] = cap2;
                bucketStats[buck1][1] = amt1 - (cap2-amt2);

            } else { //all of amt 1 goes into the new bucket
                bucketStats[buck2][1]+=amt1;
                bucketStats[buck1][1] = 0;
            }



        }

        for(int[] arr:bucketStats){
            pw.println(arr[1]);
        }

        pw.close();
    }
}