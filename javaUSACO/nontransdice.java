import java.util.Scanner;

public class nontransdice {
    public static void expectedValue(int[] a, double p){
        int sum = 0;
        for(int i:a){
            sum+=a;
        }
        return p*sum;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        String[] outputs = new String[T];

        //alg (goes case by case)
        for(int i = 0; i<T; i++){
            //get data
            String line = sc.nextLine();

            //alg time
        }


        //final outputing time
        for(String s:outputs){
            System.out.println(s);
        }
    }
}