import java.io.*;
import java.util.*;
public class milkpails {
    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("pails.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // read X, Y, and M
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = 0;

        for(int i = 0; i<=m/x; i++){
            for(int k = 0; k<=m/y; k++){
                int milk = x*i + y*k;

                if(milk > max && milk <= m){
                    max = milk;
                }
            }
        }

// print the answer
        pw.println(max);
        // close output stream
        pw.close();    }
}