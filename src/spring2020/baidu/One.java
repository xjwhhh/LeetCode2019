package spring2020.baidu;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-29 18:59
 * @Email xjwhhh233@outlook.com
 */
public class One {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        BigInteger bigInteger=scanner.nextBigInteger();
        bigInteger=bigInteger.multiply(bigInteger.subtract(new BigInteger("1")));
        System.out.println(bigInteger.subtract(new BigInteger("1")));
    }
}
