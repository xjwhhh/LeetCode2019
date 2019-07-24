public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int p=0;
        int q=nums.length-1;
        while(p<=q){
            int mid=(p+q)/2;
            if(target==nums[mid]){
                return mid;
            }else if(target>nums[mid]){
                p=mid+1;
            }else{
                q=mid-1;
            }
        }
        return p;

    }
}
