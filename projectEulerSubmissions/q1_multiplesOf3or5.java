//PROBLEM 1 - Multiples of 3 or 5

//If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
//Find the sum of all the multiples of 3 or 5 below 1000.


public class q1_multiplesOf3or5 {
    public static int sumFactors(int n, int lim) { //gets sum of multiples of n from 1 to lim exclusive
        int sum = 0;

        for(int i = 1; i<lim; i++){
            if(i%n == 0){
                sum += i;
            }
        }

        return sum;
    }


    public static void main(String args[]){

        int sum3 = sumFactors(3, 1000); //multiples of 3 from 1-1000
        int sum5 = sumFactors(5, 1000); //multiples of 5 from 1-1000
        int sum15 = sumFactors(15, 1000); //multiples of lcm of 3 and 5 from 1-1000

        //since problem asks for multiples of 3 OR 5, numbers that are multiples of both will be calculated twice, due to
        //lap to calculate this, we just subtract the sum of the lcm of both since they will consistently divide 3 and 5.

        int answer = sum3+sum5-sum15;

        System.out.println(answer); // returns 233168, our answer
    }

}