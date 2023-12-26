import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class lifeguards {

    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in")); //all the input commands
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out"))); //all the output commands

        //line 1
        StringTokenizer st = new StringTokenizer(br.readLine()); //takes each line to read (re initialize this for eqach new line)
        int N = Integer.parseInt(st.nextToken());

        int[] startTimes = new int[N];
        int[] endTimes = new int[N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            startTimes[i] = Integer.parseInt(st.nextToken());
            endTimes[i] = Integer.parseInt(st.nextToken());
        }

        //alg time
        int maxTime = 0;

        for(int redactedCow = 0; redactedCow<N; redactedCow++) { //remove one cow and build the array, and then see the array
            boolean[] timeline = new boolean[1000];

            for(int cow = 0; cow < N; cow++){
                if(cow != redactedCow){


                    for(int startTime = startTimes[cow]; startTime<endTimes[cow]; startTime++){
                        timeline[startTime] = true;
                    }
                }
            }

            int time = 0;
            for(int i = 0; i<timeline.length; i++){
                if(timeline[i]){
                    time++;
                }
            }

            maxTime = Math.max(maxTime, time);
        }

        pw.print(maxTime);
        pw.close();
    }
}