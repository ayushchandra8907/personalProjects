import java.math.BigDecimal;
public class q26_reciprocalCycles {
    public static void main(String args[]){
        BigDecimal d = new BigDecimal("1");
        d = d.divide(BigDecimal.valueOf(7));

        System.out.println(d.toString());
    }
}