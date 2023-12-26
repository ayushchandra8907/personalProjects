import java.util.Scanner;
import java.util.ArrayList;

public class day1_2 {
    public static String rev(String str){
        String newString = "";

        for(int i = str.length()-1; i>=0; i--){
            newString += str.substring(i, i+1);
        }

        return newString;
    }

    public static boolean containsStringNum(String s){
        return s.indexOf("one")  != -1 ||
                s.indexOf("two")  != -1||
                s.indexOf("three") != -1 ||
                s.indexOf("four") != -1 ||
                s.indexOf("five") != -1 ||
                s.indexOf("six") != -1 ||
                s.indexOf("seven") != -1 ||
                s.indexOf("eight") != -1 ||
                s.indexOf("nine") != -1;
    }

    public static ArrayList<Integer> findNums(String s){
        ArrayList<Integer> nums = new ArrayList<Integer>();
        ArrayList<Integer> indexes = new ArrayList<Integer>();

        //DIGIT CASES
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                nums.add(Character.getNumericValue(c));
                indexes.add(i);
            }
        }

        //LETTER CASES
        //three letter cases
        for(int i = 0; i<s.length() - 2; i++){
            if(s.substring(i, i+3).equals("one")){
                nums.add(1);
                indexes.add(i);
            }
            if(s.substring(i, i+3).equals("two")){
                nums.add(2);
                indexes.add(i);
            }
            if(s.substring(i, i+3).equals("six")){
                nums.add(6);
                indexes.add(i);
            }
        }

        //four letter cases
        for(int i = 0; i<s.length() - 3; i++){
            if(s.substring(i, i+4).equals("four")){
                nums.add(4);
                indexes.add(i);
            }
            if(s.substring(i, i+4).equals("five")){
                nums.add(5);
                indexes.add(i);
            }
            if(s.substring(i, i+4).equals("nine")){
                nums.add(9);
                indexes.add(i);
            }
        }

        //five letter cases
        for(int i = 0; i<s.length() - 4; i++){
            if(s.substring(i, i+5).equals("three")){
                nums.add(3);
                indexes.add(i);
            }
            if(s.substring(i, i+5).equals("seven")){
                nums.add(7);
                indexes.add(i);
            }
            if(s.substring(i, i+5).equals("eight")){
                nums.add(8);
                indexes.add(i);
            }
        }

        //sort indexes - selection sort;
        selectionSort(indexes, nums);

        return nums;
    }

    public static void selectionSort(ArrayList<Integer> a, ArrayList<Integer> b){
        for(int i = 0; i<a.size()-1; i++){
            int mindex = i;

            for(int k = i+1; k<a.size(); k++){
                if(a.get(k) < a.get(mindex)){
                    mindex = k;
                }
            }

            //swap
            int tem1 = a.get(i);
            int tem2 = b.get(i);

            a.set(i, a.get(mindex));
            b.set(i, b.get(mindex));

            a.set(mindex, tem1);
            b.set(mindex, tem2);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        boolean stopCase = false;
        int firstNum = 0;
        int secondNum = 0;

        int sum = 0;

        while(!stopCase){
            String s = sc.nextLine();
            if(s.equals("STOP")){
                stopCase = true;
            } else {
                //if normal and doesnt contain any word numbers, do like normal
                if(!containsStringNum(s)){
                    //finds first
                    for(int i = 0; i<s.length(); i++){
                        char c = s.charAt(i);
                        if(Character.isDigit(c)){
                            firstNum = Character.getNumericValue(c);
                            break;
                        }
                    }
                    //reverse string
                    s = rev(s);

                    //finds second
                    for(int i = 0; i<s.length(); i++){
                        char c = s.charAt(i);
                        if(Character.isDigit(c)){
                            secondNum = Character.getNumericValue(c);
                            break;
                        }
                    }

                    //System.out.println(10*firstNum + secondNum);
                    sum += 10*firstNum + secondNum;
                }

                //if gay
                if(containsStringNum(s)){
                    ArrayList<Integer> nums = findNums(s);
                    firstNum = nums.get(0);
                    secondNum = nums.get(nums.size()-1);

                    //System.out.println(10*firstNum + secondNum);
                    sum += 10*firstNum + secondNum;
                }
            }

        }

        System.out.println(sum);
    }
}