//PROBLEM 3 - Largest Prime Factor

//The prime factors of 13195 are 5, 7, 13 and 29.
//What is the largest prime factor of the number 600851475143 ?

import java.util.ArrayList;
public class q3_largestPrimeFactor {
    public static boolean isPrime(int n){ //returns true if n is prime

        for(int i = 2; i<Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]){
        //my idea here was to keep dividing by the lowest possible prime and add that prime to an array list.
        //This would basically give us the prime factoriziation of the number, and the last term (the largest) should be the answer.
        //The reason this would work is because every number has a prime factorization.

        ArrayList<Integer> arr = new ArrayList<Integer>();

        long n = 600851475143L; //the number they gave us. The reason it's a long is because the number exceeds the int range.
        int i = 2; //the primes we will divide by.

        while(n!=1){ //keep dividing until we can't divide anymore
           if(isPrime(i)){
               if(n%i == 0){
                   arr.add(i); //adds the prime
                   n/=i; //divides by the prime to reduce number
                   i=2; //resets prime
               } else {
                   i++; // increment i if doesn't divide
               }
           } else {
               i++; // increment i if it isn't prime
           }
        }

        System.out.println(arr); //returns [71, 839, 1471, 6857], which is the prime factorization of the number.
                                 //6857 is the largest factor, so that is our answer.


    }
}