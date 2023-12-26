import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class lostcow {
    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("lostcow.in")); //all the input commands
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out"))); //all the output commands

        //line 1
        StringTokenizer st = new StringTokenizer(br.readLine()); //takes each line to read (re initialize this for eqach new line)
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[] numLine = new int[1001];

        boolean cowFound = false;
        int steps = 0;
        int pos = X;
        int ind = 0;

        while(!cowFound) {
            if(ind%2 == 0){ //going forward
                int newPos = X + (int)Math.pow(2, ind);

                if(newPos > Y && Y > pos) { //first check if Y is passed
                    steps += Y-pos;
                    cowFound = true;
                } else {
                    steps += newPos-pos;

                    pos = newPos;
                }
            } else {
                int newPos = X - (int)Math.pow(2, ind);

                if(newPos < Y && Y < pos) { //first check if Y is passed
                    steps += pos-Y;
                    cowFound = true;
                } else {
                    steps += pos-newPos;

                    pos = newPos;
                }

            }

            ind++;
        }





        //print answer
        pw.println(steps);

        pw.close();
    }
}