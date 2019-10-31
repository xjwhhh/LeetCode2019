package lesson.three;


import java.math.BigDecimal;
import java.util.*;

public class Main33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cas =scanner.nextInt();
        while(cas>0){
            BigDecimal num = scanner.nextBigDecimal();
            String init = "12345$54321";

            while (num.compareTo(BigDecimal.valueOf(11))==1){
                int i =2;
                BigDecimal check =new BigDecimal(11);
                while (num.compareTo(check.multiply(BigDecimal.valueOf(2)).add(BigDecimal.valueOf(i)))==1){
                    check =check.multiply(BigDecimal.valueOf(2)).add(BigDecimal.valueOf(i));
                    i+=1;
                }
                num= num.subtract(check).subtract(BigDecimal.valueOf(i));
            }
            if(num.compareTo(BigDecimal.valueOf(0))<=0){
                System.out.println("$");
            }
            else {
                System.out.println(init.substring(num.intValue()-1,num.intValue()));
            }
            cas--;
        }
    }
}