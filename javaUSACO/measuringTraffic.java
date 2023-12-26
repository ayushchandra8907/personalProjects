import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class measuringTraffic {

    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("traffic.in")); //all the input commands
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out"))); //all the output commands

        //line 1
        StringTokenizer st = new StringTokenizer(br.readLine()); //takes each line to read (re initialize this for eqach new line)
        int N = Integer.parseInt(st.nextToken());

        String[] status = new String[N];
        int[][] intervals = new int[N][2];

        //next lines
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            status[i] = st.nextToken();
            intervals[i][0] = Integer.parseInt(st.nextToken());
            intervals[i][1] = Integer.parseInt(st.nextToken());
        }

        //alg time===================================================================================================
        int[][] ogRates = new int[N][2];

        //combines all rows with no ramps
        for(int highway = 0; highway <N; highway++){
            if(status[highway].equals("none")){
                ogRates[highway][0] = intervals[highway][0];
                ogRates[highway][1] = intervals[highway][1];

                //keep looping forward until not none
                boolean rampFound = false;
                int ind = highway+1;

                //finds the range of non ramps
                int lowerBound = intervals[highway][0];
                int upperBound = intervals[highway][1];

                while(!rampFound){
                    if(ind == N){
                        break;
                    } else {
                        if(status[ind].equals("none") == false){
                            rampFound = true;
                        } else {
                            lowerBound = Math.max(lowerBound, intervals[ind][0]);
                            upperBound = Math.min(upperBound, intervals[ind][1]);
                            ind++;

                        }
                    }
                }

                //sets all the things in range to the lowr and upper bound
                for(int k = highway; k<ind; k++){
                    if(k!=N){
                        ogRates[k][0] = lowerBound;
                        ogRates[k][1] = upperBound;
                    }
                }

                highway = ind;

            }
        }

        //solve for the lower ramp
        int lowInd = 0;
        int lowBoundSum = 0;
        int uppBoundSum = 0;

        while(ogRates[lowInd][0] == 0 && ogRates[lowInd][1] == 0){
            lowInd++;
            lowBoundSum += Math.min(intervals[lowInd-1][0], intervals[lowInd-1][1]);
            uppBoundSum += Math.max(intervals[lowInd-1][0], intervals[lowInd-1][1]);
        }

        ogRates[0][0] = ogRates[lowInd][0] - lowBoundSum;
        ogRates[0][1] = ogRates[lowInd][1] - uppBoundSum;

        //solve for the last ramp
        int uppInd = N-1;
        lowBoundSum = 0;
        uppBoundSum = 0;

        while(ogRates[uppInd][0] == 0 && ogRates[uppInd][1] == 0){
            uppInd--;
            lowBoundSum += Math.max(intervals[uppInd+1][0], intervals[uppInd+1][1]);
            uppBoundSum += Math.min(intervals[uppInd+1][0], intervals[uppInd+1][1]);
        }

        ogRates[N-1][0] = ogRates[lowInd][0] - lowBoundSum;
        ogRates[N-1][1] = ogRates[lowInd][1] - uppBoundSum;






        pw.println(ogRates[0][0] + " " + ogRates[0][1]);
        pw.print(ogRates[N-1][0] + " " + ogRates[N-1][1]);

        pw.close();
    }
}