import java.util.Scanner;

public class leaders {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //get data
        int N = sc.nextInt();
        int[] e = new int[N];

        String order = sc.nextLine();
        order = sc.nextLine();

        e[0] = sc.nextInt();

        for(int i = 1; i<N; i++){
            e[i] = sc.nextInt();
        }

        ///reversed string of order
        String revOrder = "";
        for(int i = order.length() - 1; i>=0; i--){
            revOrder += order.substring(i, i+1);
        }

        //alg
        int count = 0;

        //c1 - H has ALL==================================================
        int firstOccuranceOfH = order.indexOf("H"); //i'th cow
        int lastOccuranceOfH = order.length() - 1 - revOrder.indexOf("H"); //last cow of H


        if(e[firstOccuranceOfH] - 1 >= lastOccuranceOfH){
            //h got all

            //see how many versions of G fit the criteria
            for(int i = 0; i<firstOccuranceOfH; i++){
                int reach = e[i] - 1;

                //c1.1 - contains the other leader
                if(order.charAt(i) == 'G' && reach >= firstOccuranceOfH){
                    count ++;
                }
            }

            //c1.2 - contains the whole gang
            int firstOccuranceOfG = order.indexOf("G"); //i'th cow
            int lastOccuranceOfG = order.length() - 1 - revOrder.indexOf("G"); //last cow of G
            if(e[firstOccuranceOfG] - 1 >= lastOccuranceOfG){
                count++;
            }
        }

        //c2 - G has ALL==================================================
        int firstOccuranceOfG = order.indexOf("G"); //i'th cow
        int lastOccuranceOfG = order.length() - 1 - revOrder.indexOf("G"); //last cow of G


        if(e[firstOccuranceOfG] - 1 >= lastOccuranceOfG){
            //h got all

            //see how many versions of G fit the criteria
            for(int i = 0; i<firstOccuranceOfG; i++){
                int reach = e[i] - 1;

                if(order.charAt(i) == 'H' && reach >= firstOccuranceOfG){
                    count ++;
                }
            }
        }

        System.out.println(count);

    }
}