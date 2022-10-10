//PROBLEM 5 - Smallest Multiple

//2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

public class q5_smallestMultiple {

    public static void main(String args[]){
        //Instead of trying to brute force each integer, we know that we need to look for the lcm from 1-20.
        //We can calculate this by multiplying the highest instance of each prime number from 1-20.

        //highest 2 is 16, 2^4
        //highest 3 is 9, 3^2
        //highest 5 is 5^1
        //highest 7 is 7^1
        //highest 11 is 11^1
        //highest 13 is 13^1
        //highest 17 is 17^1
        //highest 19 is 19^1

        //therefore, the divsible number is 2^4 * 3^2 * 5 * 7 * 11 * 13 * 17 * 19.
        double prod = Math.pow(2, 4) * Math.pow(3, 2) * 5 * 7 * 11 * 13 * 17 * 19;

        System.out.println(prod); //returns 2.3279256E8
                                  //moving the decimal point 8 times to the right, we get 232792560, the answer


    }

}