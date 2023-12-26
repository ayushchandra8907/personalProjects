import java.util.Scanner;

public class countingLiars {
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


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();

        char[][] statements = new char[N][2];

        sc.nextLine();
        for(int i = 0; i<N; i++){
            String line = sc.nextLine();

            statements[i][0] = line.charAt(0);
            statements[i][1] = line.charAt(2);
        }

        //alg time


    }
}