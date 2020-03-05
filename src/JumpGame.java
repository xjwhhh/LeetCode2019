public class JumpGame {
    public boolean canJump(int[] nums) {
        int len=nums.length-1;
        int last=len;
        for(int i=len;i>=0;i--){
            if(i+nums[i]>=last){
                last=i;
            }
        }
        return last==0;

    }
}
