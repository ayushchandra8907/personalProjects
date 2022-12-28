import java.util.ArrayList;

public class q4_largestPalindromeProduct {

    //This method checks whether an integer is a palindrome by turning it into an array list with each digit being an element in the list.
    //It then compares each element in the first half with the element in the last half to see if they are the same.
    //works with both even # of digits and odd #

    public static boolean isPalindrome(int n){
        ArrayList<Integer> num = new ArrayList<Integer>();
        while(n > 0){ //assigns array list elements
            num.add(0, n%10);
            n /= 10;
        }

        for(int i = 0; i<num.size()/2; i++){ //comapres array list elements
            if(!(num.get(i) == num.get(num.size() - i - 1))){
                return false;
            }
        }

        return true;
    }


    public static void main(String args[]){

        /*
        Here, I decided to go for a brute force solution since the numbers are pretty small, and I would only have to check
        405000 numbers (since I am starting in the upper half, which the solution must be found in), which is very feasible
        for an online compiler. This is just a simple nested for loop which updates the max variable with the highest palindrome,
        which after the loop completes will be 906609, which is a palindrome and the highest palindrome from a product of two 3-digit
        numbers
        */


        int max = 0;

        for(int i = 500; i<1000; i++){
            for(int j = 500; j<1000; j++){
                if(isPalindrome(i*j) && i*j > max){
                    max = i*j;
                }
            }
        }


        System.out.println(max);

    }
}