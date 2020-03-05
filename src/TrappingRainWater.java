/**
 * @Author JiaWei Xu
 * @Date 2020-03-04 20:08
 * @Email xjwhhh233@outlook.com
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int count=0;
        int high=0;
        for (int value : height) {
            high = Math.max(high, value);
        }
        for(int t=0;t<high;t++) {
            for (int i = 0; i < height.length;) {
                if(height[i]!=t){
                    continue;
                }
                int left = -1;
                int right = -1;
                for (int j = i - 1; j >= 0; j--) {
                    if (height[j] > height[i]) {
                        left = j;
                        break;
                    }
                }
                for (int j = i+1; j < height.length; j++) {
                    if (height[j] > height[i]) {
                        right = j;
                        break;
                    }
                }
                System.out.println("kk");
                System.out.println(left);
                System.out.println(right);
                if (left != -1 && right != -1) {
                    count += (right - left - 1) * (Math.min(height[left], height[right]) - height[i]);
                    System.out.println(count);
                    i=right+1;
                }else{
                    i++;
                }
            }
        }
        return count;
    }

    public int trap1(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }
}
