import java.util.ArrayList;
import java.util.Scanner;

public class day2_2 {
    public static int maxOfArrayList(ArrayList<Integer> a){
        int max = 0;
        for(int i = 0; i<a.size(); i++){
            if(a.get(i) > max){
                max = a.get(i);
            }
        }
        return max;
    }


    public static void main(String[] args){
        //handleing data
        Scanner sc = new Scanner(System.in);
        ArrayList<String> games = new ArrayList<String>();
        int n = 100; //number of games

        for(int i = 0; i<n; i++){
            games.add(sc.nextLine());
        }


        //alg
        int sumOfPowers = 0;

        for(int k = 1; k<=n; k++){
            //gets just the games
            String vals = games.get(k-1).substring(7);

            ArrayList<Integer> redCubeNums = new ArrayList<Integer>();
            ArrayList<Integer> greenCubeNums = new ArrayList<Integer>();
            ArrayList<Integer> blueCubeNums = new ArrayList<Integer>();


            //iterate thru for all cube colors
            for(int i = 0; i<vals.length(); i++){
                //red cubes
                if(vals.charAt(i) == 'r' && vals.charAt(i-1) != 'g'){
                    int cubeNum = 0;

                    //c1 - 2 dig number
                    if(vals.charAt(i-3) != ' '){
                        cubeNum = Integer.parseInt(vals.substring(i-3, i-1));
                        redCubeNums.add(cubeNum);
                    } else { //else it is a 1 digit number (assuming that there are no three digit numbers
                        cubeNum = Integer.parseInt(vals.substring(i-2, i-1));
                        redCubeNums.add(cubeNum);
                    }
                }

                //green cubes
                if(vals.charAt(i) == 'g'){
                    int cubeNum = 0;

                    //c1 - 2 dig number
                    if(Character.isDigit(vals.charAt(i-3))){
                        cubeNum = Integer.parseInt(vals.substring(i-3, i-1));
                        greenCubeNums.add(cubeNum);
                    } else { //else it is a 1 digit number (assuming that there are no three digit numbers
                        cubeNum = Integer.parseInt(vals.substring(i-2, i-1));
                        greenCubeNums.add(cubeNum);
                    }
                }

                //blue cubes
                if(vals.charAt(i) == 'b'){
                    int cubeNum = 0;

                    //c1 - 2 dig number
                    if(Character.isDigit(vals.charAt(i-3))){
                        cubeNum = Integer.parseInt(vals.substring(i-3, i-1));
                        blueCubeNums.add(cubeNum);
                    } else { //else it is a 1 digit number (assuming that there are no three digit numbers
                        cubeNum = Integer.parseInt(vals.substring(i-2, i-1));
                        blueCubeNums.add(cubeNum);
                    }
                }
            }

            sumOfPowers += (maxOfArrayList(redCubeNums))*(maxOfArrayList(greenCubeNums))*(maxOfArrayList(blueCubeNums));

        }

        System.out.println(sumOfPowers);
    }
}