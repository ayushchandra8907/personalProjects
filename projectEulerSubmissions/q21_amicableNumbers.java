public class q21_amicableNumbers {

    //returns the sum of the proper divisors of n, by testing only up to the square root of n to speed up the algorithm,
    //which is the d(n) function the problem describes.

    public static int d(int n){
        int s = 1;

        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                s += i + n/i;
            }
        }

        return s;
    }

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();

        int sum = 0;

        //This for loop goes through each number 1-10000 and checks if it is an amicable pair with its value of d(n). The
        //if statement is pretty much the direct definition the problem describes.
        for(int i = 1; i<10000 ;i++){
            int a = i;
            int b = d(a);

            if(d(b) == a && d(a) == b && a != b){
                //note how we are only adding a, not b. This is because since the pair goes either way we will be adding
                //b eventually anyways.
                sum += a;
            }
        }




        long stopTime = System.currentTimeMillis();

        System.out.println(sum);

        System.out.println("Runtime: " + (stopTime-startTime) + "ms");
    }
}