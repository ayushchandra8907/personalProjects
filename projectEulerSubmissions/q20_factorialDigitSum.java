import java.math.BigInteger;
public class q20_factorialDigitSum {
    public static void main(String[] args){
        //When I saw this problem, I immiediatly knew it was something that bigInteger would handle.
        BigInteger factorial = new BigInteger("1");

        //Multiplies the factorial through.
        for(int i = 1; i<=100; i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        int sum = 0;

        //goes through each digit of the big integer as a string and adds it to sum.
        for(int i = 0; i<factorial.toString().length(); i++){
            sum += Integer.parseInt(factorial.toString().substring(i, i+1));
        }

        System.out.println(sum);
    }
}