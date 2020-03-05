import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-05 10:03
 * @Email xjwhhh233@outlook.com
 */
public class Candy {
    public int candy(int[] ratings) {
        int[] left=new int[ratings.length];
        int[] right=new int[ratings.length];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for(int i=1;i<left.length;i++){
            if(ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            }
        }
        for(int i=right.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                right[i]=right[i+1]+1;
            }
        }
        int result=0;
        for(int i=0;i<left.length;i++){
            result+=Math.max(left[i],right[i]);
        }
        return result;

    }
}
