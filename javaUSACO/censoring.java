import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class censoring {
    public static void main(String[] args) throws IOException {
        // initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("censor.in")); //all the input commands
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("censor.out"))); //all the output commands

        //line 1
        StringTokenizer st = new StringTokenizer(br.readLine()); //takes each line to read (re initialize this for eqach new line)
        String str = st.nextToken();

        st = new StringTokenizer(br.readLine());

        String code = st.nextToken();



        //alg time

        for(int i = 0; i<str.length()-code.length(); i++){
            if(str.substring(i, i+code.length()).equals(code)){
                //remove and then go back the length of code
                if(str.endsWith(code) == false){
                    str = str.substring(0, i) + str.substring(i+code.length());
                    i -= code.length()*2;

                    if(i < 0){
                        i = 0;
                    }
                } else {
                    str.substring(0, i);
                }
            }
        }


        pw.print(str);
        pw.close();
    }
}