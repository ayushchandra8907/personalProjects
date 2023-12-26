import java.util.*;
import java.io.*;
import java.util.Arrays;

public class shellgame {
    public static void swap(int[] arr, int i1, int i2){

        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));

        //line 1
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        //rest of the lines
        int[][] games = new int[N][3];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            games[i][0] = Integer.parseInt(st.nextToken());
            games[i][1] = Integer.parseInt(st.nextToken());
            games[i][2] = Integer.parseInt(st.nextToken());
        }

        //alg tiem
        int[] locations = new int[3];
        locations[0] = 1;
        locations[1] = 2;
        locations[2] = 3;

        int maxPoints = 0;
        int points = 0;

        //start under shell 1=============================================
        for(int i = 0; i<N; i++){
            //make the move
            swap(locations, games[i][0]-1, games[i][1]-1);

            //make the guess
            if(locations[games[i][2]-1] == 1){
                points++;
            }
        }

        maxPoints = Math.max(points, maxPoints);
        points = 0;

        //start under shell 2=============================================
        locations[0] = 1;
        locations[1] = 2;
        locations[2] = 3;

        for(int i = 0; i<N; i++){
            //make the move
            swap(locations, games[i][0]-1, games[i][1]-1);

            //make the guess
            if(locations[games[i][2]-1] == 2){
                points++;
            }
        }

        maxPoints = Math.max(points, maxPoints);
        points = 0;

        //start under shell 3============================================
        locations[0] = 1;
        locations[1] = 2;
        locations[2] = 3;

        for(int i = 0; i<N; i++){
            //make the move
            swap(locations, games[i][0]-1, games[i][1]-1);

            //make the guess
            if(locations[games[i][2]-1] == 3){
                points++;
            }
        }

        maxPoints = Math.max(points, maxPoints);
        points = 0;




        pw.println(maxPoints);

        pw.close();
    }
}