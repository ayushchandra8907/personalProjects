import java.util.Scanner;

public class scannertesting {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] e = new int[N];

        String order = sc.nextLine();
        System.out.println(order);
        e[0] = sc.nextInt();

        for(int i = 1; i<N; i++){
            e[i] = sc.nextInt();
        }
    }
}