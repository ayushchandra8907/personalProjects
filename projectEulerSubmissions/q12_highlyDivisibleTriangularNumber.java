public class q12_highlyDivisibleTriangularNumber {

    //without optimizing - 13 min 19.40 sec runtime
    //with optimizing - 1.07 sec runtime

    //finding factors only up to the square root of n to reduce algorithm time drastically.
    public static int numFactors(int n){
        int count = 0;
        for(int i = 1; i<=Math.sqrt(n);i++){
            if(n%i==0){
                count++;
            }
        }
        return count*2;
    }


    public static void main(String args[]){
        //This is another brute force solution, but I made a few optimizations to make it go way faster.

        //start for timing duration
        long start = System.currentTimeMillis();

        int factors = 0;
        int ind = 1;

        while(factors <= 500){
            //I used the formula for each triangle number, so that computing the triangle number would be an O(1) operation,
            //instead of the previous recursive algorithm which was an o(n) operation. This reduced the total steps by a lot,
            //but only ended up saving about 500 miliseconds.

            int tri = ind*(ind+1)/2;

            factors = numFactors(tri);

            System.out.println(ind + " " + tri + " " + factors);

            ind++;
        }


        //code for printing runtime to check efficiency.
        long stop = System.currentTimeMillis();

        System.out.println(stop-start + "ms runtime");

    }
}