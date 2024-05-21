// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.ArrayList;

class HelloWorld {
    public static ArrayList<Integer> digitize(int n){
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while(n != 0){
            digits.add(0, n%10);
            n /= 10;
        }
        return digits;
    }
    
    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<Integer>();
        
        //the upper bound 10^6 was analyzed by identifying that 10^n grows faster than the max value of the sum, which is n*9^5. Analyzing the graph shows that the lowest integeger where 10^n is greater is n=6
        for(int i = 2; i<Math.pow(10,6); i++){
            ArrayList<Integer> digs = digitize(i);
            int sum = 0;
            for(Integer k:digs){
                sum += Math.pow(k, 5);
            }
            if(sum == i)
                nums.add(i);
        }
        
        System.out.println(nums);
        int total = 0;
        for(Integer n:nums)
            total += n;
        
        System.out.println(total);
    }
}