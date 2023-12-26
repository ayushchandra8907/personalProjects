import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class bovineshuffle {
    public static int[] inverseShuffle(int[] arr){
        int N = arr.length;

        int[] inverse = new int[N];

        for(int i = 0; i<N; i++){
            int place = i+1;
            int pointer = 0;

            //find pointer
            for(int k = 0; k<N; k++){
                if(arr[k] == place){
                    pointer = k + 1;
                    break;
                }
            }


            inverse[i] = pointer;
        }

        return inverse;
    }


    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in")); //all the input commands
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out"))); //all the output commands

        //line 1
        StringTokenizer st = new StringTokenizer(br.readLine()); //takes each line to read (re initialize this for eqach new line)
        int N = Integer.parseInt(st.nextToken());

        int[] shuffle = new int[N];
        int[] ID = new int[N];

        //line 2
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            shuffle[i] = Integer.parseInt(st.nextToken());
        }

        //line 2
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            ID[i] = Integer.parseInt(st.nextToken());
        }


        //alg time=================================================
        int[] inverse = inverseShuffle(shuffle);

        int[] temp = new int[N];


        for(int shuf = 0; shuf<3; shuf++){
            //fill temp
            for(int i = 0; i<N; i++){
                temp[i] = ID[i];
            }
            //System.out.println(Arrays.toString(temp));

            //make the switches
            for(int p = 0; p<N; p++){
                //find target position
                int pos = inverse[p]-1;

                //make the switch
                ID[pos] = temp[p];
            }
        }




        //print out each value in file
        for(int i:ID){
            pw.println(i);
        }

        pw.close();
    }
}