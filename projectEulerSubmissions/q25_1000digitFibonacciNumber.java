import java.math.BigInteger;
import java.util.ArrayList;

public class q25_1000digitFibonacciNumber {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();

        //At first, I used the common recursive algorithm for the fibbonacci sequence. I then saw that this wouldn't be
        //possible because the fibbonaci recursive function took too much time, and after reaching values of lengths of
        //4 digits, it became very slow. I then rememembered a concept called memiozation, which involved storing calculated
        //values in an array. Although I didn't code an approach like that, I took some key details and decided to make an
        //array list (since the size is mutable) and had a loop that kept generating fibonaci values until the length of
        //the value was 1000 digits.


        ArrayList<BigInteger> fibSeries = new ArrayList<BigInteger>();
        fibSeries.add(new BigInteger("1"));
        fibSeries.add(new BigInteger("1"));

        int index = 1;

        while(fibSeries.get(fibSeries.size() - 1).toString().length() < 1000){
            BigInteger b = fibSeries.get(index).add(fibSeries.get(index-1));
            fibSeries.add(b);
            index++;
        }

        //prints index+1 since index is 2 behind the series, and it already increments at the end of the loop.
        System.out.println(index+1);

        long stopTime = System.currentTimeMillis();

        //only had a runtime of 169 ms with this new way of calculating values.
        System.out.println("Runtime: " + (stopTime-startTime) + "ms");
    }
}