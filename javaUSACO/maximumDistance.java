import java.util.Scanner;

public class maximumDistance {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] xCords = new int[N];
        int[] yCords = new int[N];

        for(int i = 0; i<N; i++){
            xCords[i] = sc.nextInt();

        }

        for(int i = 0; i<N; i++){
            yCords[i] = sc.nextInt();
        }

        int distance = 0;

        for(int p1 = 0; p1<N; p1++){
            int x1 = xCords[p1];
            int y1 = yCords[p1];

            for(int p2 = 0; p2 < N; p2++){
                int x2 = xCords[p2];
                int y2 = yCords[p2];

                distance = Math.max(distance, (int)(Math.pow(Math.abs(x2-x1), 2) + Math.pow(Math.abs(y2-y1), 2)));
            }
        }

        System.out.println(distance);
    }
}