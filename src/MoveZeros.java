import java.util.HashMap;
import java.util.Map;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-08 15:24
 * @Email xjwhhh233@outlook.com
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if(nums==null||nums.length<=1){
            return;
        }
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=0){
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                i++;
            }
        }

    }

    public static void main(String[] args){

        Map<Short, String> map = new HashMap<>();
        for(short i = 0; i <100; i++) {
            map.put(i, String.valueOf(i)); map.remove(i-1);
        }
        System.out.println(map.size());
    }
}
