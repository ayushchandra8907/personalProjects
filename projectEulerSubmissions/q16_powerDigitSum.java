import java.math.BigInteger;

public class q16_powerDigitSum {
    public static void main(String args[]){
        BigInteger pow = new BigInteger("1");

        for(int i = 0; i<1000; i++){
            pow = pow.multiply(BigInteger.valueOf(2));
        }

        String strPow = pow.toString();
        long powerDigitSum = 0;

        for(int i = 0; i<strPow.length(); i++){
            powerDigitSum += Integer.parseInt(strPow.substring(i, i+1));
        }

        System.out.println(pow.toString());
        System.out.println(powerDigitSum);
    }
}