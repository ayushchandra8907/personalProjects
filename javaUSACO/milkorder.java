import java.util.ArrayList;
import java.util.Scanner;

public class milkorder {
    public static boolean contains(int[] arr, int n){
        for(int a:arr){
            if(a == n){return true;}
        }
        return false;
    }

    public static int find(int[] arr, int n){
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == n){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[] officialLineup = new int[N];
        int[] socialHeiarchy = new int[M];

        // get the m
        for(int i = 0; i< socialHeiarchy.length; i++){
            socialHeiarchy[i] = sc.nextInt();
        }

        // handle the ks
        for(int i = 0; i<K; i++){
            int cow = sc.nextInt();
            int index = sc.nextInt();

            officialLineup[index-1] = cow;
        }

        //alg time
        int placingIndex = officialLineup.length-1;

        for(int mInd = socialHeiarchy.length-1; mInd >= 0; mInd--){
            int cow = socialHeiarchy[mInd];

            if(contains(officialLineup, cow)){
                //placing index skipps to the index after the cow
                placingIndex = find(officialLineup, cow) - 1;

            } else {
                //look for first availible spot IF NOT 1
                if(cow != 1){ //
                    boolean cowPlaced = false;
                    while(cowPlaced == false){
                        if(officialLineup[placingIndex] != 0){
                            placingIndex--;
                        } else {
                            officialLineup[placingIndex] = cow;
                            cowPlaced = true;
                        }
                    }
                } //placing at least possible spot. what we will do is ignore the 1 until the very end. then we can make it follow the heircy
            }

        }

        //NOW we have the array. 2 cases to deal with - first is a spot is empty and ready to go.
        //first case is when 1 is NOT in social heirchy
        int placeDex = 0;

        if(contains(socialHeiarchy, 1) == false){
            //look for first index of 1
            placeDex = find(officialLineup, 0);
            officialLineup[placeDex] = 1;
        } else {
            int lowerB = 0;
            int upperB = 0;

            if(socialHeiarchy[0] != 1){ //if its not the first index, then set lowerb equal to whatever is before the heircy
                lowerB = find(socialHeiarchy, 1)-1;
            } else {
                placeDex = find(officialLineup, 0);
            }

            if(socialHeiarchy[socialHeiarchy.length-1] != 1){
                upperB = find(socialHeiarchy, 1)+1;
            } else { //if 1 is last, place it in first immediate cell
                placeDex = find(officialLineup, socialHeiarchy[socialHeiarchy.length-2]);

                while(officialLineup[placeDex] != 0){
                    placeDex++;
                }
            }

            //System.out.println(lowerB + " " + upperB);

            //gay case - 1 is inbetween two shits
            int cowLow = find(officialLineup, socialHeiarchy[lowerB]);
            int cowHigh = find(officialLineup, socialHeiarchy[upperB]);

            if(cowLow + 1 == cowHigh){
                placeDex = find(officialLineup, socialHeiarchy[lowerB]);
            } else {
                placeDex = find(officialLineup, socialHeiarchy[lowerB]) + 1;
                while(officialLineup[placeDex] != 0){
                    placeDex++;
                }
            }
        }




        //print array to see what to work with
        System.out.print(placeDex + 1);

//        for(int i:officialLineup){
//            System.out.print(i + " ");
//        }
    }
}