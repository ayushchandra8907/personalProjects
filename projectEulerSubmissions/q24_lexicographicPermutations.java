//not finished with the problem yet

public class q24_lexicographicPermutations {
    public static int factorial(int n){
        if(n == 1 || n == 0) {
            return 1;
        } else {
            return n*factorial(n-1);
        }
    }

    public static void sort(int[] arr){
        int minDex;

        for(int i = 0; i<arr.length-1; i++){
            minDex = i;
            for(int k = i+1; k<arr.length; k++){
                if(arr[k] < arr[minDex]){
                    minDex = k;
                }

                swap(i, minDex, arr);
            }
        }
    }

    public static void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void printPermutation(int[] arr){
        for(int x:arr){
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args){
//        int[] nums = new int[]{0, 1, 2}
//
//        int target = 5;
//        int currentPerm = 1;
//        int remaining = target-currentPerm;
//
//        int pos = 0;
//        int currSize = nums.length - pos - 1;
//
//        while(remaining > 0){
//            numPerms = factorial(currSize);
//            int maxFit = remaining/numPerms;
//
//            int desiredDig = maxFit;
//
//
//
//
//        }
        int[] nums = new int[]{1, 5, 2, 6, 83, 2, 9};

        sort(nums);

        printPermutation(nums);
    }

}