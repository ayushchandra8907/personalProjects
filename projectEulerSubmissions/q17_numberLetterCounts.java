public class q17_numberLetterCounts {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();

        //My first idea was the naive solution to iterate through each number, and "build" it based off the roots. For example,
        //321 is comprised of the digit "three", followed by "hundred", then "twenty" and finally "one". These roots act as building
        //blocks, and if I use the pattern they create, then I can just add those numbers to the sum.

        //Array for roots
        String[] onesRoots = {"","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tensRoots1 = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tensRoots2 = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String hund = "hundred";

        int totalLetters = 0;


        //going 1-9: adds the roots 1-9
        for(int i = 0; i<10; i++){
            totalLetters += onesRoots[i].length();
        }


        //going 10-19: adds the roots from 10-19 since they are different than 20-99
        for(int i = 0; i<10; i++){
            totalLetters += tensRoots1[i].length();
        }

        //going 20-99: This is comprised of a ten root and a ones root.
        for(int i = 0; i < 8; i++){
            for(int k = 0; k < 10; k++){
                totalLetters += tensRoots2[i].length() + onesRoots[k].length();
            }
        }

        //going 100-999: We just repeat the loops that happened before, but add the "x hundred and".
        for(int j = 1; j < 10; j++){
            String h = onesRoots[j] + hund + "and";

            //going 1-9:
            for(int i = 0; i<10; i++){
                totalLetters += h.length() + onesRoots[i].length();
            }


            //going 10-19:
            for(int i = 0; i<10; i++){
                totalLetters += h.length() + tensRoots1[i].length();
            }

            //going 20-99:
            for(int i = 0; i < 8; i++){
                for(int k = 0; k < 10; k++){
                    totalLetters += h.length() + tensRoots2[i].length() + onesRoots[k].length();
                }
            }
        }

        //final 1000: adds 1000 since we haven't added it yet
        totalLetters += "onethousand".length();

        //The reason for this subtraction is because the loops from before count the hundreds (100, 200, 300, etc) as
        //x hundred and. We have to remove the and, and since there are 9 of them we remove 27 letters.
        totalLetters -= 3*9;

        //printing total letters used
        long stopTime = System.currentTimeMillis();

        System.out.println(totalLetters);
        System.out.println("Runtime: " + (stopTime-startTime) + "ms");
    }
}