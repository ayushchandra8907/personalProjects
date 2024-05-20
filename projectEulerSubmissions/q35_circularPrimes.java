// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.ArrayList;

class HelloWorld {
    public static ArrayList<Integer> globalPrimes = new ArrayList<Integer>();
    
    public static boolean isPrime(int n){
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
    
    public static ArrayList<Integer> digitize(int n){
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while(n != 0){
            digits.add(0, n%10);
            n /= 10;
        }
        return digits;
    }
    
    public static boolean containsEvenDigit(ArrayList<Integer> arr){
        for(Integer i:arr){
            if(i%2 == 0 || i == 5)
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> circularPrimes = new ArrayList<Integer>();
        circularPrimes.add(2);
        circularPrimes.add(5);
        
        for(int i = 3; i<Math.pow(10,6); i+= 2){
            ArrayList<Integer> digs = digitize(i);
            if(containsEvenDigit(digs) == false){
                
                //for each cycle of the number
                boolean circularPrime = true;
                
                for(int l = 0; l<digs.size(); l++){
                    int num = 0;
                    
                    //build the number
                    int index = l;
                    int powerIndex = digs.size()-1;
                    for(int d = 0; d<digs.size(); d++){
                        num += digs.get(index) * Math.pow(10, powerIndex);
                        
                        index++;
                        if(index == digs.size()){
                            index = 0;
                        }
                        powerIndex--;
                    }
                    
                    //now that we have number, keep checking if it's prime
                    if(globalPrimes.indexOf(num) != -1){
                        //is a prime
                    } else if(isPrime(num) == false){
                        circularPrime = false;
                        break;
                    } else{
                        globalPrimes.add(num);
                    }
                }
                
                if(circularPrime){
                    circularPrimes.add(i);
                }
                
            }
        }
        
        System.out.println(circularPrimes);
        System.out.println(circularPrimes.size());
    }
}