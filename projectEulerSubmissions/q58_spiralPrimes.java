import java.util.ArrayList;

class HelloWorld {
    public static ArrayList<Integer> global_primes = new ArrayList<Integer>();
    
    public static boolean isPrime(int n){
        if(n <= 1){
            return false;
        }
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args){
        
        ArrayList<Integer> list1 = new ArrayList<Integer>(); //upright
        ArrayList<Integer> list2 = new ArrayList<Integer>();  //upleft
        ArrayList<Integer> list3 = new ArrayList<Integer>(); //downleft
        
        list1.add(1); list2.add(1); list3.add(1);
        
        double proportion = 1.0;
        int index = 1;
        int primes = 0;
        
        while(proportion >= .1){
            //add terms to series
            //list 1
            list1.add(list1.get(index-1) + (2+8*(index-1)));
            list2.add(list2.get(index-1) + (4+8*(index-1)));
            list3.add(list3.get(index-1) + (6+8*(index-1)));

            //calculate new proportion
            if(isPrime(list1.get(index-1) + (2+8*(index-1)))){
                primes++;
            }
            if(isPrime(list2.get(index-1) + (4+8*(index-1)))){
                primes++;
            }
            if(isPrime(list3.get(index-1) + (6+8*(index-1)))){
                primes++;
            }
            
            double size = (double)(index+1) + 3*(index);
            proportion = primes/size;
            
            index++;
        }
        
        System.out.println("Side length: " + ((index-1)*2 + 1));
        
        
       
    }
}