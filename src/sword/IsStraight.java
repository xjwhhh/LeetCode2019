package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-02 12:03
 * @Email xjwhhh233@outlook.com
 */
public class IsStraight {
    public boolean isStraight(int[] nums) {
        if(nums==null||nums.length!=5){
            return false;
        }
        boolean[] m=new boolean[15];
        int minValue = 14, maxValue = 0;
        for (int item : nums) {
            if (item == 0) {
                continue;
            }
            if (m[item]) {
                return false;
            }
            m[item] = true;
            minValue = Math.min(minValue, item);
            maxValue = Math.max(maxValue, item);
        }
        return maxValue - minValue + 1 <= 5;
    }
}
