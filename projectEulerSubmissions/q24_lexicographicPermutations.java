import java.util.ArrayList;
public class q24_lexicographicPermutations {
    public static int factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    //array methods
    public static void sortArr(ArrayList<Integer> arr, int start){
        for(int i = start; i<arr.size()-1; i++){
            int minDex = i;
            for(int k = i+1; k<arr.size(); k++){
                if(arr.get(k) < arr.get(minDex)){
                    minDex = k;
                }
                int temp = arr.get(i);
                arr.set(i, arr.get(minDex));
                arr.set(minDex, temp);
            }
        }
    }

    public static int locate(ArrayList<Integer> arr, int n, int start){ //choosing to go linear search instead of binary search since I couldn't remeber binary search and this method will only get called 9 times so complexity doesn't matter.
        for(int i = start; i<arr.size(); i++){
            if(arr.get(i) == n){
                return i;
            }
        }
        return -1;
    }

    public static void swap(ArrayList<Integer> arr, int a, int b){
        int temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }

    public static void printList(ArrayList<Integer> arr){
        for(Integer x:arr){
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args){
        int numToSort = 3;

        ArrayList<Integer> currPerm = new ArrayList<Integer>();
        for(int i = 0; i<numToSort; i++){
            currPerm.add(i);
        }

        


    }
}