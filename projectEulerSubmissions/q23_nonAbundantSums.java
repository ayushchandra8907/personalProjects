import java.util.ArrayList;

public class q23_nonAbundantSums {
    public static int d(int n){
        int s = 1;

        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                if(i != n/i){
                    s += i + n/i;
                } else { //handles case that it is a perfect square so it doesnt add the smae thing twice.
                    s += i;
                }
            }
        }

        return s;
    }

    public static boolean isAbundant(int n){
        return d(n) > n;
    }

    public static void main(String[] args){
        //start time for the prog
        long start = System.currentTimeMillis();

        ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();

        for(int i = 2; i< 28123; i++){
            if(d(i) > i){
                abundantNumbers.add(i);
            }
        }

        abundantNumbers.remove(0);

        System.out.print("{");
        for(Integer x:abundantNumbers){
            System.out.print(x + ", ");
        }
        System.out.println("}");

        System.out.println(abundantNumbers.size());


        System.out.println("Runtime: " + (System.currentTimeMillis()-start) + "ms");


    }
}
