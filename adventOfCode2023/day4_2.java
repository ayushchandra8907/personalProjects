import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class day4_2 {
    public static int[][] isolateNumbers(String game) { //MAKE SURE TO CHANGE THE BOUNDS FOR THE ARRAY
        int[][] nums = new int[10][25];
        String extractedNums = game.substring(game.indexOf(":") + 2);

        //fill the first array
        int count = 0;
        for(int i = 0; i < extractedNums.indexOf("|"); i+=3){
            String num = extractedNums.substring(i, i+2);
            //handles one digit case
            if(num.startsWith(" ")){
                num = num.substring(1);
            }

            nums[0][count] = Integer.parseInt(num);
            count++;
        }

        String extractedNums2 = game.substring(game.indexOf("|"));
        extractedNums2 = extractedNums2.substring(2);

        //fill the second array
        count = 0;
        for(int i = 0; i < extractedNums2.length(); i+=3){
            String num = extractedNums2.substring(i, i+2);
            //handles one digit case
            if(num.startsWith(" ")){
                num = num.substring(1);
            }

            nums[1][count] = Integer.parseInt(num);
            count++;
        }

        return nums;
    } //MAKE SURE TO CHANGE THE DIMENSIONS FOR THE 2D ARRAY

    public static int getValueOfGame(String gameID) {
        int count = 0;

        //take the 2d array formed by the game id
        int[][] gameNums = isolateNumbers(gameID);

        //take an element from the first array. search second array if that value is in it. if so, add 1 to counter
        for(int n1 = 0; n1 < gameNums[0].length; n1++){
            int num1 = gameNums[0][n1];
            for(int n2 = 0; n2 < gameNums[1].length; n2++){
                int num2 = gameNums[1][n2];

                if(num1==num2){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = 198;
        ArrayList<String> inputs = new ArrayList<String>();

        for(int i = 0; i<N; i++){
            inputs.add(sc.nextLine());
        }


        //alg time
        int[] numOfCards = new int[N];
        Arrays.fill(numOfCards, 1);

        //loop thru each index of numOfCards
        //take that value and make a diff loop

        for(int i = 0; i<numOfCards.length; i++){
            int cards = numOfCards[i];

            for(int k = 0; k<cards; k++){
                //see how many winnings
                int winnings = getValueOfGame(inputs.get(i));

                //keep adding to next one, with condition check
                for(int j = 1; j<=winnings; j++){
                    if(i+j < numOfCards.length){
                        numOfCards[i+j] += 1;
                    }
                }
            }
        }

        //get sum of number of cards
        int sumOfCards = 0;

        for(int c:numOfCards){
            sumOfCards += c;
        }

        System.out.println(sumOfCards);

    }
}