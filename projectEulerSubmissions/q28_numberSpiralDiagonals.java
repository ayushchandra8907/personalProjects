import java.util.ArrayList;

public class q28_numberSpiralDiagonals {

    //writing out the first 4 terms of the series shows a pattern.
    //the pattern is adding 8 to the amount you added previously.
    //this method modularizes/generalizes the process to all 4 series to be calculated separately.
    public static void executeSeries(ArrayList<Integer> s, int l, int start_add){
        int length = l/2 + 1;
        //calculate series 1
        for(int i = 1; i<length; i++) {
            int next = (start_add + 8*(i-1)) + s.get(i - 1);
            s.add(next);
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> series1 = new ArrayList<Integer>();
        ArrayList<Integer> series2 = new ArrayList<Integer>();
        ArrayList<Integer> series3 = new ArrayList<Integer>();
        ArrayList<Integer> series4 = new ArrayList<Integer>();
        series1.add(1); series2.add(1); series3.add(1); series4.add(1);

        int sizeOfGrid = 1001;

        executeSeries(series1, sizeOfGrid, 8);
        executeSeries(series2, sizeOfGrid, 2);
        executeSeries(series3, sizeOfGrid, 4);
        executeSeries(series4, sizeOfGrid, 6);


        //getting total sum
        int sum = -3; //starts at -3 because we need to subtract 3 extra 1s, since start term of all series is the same
        for(int i = 0; i<series1.size(); i++){
            sum += series1.get(i) + series2.get(i) + series3.get(i) + series4.get(i);
        }

        System.out.println(sum);

    }
}