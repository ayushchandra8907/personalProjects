import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class blockedBillboard2 {
    public static int getArea(int x1, int y1, int x2, int y2){
        return (int)(Math.abs(x1-x2))*(Math.abs(y1-y2));
    }

    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("billboard.in")); //all the input commands
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out"))); //all the output commands

        //line 1
        StringTokenizer st = new StringTokenizer(br.readLine()); //takes each line to read (re initialize this for eqach new line)

        int[] lawnMowerCoords = new int[4];
        for(int i = 0; i<4; i++){
            lawnMowerCoords[i] = Integer.parseInt(st.nextToken());
        }

        int[] cowFeedCoords = new int[4];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<4; i++) {
            cowFeedCoords[i] = Integer.parseInt(st.nextToken());
        }

        //alg time
        boolean horizontallyContained = false;
        boolean verticallyContained = false;

        if(cowFeedCoords[0] <= lawnMowerCoords[0] && cowFeedCoords[2] >= lawnMowerCoords[2]){
            horizontallyContained = true;
        }

        if(cowFeedCoords[1] <= lawnMowerCoords[1] && cowFeedCoords[3] >= lawnMowerCoords[3]){
            verticallyContained = true;
        }


        //case check
        if(horizontallyContained && verticallyContained){
            pw.println(0); //since the feeder billboard covers complteley, nothing is needed
        } else if(horizontallyContained){ //figure out the vertical distance, and multiply that by horizontal of lawnmoer
            int horizontal = Math.abs(lawnMowerCoords[0]-lawnMowerCoords[2]);
            int vertical = Math.abs(cowFeedCoords[3]-lawnMowerCoords[3]);

            pw.print(horizontal*vertical);

        } else if(verticallyContained) {
            int horizontal = Math.abs(cowFeedCoords[2]-lawnMowerCoords[2]);
            int vertical = Math.abs(lawnMowerCoords[1]-lawnMowerCoords[3]);

            pw.print(horizontal*vertical);

        } else { //isnt contained so max area is given

            pw.print(getArea(lawnMowerCoords[0], lawnMowerCoords[1], lawnMowerCoords[2], lawnMowerCoords[3]));
        }

        pw.close();
    }
}