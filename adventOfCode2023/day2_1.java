import java.util.ArrayList;
import java.util.Scanner;

public class day2_1 {
    public static void main(String[] args){
        //handleing data
        Scanner sc = new Scanner(System.in);
        ArrayList<String> games = new ArrayList<String>();
        int n = 100; //number of games

        for(int i = 0; i<n; i++){
            games.add(sc.nextLine());
        }


        //alg
        int sumOfIds = 0;

        for(int i = 1; i<=n; i++){
            //gets just the games
            String vals = games.get(i-1).substring(8);

            boolean violated = false;

            //check 1: blue violated
            //locate num
            for(int k = 0; k<vals.length()-5; k++){
                if(Character.isDigit(vals.charAt(k))){
                    if(!(vals.charAt(k+1) == ' ')){
                        if(vals.charAt(k+3) == 'r'){
                            int num = Integer.parseInt(vals.substring(k, k+2));
                            if(num>12){violated = true;}
                        }
                        if(vals.charAt(k+3) == 'g'){
                            int num = Integer.parseInt(vals.substring(k, k+2));
                            if(num>13){violated = true;}
                        }
                        if(vals.charAt(k+3) == 'b'){
                            int num = Integer.parseInt(vals.substring(k, k+2));
                            if(num>14){violated = true;}
                        }
                    }
                }

            }

            if(!violated){
                sumOfIds += i;
            }
        }

        System.out.println(sumOfIds);
    }
}