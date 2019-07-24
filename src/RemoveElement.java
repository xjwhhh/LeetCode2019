public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                result++;
            }else{
                int j=i+1;
                while(j<nums.length&&nums[j]==val){
                    j++;
                }
                if(j<nums.length){
                    nums[i]=nums[j];
                    nums[j]=val;
                    result++;
                }else{
                    break;
                }
            }
        }
        return result;

    }
}
