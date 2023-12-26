import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class bovineGenomics {
    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in")); //all the input commands
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out"))); //all the output commands

        //line 1
        StringTokenizer st = new StringTokenizer(br.readLine()); //takes each line to read (re initialize this for eqach new line)
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] spottyCows = new String[N];
        String[] plainCows = new String[N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            spottyCows[i] = st.nextToken();
        }

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            plainCows[i] = st.nextToken();
        }

        //alg time
        int potentialMutations = 0;

        for(int genome = 0; genome<M; genome++){
            //make array of spoteted cow
            ArrayList<Character> spottedGenome = new ArrayList<Character>();

            for(String s:spottyCows){
                spottedGenome.add(s.charAt(genome));
            }

            //make array of plani cow
            ArrayList<Character> plainGenome = new ArrayList<Character>();

            for(String s:plainCows){
                plainGenome.add(s.charAt(genome));
            }

            //search
            boolean matchFound = true;

            for(int i = 0; i<spottedGenome.size(); i++){
                char currGenome = spottedGenome.get(i);
                matchFound = false;



                for(int j = 0; j<plainGenome.size(); j++){
                    if(plainGenome.get(j) == currGenome){
                        matchFound = true;
                        break;
                    }
                }

                if(matchFound){
                    break;
                }


            }

            if(matchFound == false){
                potentialMutations++;
            }

        }

        pw.print(potentialMutations);
        pw.close();
    }
}