public class q7_10001stPrime {
    //method to test if a number was prime
    public static boolean isPrime(int n){
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    //returns the next prime after the current given prime
    public static int nextPrime(int n){
        for(int i = n+2; i<2*n; i+=2){
            if(isPrime(i)){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        int currentPrime = 3;

        //just a loop to loop through the nextPrime function. I started at 3 since the method counts by odd numbers, and
        //since 2 is the only even prime, it would make the whole function not work.

        for(int i = 2; i<=10001; i++){
            System.out.println("Prime " + i + ": " + currentPrime);
            currentPrime = nextPrime(currentPrime);
        }
    }
}