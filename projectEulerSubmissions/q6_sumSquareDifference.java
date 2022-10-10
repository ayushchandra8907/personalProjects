//PROBLEM 6 - Sum square difference

//The sum of the squares of the first ten natural numbers is 1^2 + 2^2 + ... + 10^2 = 385
//The square of the sum of the first ten natural numbers is (1 + 2 + ... + 10)^2 = 55^2 = 3025
//Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025-385 = 2640
//Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

public class q6_sumSquareDifference {

    public static void main(String args[]){
        //there are formulas for the summnation of such numbers. the sum of numbers 1-n is just (n)(n+1)/2.
        //the formula for the squares of the numbers is just n(n+1)(2n+1)/6.
        //if we square the first and compute the second formulas, we will get our answer.

        double squareOfSum = Math.pow((100)*(101)*0.5, 2);
        double sumOfSquares = 100*101*201*(1.0/6);

        System.out.println(squareOfSum-sumOfSquares); //prints 2.516415E7
                                                      //moving decimal 7 places to right, we get 25164150
    }
}