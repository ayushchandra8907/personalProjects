import java.util.Scanner;

public class day1_1 {
    public static String rev(String str){
        String newString = "";

        for(int i = str.length()-1; i>=0; i--){
            newString += str.substring(i, i+1);
        }

        return newString;
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
                for(int i = 0; i<s.length(); i++){
                    char c = s.charAt(i);
                    if(Character.isDigit(c)){
                        firstNum = Character.getNumericValue(c);
                        break;
                    }
                }
                //reverse string
                s = rev(s);
                for(int i = 0; i<s.length(); i++){
                    char c = s.charAt(i);
                    if(Character.isDigit(c)){
                        secondNum = Character.getNumericValue(c);
                        break;
                    }
                }
                System.out.println(10*firstNum + secondNum);
                sum += 10*firstNum + secondNum;
            }

        }

        System.out.println(sum);



    }
}