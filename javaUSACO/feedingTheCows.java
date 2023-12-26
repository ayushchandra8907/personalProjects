import java.util.Scanner;
import java.util.ArrayList;

public class feedingTheCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        String globalResultString = "";

        for(int i = 0; i<T; i++){
            //handle 2 line by 2 line
            int N = sc.nextInt();
            int K = sc.nextInt();
            sc.nextLine(); //handles the annoying newline character at the end
            String arrangment = sc.nextLine();

            //handy base case=============
            //if K = 0, then no cow moves so its a reprint
//            if(K == 0) {
//                System.out.println(N);
//                System.out.println(arrangment);
//            }

            //iterative case
            if(K != N-1) {
                ArrayList<String> grassPaths = new ArrayList<String>(); //empty lot
                for (int c = 0; c < N; c++) { //fillt he empty lot
                    grassPaths.add(".");
                }

                for (int s = 0; s < N; s++) {
                    //first check, does our thing have a valid lot to eat at?
                    String breed = arrangment.substring(s, s + 1);
                    //System.out.println(breed);

                    int lowBound = Math.max((s - K), 0);
                    int higBound = Math.min(N - 1, (s + K));

                    //System.out.println(lowBound + " " + higBound);

                    //this line will make a string of the range of array list
                    //String edibleRegion = arrangment.substring(lowBound, higBound); //wrong, we must change! point to array list not arragnmenet
                    String edibleRegion = "";

                    for (int ed = lowBound; ed <= higBound; ed++) {
                        edibleRegion += grassPaths.get(ed);
                    }

                    if (edibleRegion.indexOf(breed) != -1) {
                        //then we have the cow fed
                    } else {
                        //we got to add some food (maybe at farthest possible area?)
                        grassPaths.set(higBound, breed);
                        //System.out.println(grassPaths);
                    }
                }

                //print all our shit=====================================
                int grassNeeded = 0;
                for (String s : grassPaths) {
                    if (s.equals(".") == false) {
                        grassNeeded++;
                    }
                }

                globalResultString += grassNeeded + "\n";

                for (String s : grassPaths) {
                    globalResultString += s;
                }

                globalResultString += "\n";
            } else { //shit case where cows got infinite reach
                int grassNeeded = 2;


                globalResultString += grassNeeded + "\n";

                //add n-2 periods
                for(int p = 0; p<N-2; p++){
                    globalResultString += ".";
                }

                globalResultString += "GH\n";
            }
        }


        globalResultString = globalResultString.substring(0, globalResultString.length() -1);

        //System.out.println("===============================================");
        System.out.println(globalResultString);
    }
}