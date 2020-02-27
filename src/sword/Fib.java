package sword;

import java.util.LinkedList;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-27 16:56
 * @Email xjwhhh233@outlook.com
 */
public class Fib {


    public int fib(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int result= fib(n-1)+fib(n-2);
        if(result>1000000007){
            result=Math.floorMod(result,1000000007);
        }
        return result;

    }


    public int fib1(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }

        int[] array=new int[n];
        array[0]=0;
        array[1]=1;
        for(int i=2;i<n;i++){
            array[i]=array[i-1]+array[i-2];
            if(array[i]>1000000007){
                array[i]=Math.floorMod(array[i],1000000007);
            }
        }
        return array[n-1];
    }

}
