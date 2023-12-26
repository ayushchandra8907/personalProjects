import java.util.ArrayList;
import java.util.Scanner;

public class TESTING {
    public static boolean isSpecialChar(char c){
        return (!Character.isDigit(c)&& !Character.isLetter(c)&& !Character.isWhitespace(c) && (c != '.'));
    }

    public static int getNumb(ArrayList<String> e, int r, int c){
        String num = "";

        //find start of digit
        int start = c;
        while (start != -1 && Character.isDigit((e.get(r).charAt(start)))) {
            start--;
        }

        //goes one forward because currently its not on a number
        start++;

        //add till end of digit
        while (start != e.get(r).length() && Character.isDigit((e.get(r).charAt(start)))) {
            num += e.get(r).charAt(start);
            start++;
        }

        if(num.equals("") == false){
            return Integer.parseInt(num);
        } else {
            return 0;
        }

    }

    public static void main(String[] args){
        //collect data-------------------------------------------
        Scanner sc = new Scanner(System.in);
        boolean stopCase = false;
        ArrayList<String> engine = new ArrayList<String>();

        //collect lines from terminal
        while(!stopCase) {
            String s = sc.nextLine();

            if (s.equals("STOP") || s.equals("stop")) {
                stopCase = true;
            } else {
                engine.add(s);
            }
        }

        //alg
        int engineSum = 0;

        for(int r = 0; r<engine.size(); r++) {
            String line = engine.get(r);

            for (int c = 0; c < line.length(); c++) {
                if(isSpecialChar(line.charAt(c))){

                    //the three spaces above
                    if(r != 0){
                        String prevLine = engine.get(r-1);
                        //check up
                        if(Character.isDigit(prevLine.charAt(c))){
                            engineSum += getNumb(engine, r-1, c);
                        } else {
                            //check back diag
                            if(c != 0 && Character.isDigit(prevLine.charAt(c-1))){
                                engineSum += getNumb(engine, r-1, c-1);
                            }
                            //check fwd diag
                            if(c != prevLine.length()-1 && Character.isDigit(prevLine.charAt(c+1))){
                                engineSum += getNumb(engine, r-1, c+1);
                            }
                        }
                    }

                    //the three spaces below
                    if(r != engine.size()-1){
                        String nextLine = engine.get(r+1);
                        //check up
                        if(Character.isDigit(nextLine.charAt(c))){
                            engineSum += getNumb(engine, r+1, c);
                        } else {
                            //check back diag
                            if(c != 0 && Character.isDigit(nextLine.charAt(c-1))){
                                engineSum += getNumb(engine, r+1, c-1);
                            }
                            //check fwd diag
                            if(c != nextLine.length()-1 && Character.isDigit(nextLine.charAt(c+1))){
                                engineSum += getNumb(engine, r+1, c+1);
                            }
                        }

                    }

                    //left
                    if(c != 0 && Character.isDigit(line.charAt(c-1))){
                        engineSum += getNumb(engine, r, c-1);
                    }

                    //right
                    if(c != line.length()-1 && Character.isDigit(line.charAt(c+1))){
                        engineSum += getNumb(engine, r, c+1);
                    }
                }
            }
        }

        System.out.println(engineSum);
    }
}