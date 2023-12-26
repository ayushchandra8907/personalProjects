import java.util.Scanner;

public class herdle {
    public static void main(String[] args){
        //get data
        Scanner sc = new Scanner(System.in);

        char[][] answer = new char[3][3];
        char[][] guess = new char[3][3];
        boolean[][] considered = new boolean[3][3];

        //answer
        for(int i = 0; i<3; i++){
            String line = sc.nextLine();
            answer[i][0] = line.charAt(0);
            answer[i][1] = line.charAt(1);
            answer[i][2] = line.charAt(2);
        }

        //guess
        for(int i = 0; i<3; i++){
            String line = sc.nextLine();
            guess[i][0] = line.charAt(0);
            guess[i][1] = line.charAt(1);
            guess[i][2] = line.charAt(2);
        }

        //alg time-------------------

        int numGreen = 0;
        int numYellow = 0;

        for(int r = 0; r<3; r++){
            for(int c = 0; c<3; c++){
                //first check: is it a 1:1 match?
                if(answer[r][c] == guess[r][c]){
                    considered[r][c] = true;
                    numGreen++;
                } else { //second check: does it exist elsewhere?
                    for(int r1 = 0; r1<3; r1++){
                        for(int c1 = 0; c1<3; c1++){
                            if(guess[r][c] == answer[r1][c1]){
                                if(considered[r1][c1] == false){
                                    considered[r1][c1] = true;
                                    numYellow++;
                                    break;
                                }
                            }
                        }
                    }
                }



            }
        }


        System.out.println(numGreen);
        System.out.println(numYellow);

    }
}