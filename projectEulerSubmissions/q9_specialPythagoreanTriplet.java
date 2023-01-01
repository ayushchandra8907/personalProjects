public class q9_specialPythagoreanTriplet {
    public static void main(String[] args){
        //pythagorean values
        int a;
        int b;
        double c;

        //I decided to just try each triplet to see if it worked. a and b couldn't be more than 500 since that would mean
        //c would be at least 1 bigger than 500, and 500+501 is bigger than 1000. Then, I just checked if a+b+c was 1000
        //since c is dependent on a. if it was, it would print the product, which is the answer.

        for(a = 1; a<=500; a++){
            for(b = 1; b<=500; b++){
                c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                if(a+b+c == 1000){
                    System.out.println(a + " " + b + " " + c);
                    int prod = (int)(a*b*c);
                    System.out.println("Product: " + prod);
                }
            }
        }

    }
}