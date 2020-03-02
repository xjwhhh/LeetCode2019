package sword;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-02 10:31
 * @Email xjwhhh233@outlook.com
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        int low = 1;
        int high = 2;
        int sum = low + high;
        List<int[]> list = new ArrayList<>();
        while(low < high && high < target) {
            if(sum < target) {
                high++;
                sum+=high;
            }else if(sum > target){
                sum -= low;
                low++;
            }else {
                int [] sub = new int[high-low+1];
                int j = low;
                for(int i = 0;i<high - low+1;i++,j++) {
                    sub[i] = j;
                }
                list.add(sub);
                sum -= low;
                low++;
            }
        }
        int[][] out = new int[list.size()][];

        return list.toArray(out);
    }
}
