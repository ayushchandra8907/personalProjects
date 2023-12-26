import java.util.Scanner;
import java.util.Arrays;

public class abcs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] values = new int[7];

        for(int i = 0; i<7; i++){
            values[i] = sc.nextInt();
        }

        //actual alg
        Arrays.sort(values);

        //a + b + c = last index (values[6])

        //find which values of a, b, c sum to a+b+c, then use a<b<c to figure out which one is which
        int[] triple = new int[3];

        for(int i = 0; i<6; i++){
            for(int k = 0; k<6; k++){
                for(int j = 0; j<6; j++){
                    if(values[i]+values[k]+values[j] == values[6]){
                        triple[0] = values[i];
                        triple[1] = values[k];
                        triple[2] = values[j];
                    }
                }
            }
        }

        Arrays.sort(triple);

        System.out.println(triple[0] +" "+ triple[1] +" "+ triple[2]);




    }
}