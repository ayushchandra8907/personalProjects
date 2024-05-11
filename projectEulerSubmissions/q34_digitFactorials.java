import java.util.ArrayList;

public class q34_digitFactorials {
    //this is for turning a number into a list so that we can take each digit and factorial it
    public static ArrayList<Integer> num_to_array(int n){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(n>0){
            int dig = n%10;
            arr.add(0, dig);
            n /= 10;
        }
        return arr;
    }

    public static void main(String args[]) {
        //prewrote the first 10 (including 0) factorials to save computation time as calculating factorials is now O(n). We don't need factorials after 9 because no digit is greater than 9
        int[] factorials = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

        int totalSum = 0;

        //very generous upperbound determined from reasoning.
        int UPPER_BOUND = 5000000;
        for(int i = 3; i <= UPPER_BOUND; i++){
            ArrayList<Integer> digs = num_to_array(i);

            int sum = 0;
            for(Integer d: digs){
                sum += factorials[d];
            }

            if(sum == i) {
                System.out.println(i);
                totalSum += i;
            }
        }

        System.out.println("\n\n" + totalSum);

    }
}