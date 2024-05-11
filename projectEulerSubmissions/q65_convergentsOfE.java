import java.util.ArrayList;
import java.math.BigInteger;

public class q65_convergentsOfE {
    public static void main(String[] args) {
        ArrayList<Integer> series = new ArrayList<Integer>();
        series.add(2);

        int N = 100;
        int k = 2;

        for(int i = 0; i<N-1; i++){
            if(i%3 == 1){
                series.add(k);
                k += 2;
            } else {
                series.add(1);
            }
        }


        //setting up for contineud fraction alg
        series.add(0, 0);
        series.add(0, 0);

        //alg
        ArrayList<BigInteger> numerator = new ArrayList<BigInteger>();
        ArrayList<BigInteger> denominator = new ArrayList<BigInteger>();

        numerator.add(new BigInteger("0")); numerator.add(BigInteger.ONE);
        denominator.add(BigInteger.ONE); denominator.add(new BigInteger("0"));


        //nice way of calculating convergents using a table
        for(int i = 2; i<series.size(); i++){
            BigInteger num = BigInteger.valueOf(series.get(i)).multiply(numerator.get(i-1)).add(numerator.get(i-2));
            BigInteger denom = BigInteger.valueOf(series.get(i)).multiply(denominator.get(i-1)).add(denominator.get(i-2));

            numerator.add(num);
            denominator.add(denom);
        }

        //printing
        for(int i = 2; i<numerator.size(); i++){
            System.out.println(numerator.get(i) + "/" + denominator.get(i));
        }

        System.out.println();

        String last_num  = numerator.get(numerator.size() - 1).toString();
        int sum = 0;
        for(int i = 0; i<last_num.length(); i++){
            sum += Integer.parseInt(last_num.substring(i, i+1));
        }
        System.out.println(sum);


    }
}