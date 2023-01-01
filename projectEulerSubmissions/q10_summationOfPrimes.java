import java.util.ArrayList;

public class q10_summationOfPrimes {

    //method to test if a number was prime
    public static boolean isPrime(int n){
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    //returns the next prime after the current given prime (I took both these methods from the methods used in q7: 10001st prime
    public static int nextPrime(int n){
        for(int i = n+2; i<2*n; i+=2){
            if(isPrime(i)){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        //I decided to go for the brute force approach and keep adding primes until the prime reached 2 million, which is
        //the given limit. This idea is somewhat similar to the ideas I used to solve q7. Using the next prime method, I
        //could add each iteration since it would always be a prime. I printed all the primes for debugging purposes. It
        //is important to note that this program wouldn't work on an online IDE such as codiva.io, because of output limits.
        // however, since I am coding on a app IDE, it works perfect.

        //note the use of long instead of int, because ints would reach the limit and loop over itself.
        long sum = 2;
        int currentPrime = 3;

        while(currentPrime < 2000000){

            System.out.println(currentPrime);
            sum += currentPrime;

            currentPrime = nextPrime(currentPrime);
        }

        System.out.println("\n");
        System.out.println(sum);
    }

}