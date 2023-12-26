import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class speeding {
    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("speeding.in")); //all the input commands
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out"))); //all the output commands

        //line 1
        StringTokenizer st = new StringTokenizer(br.readLine()); //takes each line to read (re initialize this for eqach new line)

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] roadStats = new int[N][2];
        int[][] bessieStats = new int[M][2];


        //road info - entry 1 is length, entry 2 is speed limit
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            //get road num
            roadStats[i][0] = Integer.parseInt(st.nextToken());
            roadStats[i][1] = Integer.parseInt(st.nextToken());
        }

        //road info - entry 1 is length, entry 2 is speed limit
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            //get road num
            bessieStats[i][0] = Integer.parseInt(st.nextToken());
            bessieStats[i][1] = Integer.parseInt(st.nextToken());
        }


        //alg time===============================================
        int maxSpeed = 0;
        ArrayList<Integer> roadArr = new ArrayList<Integer>();
        ArrayList<Integer> bessArr = new ArrayList<Integer>();

        for(int[] i:roadStats){
            int roadLen = i[0];
            int speed = i[1];

            for(int k = 0; k<roadLen; k++){
                roadArr.add(speed);
            }
        }

        for(int[] i:bessieStats){
            int roadLen = i[0];
            int speed = i[1];

            for(int k = 0; k<roadLen; k++){
                bessArr.add(speed);
            }
        }

        //go thru each entry
        for(int i = 0; i<100; i++){
            if(roadArr.get(i) < bessArr.get(i)){
                maxSpeed = Math.max(maxSpeed, bessArr.get(i) - roadArr.get(i));
            }
        }



        //final answer==========================================
        pw.println(maxSpeed);

        pw.close();
    }
}