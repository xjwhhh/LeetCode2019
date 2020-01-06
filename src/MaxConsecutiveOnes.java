/**
 * @Author JiaWei Xu
 * @Date 2020-01-06 16:32
 * @Email xjwhhh233@outlook.com
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int count=0;
        for(int num:nums){
            if(num==1){
                count++;
            }else{
                if(count>max){
                    max=count;
                }
                count=0;
            }
        }
        if(count>max){
            max=count;
        }
        return max;

    }
}
