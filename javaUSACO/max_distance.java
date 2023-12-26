import java.util.Arrays;
import java.util.Scanner;

public class max_distance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //handle x coords
        int[] xCoords = new int[N];
        for(int i = 0; i<N; i++) {
            xCoords[i] = sc.nextInt();
        }

        //handle y coords
        int[] yCoords = new int[N];
        for(int i = 0; i<N; i++) {
            yCoords[i] = sc.nextInt();
        }

        //start of alg
        int maxDis = 0;

        for(int i = 0; i<N; i++){
            for(int k = 0; k<N; k++){
                int xdis = Math.abs(xCoords[i]-xCoords[k]);
                int ydis = Math.abs(yCoords[i]-yCoords[k]);

                int dis = (int)(Math.pow(xdis, 2) + Math.pow(ydis, 2));

                if(dis>maxDis){
                    maxDis = dis;
                }
            }
        }

        System.out.println(maxDis);

    }
}