import java.util.*;
import java.io.*;
import java.util.Arrays;

public class cowsignal {
    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("cowsignal.in")); //all the input commands
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out"))); //all the output commands

        //line 1
        StringTokenizer st = new StringTokenizer(br.readLine()); //takes each line to read (re initialize this for eqach new line)
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] lines = new String[M];

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            lines[i] = st.nextToken();
        }

        //alg time

        // n times duplicate char
        for(int line = 0; line<M; line++){
            String newline = "";
            for(int c = 0; c<N; c++){
                for(int i = 0; i<K; i++){
                    newline += lines[line].substring(c, c+1);
                }
            }
            lines[line] = newline;
        }

        //print out lines k times

        for(String c:lines){
            for(int i = 0; i<K; i++){
                pw.println(c);
            }
        }





        pw.close();
    }
}