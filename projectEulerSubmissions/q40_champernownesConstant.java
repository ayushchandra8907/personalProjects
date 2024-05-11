public class q40_champernownesConstant {
    public static void main(String[] args) {
        String frac = "";

        //makes the string of integers, just appends until the length of the string is less than the value of the last desired index
        int k = 1;
        while(frac.length() < 1000000){
            frac += k;
            k++;
        }


        //algorithm for going thru each index and multiplying the digit
        int prod = 1;
        for(int i = 0; i<7; i++) {
            int n = (int)Math.pow(10, i);
            prod *= Integer.parseInt(frac.substring(n-1, n));
        }


        System.out.println(prod);
    }
}