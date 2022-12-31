import java.util.ArrayList;

public class q19_countingSundays {
    public static void main(String args[]){
        int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int start = 2; //january 1 1901: Tuesday
        int sundayCount = 0;

        for(int i = 1901; i<=2000; i++){
            for(int k = 0; k<12; k++){
                if((i%4 == 0 || (i%100 != 0 && i%400 == 0)) && k == 1){
                    start += 29;
                    start %= 7;
                } else {
                    start += days[k];
                    start %= 7;
                }

                if(start == 0){
                    sundayCount++;
                }
            }
        }

        if(365*100%7 == 0){
            sundayCount--;
        }

        System.out.println(sundayCount);
    }
}