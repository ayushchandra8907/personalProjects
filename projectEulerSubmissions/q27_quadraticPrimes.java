public class q27_quadraticPrimes {
    public static boolean isPrime(double var0) {
        for(int var1 = 2; var1 < Math.sqrt(var0); ++var1) {
            if (var0 % var1 == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        //timer stuff
        long startTime = System.currentTimeMillis();

        int maxA = 0;
        int maxB = 0;
        int maxCount = 0;

        for(int a = -999; a<=999; a++){
            for(int b = -1000; b<= 1000;b++){
                boolean valid = true;
                int n = 0;

                while(valid){
                    double quadValue = Math.pow(n, 2) + a*n + b;
                    if(isPrime(quadValue)){
                        n++;
                    } else {
                        valid = false;
                    }
                }

                if(n >= maxCount){
                    maxCount = n;
                    maxA = a;
                    maxB = b;
                }
            }
        }


        System.out.println(maxA * maxB);
        System.out.println(maxA + " " + maxB + " " + maxCount);



        //timer stuff
        long stopTime = System.currentTimeMillis();

        System.out.println("Runtime: " + (stopTime-startTime) + "ms");
    }
}