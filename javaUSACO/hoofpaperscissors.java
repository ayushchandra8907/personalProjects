import java.util.Scanner;

public class hoofpaperscissors {
    public static void main(String[] args) {
        //get data
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] games = new int[N][2];

        for(int r = 0; r<N; r++){
            games[r][0] = sc.nextInt();
            games[r][1] = sc.nextInt();
        }

        //alg
        int maxWins = 0;

        //case1: hoof = 1; paper = 2; scissors = 3
        int subWins = 0;
        for(int[] r:games){
            int c1 = r[0];
            int c2 = r[1];

            if(c1 == 1){
                if(c2 == 3){subWins++;}
            }

            if(c1 == 2){
                if(c2 == 1){subWins++;}
            }

            if(c1 == 3){
                if(c2 == 2){subWins++;}
            }
        }
        maxWins = Math.max(maxWins, subWins);

        //case2: hoof = 1; paper = 3; scissors = 2
        subWins = 0;
        for(int[] r:games){
            int c1 = r[0];
            int c2 = r[1];

            if(c1 == 1){
                if(c2 == 2){subWins++;}
            }

            if(c1 == 2){
                if(c2 == 3){subWins++;}
            }

            if(c1 == 3){
                if(c2 == 1){subWins++;}
            }
        }
        maxWins = Math.max(maxWins, subWins);

        //case3: hoof = 2; paper = 1; scissors = 3
        subWins = 0;
        for(int[] r:games){
            int c1 = r[0];
            int c2 = r[1];

            if(c1 == 1){
                if(c2 == 2){subWins++;}
            }

            if(c1 == 2){
                if(c2 == 3){subWins++;}
            }

            if(c1 == 3){
                if(c2 == 1){subWins++;}
            }
        }
        maxWins = Math.max(maxWins, subWins);

        //case4: hoof = 2; paper = 3; scissors = 1
        subWins = 0;
        for(int[] r:games){
            int c1 = r[0];
            int c2 = r[1];

            if(c1 == 1){
                if(c2 == 3){subWins++;}
            }

            if(c1 == 2){
                if(c2 == 1){subWins++;}
            }

            if(c1 == 3){
                if(c2 == 2){subWins++;}
            }
        }
        maxWins = Math.max(maxWins, subWins);

        //case5: hoof = 3; paper = 1; scissors = 2
        subWins = 0;
        for(int[] r:games){
            int c1 = r[0];
            int c2 = r[1];

            if(c1 == 1){
                if(c2 == 3){subWins++;}
            }

            if(c1 == 2){
                if(c2 == 1){subWins++;}
            }

            if(c1 == 3){
                if(c2 == 2){subWins++;}
            }
        }
        maxWins = Math.max(maxWins, subWins);

        //case6: hoof = 3; paper = 2; scissors = 1
        subWins = 0;
        for(int[] r:games){
            int c1 = r[0];
            int c2 = r[1];

            if(c1 == 1){
                if(c2 == 2){subWins++;}
            }

            if(c1 == 2){
                if(c2 == 3){subWins++;}
            }

            if(c1 == 3){
                if(c2 == 1){subWins++;}
            }
        }
        maxWins = Math.max(maxWins, subWins);

        //end
        System.out.println(maxWins);
    }
}