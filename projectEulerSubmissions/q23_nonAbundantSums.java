import java.util.ArrayList;

public class q23_nonAbundantSums {
    public static int d(int n){
        int s = 1;

        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                s += i + n/i;
            }
        }

        return s;
    }

    public static void main(String[] args){
        long start = System.currentTimeMillis();

        ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();

        for(int i = 1; i<28123; i++){
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

        long max = 28123*28124/2;
        long sum = 0;

        for(int i = 0; i<abundantNumbers.size(); i++){
            for(int k = i; k<abundantNumbers.size(); k++){
                if(abundantNumbers.get(i) + abundantNumbers.get(k) < 28123){
                    sum += (abundantNumbers.get(i) + abundantNumbers.get(k));
                }

            }
        }

        System.out.println("Runtime: " + (System.currentTimeMillis()-start) + "ms");
        System.out.println(max);
        System.out.println(sum);

    }
}
