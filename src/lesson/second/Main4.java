package lesson.second;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        for (int i = 0; i < num; i++) {
            long n = scan.nextLong();
            helper(n);
        }
    }

    private static void helper(long n) {
        ArrayList<Long> tt=new ArrayList<>();
        tt.add(2L);
        for(long i=3;i<n;i++){
            boolean flag=true;
            for(long j=2;j<Math.sqrt(i)+1;j++){
                if(i%j==0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                tt.add(i);
            }
        }


        long[] primes=primes(n);
            int count=0;
            for(int i=0;i<primes.length;i++){
                for(int j=i+1;j<primes.length;j++){
                    if(Math.pow(primes[i],2)*Math.pow(primes[j],2)<=n){
                        System.out.println(Math.pow(primes[i],2)*Math.pow(primes[j],2));
                        count++;
                    }

                }
                if(Math.pow(primes[i],8)<=n){
                    System.out.println(Math.pow(primes[i],8));
                    count++;
                }
            }
            System.out.println(count);
            System.out.println();


//        int count=0;
//        for(int i=0;i<tt.size();i++){
//            for(int j=i+1;j<tt.size();j++){
//                if(Math.pow(tt.get(i),2)*Math.pow(tt.get(j),2)<=n){
//                    System.out.println(Math.pow(tt.get(i),2)*Math.pow(tt.get(j),2));
//                    count++;
//                }
//            }
//            if(Math.pow(tt.get(i),8)<=n){
//                System.out.println(Math.pow(tt.get(i),8));
//                count++;
//            }
//        }
//        System.out.println(count);
//        System.out.println();
    }

    public static long[] primes(long n){
        if(n < 0){
            throw new IllegalArgumentException("N must be a non negative integer.");
        }
        if(n <= 1){
            return new long[0];
        }
        int temp=(int)Math.sqrt(n) + 1;
        boolean[] primes = new boolean[ temp]; // 加一实现下标与真实数值对应，boolean默认为false
        /* 将下标为奇数的置为true，下标为偶数的默认为false。*/
        for(int i = 1; i < temp; i++){
            if((i & 1) == 1){
                primes[i] = true;
            }
        }
        for(int k = 3, limit = (int) Math.sqrt(n); k <= limit; k += 2){
            /*将素数倍数下标处的值全部置false*/
            if(isPrime(k)){
                for(int i = k * k; i <temp; i += k){
                    primes[i] = false;
                }
            }
        }
        int primeNums = 0;
        /*获取精确的素数数量，以免开辟过大的数组造成空间不足的情况。*/
        for(boolean isPrime : primes){
            if(isPrime){
                primeNums++;
            }
        }
        long[] primeArray = new long[primeNums];
        primeArray[0] = 2;
        int count = 1;
        for(int i = 3; i <temp; i++){
            if(primes[i]){
                primeArray[count++] = i;
            }
        }
//        for(int i=0;i<primeArray.length;i++){
//            System.out.println(primeArray[i]);
//        }
        return primeArray;


    }




    private static boolean isPrime(int k){
            for(int j=2;j<Math.sqrt(k)+1;j++){
                if(k%j==0){
                    return false;
                }

        }
            return true;
    }





}
