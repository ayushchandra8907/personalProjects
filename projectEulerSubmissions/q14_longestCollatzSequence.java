public class q14_longestCollatzSequence {

    //method to compute next collatz number: note the use of longs since
    public static long collatz(long c){
        if(c%2 == 0){
            return c/2;
        } else {
            return 3*c + 1;
        }
    }

    public static void main(String[] args){
        //varibales for storing information
        long start;
        int count = 1;

        int maxCount = 0;
        int maxStart = 0;

        long startTime = System.currentTimeMillis();

        //iterates through each collatz sequence until 1 million - another naive brute force solution but it runs in .375
        //seconds, which passes project euler's 1 minute rule.

        for(int i = 1; i<=1000000; i++){
            start = i;

            while(start != 1){
                start = collatz(start);
                count++;
            }
            if(count > maxCount){
                maxCount = count;
                maxStart = i;
            }
            count = 1;
        }

        long stopTime = System.currentTimeMillis();

        //prints max answer
        System.out.println(maxStart + " -> " + maxCount);
        System.out.println("Runtime: " + (stopTime-startTime) + "ms");

    }
}