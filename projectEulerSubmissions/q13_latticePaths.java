//not finished with the problem yet - I know how to solve, but the numbers are too big so I need to figure that out.

public class q13_latticePaths {
    public static long factorial(int n){
        if(n == 1 || n == 0){
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    public static void main(String[] args){
        //nCr = n!/(n-r)!/r!

        long answer = 1;

        for(int i = 0; i <= 19; i++){
            answer *= (double)(40-i)/(20-i);
        }

        System.out.println(answer);

    }
}