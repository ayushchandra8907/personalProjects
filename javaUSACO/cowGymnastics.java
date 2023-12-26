import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class cowGymnastics {
    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in")); //all the input commands
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out"))); //all the output commands

        //line 1
        StringTokenizer st = new StringTokenizer(br.readLine()); //takes each line to read (re initialize this for eqach new line)
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        //array
        int[][] rankings = new int[K][N];

        for(int k = 0; k<K; k++){
            st = new StringTokenizer(br.readLine());

            for(int n = 0; n<N; n++){
                rankings[k][n] = Integer.parseInt(st.nextToken());
            }
        }

        //alg time
        int numPairs = 0;

        for(int cow = 1; cow<=N; cow++){
            ArrayList<Integer> cowArr = new ArrayList<Integer>();
            for(int i = 1; i<=N; i++){ //make/fill the cow array so we can eliminate values
                cowArr.add(i);
            }

            //loop thru each game
            for(int game = 0; game<K; game++){
               //first find the pos of cow
                int[] ranks = rankings[game];

                int rank = 0;
                for(int i = 0; i < ranks.length; i++){
                    if(ranks[i] == cow){
                        rank = i;
                        break;
                    }
                }

                //now make subarray
                ArrayList<Integer> afterRank = new ArrayList<Integer>();

                for(int ind = rank+1; ind<N; ind++){
                    afterRank.add(ranks[ind]);
                }


                //now loop thru cowArr. if thtat value is NOT in afterrank, delete it.
                for(int c = 0; c<cowArr.size(); c++){
                    if(cowArr.size()==0){
                        break;
                    }
                    if(c<cowArr.size() && afterRank.indexOf(cowArr.get(c)) == -1){
                        cowArr.remove(c);
                        c--;
                    }
                }

            }

            //add the length of the cowArr size
            numPairs += cowArr.size();
        }


        pw.println(numPairs);

        pw.close();
    }
}