package spring2020.kuaishoubishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-22 18:57
 * @Email xjwhhh233@outlook.com
 */
public class One {
    public static void main(String[] args){
//        Scanner scanner=new Scanner(System.in);

        int[] a={};
    }

    public int[] DistanceToHigher (int[] height) {
        // write code here
        int[] result=new int[height.length];
        Arrays.fill(result,0);
        for(int i=1;i<result.length;i++){
            for(int j=i-1;j>=0;j--){
                if(height[j]>height[i]){
                    result[i]=i-j;
                    break;
                }
            }
        }
        return result;
    }
}
