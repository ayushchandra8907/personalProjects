import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class TEMPLATE {
    public static void sort2Darr(int[][] arr, int col){
        int i, j, temp;
        int n = arr.length;

        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j][col] > arr[j + 1][col]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j][col];
                    arr[j][col] = arr[j + 1][col];
                    arr[j + 1][col] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }

    }

    public static void print2Darr(int[][] arr){
        for(int[] a:arr){
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("testing.in")); //all the input commands
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("testing.out"))); //all the output commands

        //line 1
        StringTokenizer st = new StringTokenizer(br.readLine()); //takes each line to read (re initialize this for eqach new line)
        int N = Integer.parseInt(st.nextToken());




        pw.close();
    }
}