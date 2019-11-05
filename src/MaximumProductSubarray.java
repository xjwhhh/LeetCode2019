import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int imax = nums[0];
        int imin = nums[0];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);
            max = Math.max(max, imax);
            System.out.println(max);
        }

        return max;

    }
}
