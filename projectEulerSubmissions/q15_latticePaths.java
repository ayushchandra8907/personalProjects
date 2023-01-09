import java.math.BigInteger;

public class q15_latticePaths {
    public static void main(String[] args){
        //This problem can be solved using the nCr formula, since we are travelling in 40 moves and out of those 40, we
        //need to be able to "choose" 20 of them to be down. the nCr formula is n!/(n-r)!/r!. The only problem is that the
        //numbers get very big, so I decided to use the BigInteger class offered by java.

        //initilizing each varible, with C being the answer. We subsitute the 40 for n and 20 for r.
        BigInteger A = new BigInteger("1");
        BigInteger B = new BigInteger("1");
        BigInteger C = new BigInteger("1");

        //setting A equal to 40!
        for(int i = 1; i<=40; i++){
            A = A.multiply(BigInteger.valueOf(i));
        }

        //setting B equal to 20!
        for(int i = 1; i<=20; i++){
            B = B.multiply(BigInteger.valueOf(i));
        }

        //this expression is just 40!/(20!*20!)
        C = A.divide(B.multiply(B));

        //prints the answer.
        System.out.println(C.toString());
    }
}
