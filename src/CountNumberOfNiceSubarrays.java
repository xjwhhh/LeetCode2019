/**
 * @Author JiaWei Xu
 * @Date 2020-04-21 10:53
 * @Email xjwhhh233@outlook.com
 */
public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return 0;
        }
        // 双指针
        int left = 0, right = 0;
        int count = 0; // 连续子数组中奇数的个数
        int res = 0;
        int preEven = 0; // 记录第一个奇数前面的偶数个数
        while (right < nums.length){
            // 连续子数组中奇数个数不够
            if (count < k){
                if (nums[right] % 2 != 0) {
                    count++;
                }
                right++; // 移动右侧指针
            }
            // 连续子数组中奇数个数够了，看第一个奇数前面有多少个偶数
            if (count == k) {
                preEven = 0;
                while (count == k){
                    res++;
                    if (nums[left] % 2 != 0) {
                        count--;
                    }
                    left++;
                    preEven++;
                }
            } else {
                res += preEven;
            } // 每次遇到 right 为偶数的时候就进行累加 相当于区间前面偶数个数 * 后面偶数个数
        }
        return res;
    }


}
