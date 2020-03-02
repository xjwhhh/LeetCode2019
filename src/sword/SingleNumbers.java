package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-02 09:55
 * @Email xjwhhh233@outlook.com
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        int mask = temp & (-temp);
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & mask) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
