import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        if(right==-1){
            return -1;
        }
        if(right==0){
            if(nums[0]==target){
                return 0;
            }else{
                return -1;
            }
        }

        int rotate=find_rotate_index(nums);
        System.out.println(rotate);
        if(nums[rotate]==target){
            return rotate;
        }
        if(rotate==0){
            return search_sub(nums,0,right,target);
        }
        if(target<nums[0]){
            return search_sub(nums,rotate,right,target);
        }
        return search_sub(nums,0,rotate-1,target);



    }

    private int find_rotate_index(int[] nums){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=(left+right)>>1;
            if(nums[mid]>nums[mid+1]){
                return mid+1;
            }else if(nums[left]<nums[mid]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return 0;
    }

    private int search_sub(int[] nums,int left,int right,int target){
        while(left<right){
            int mid=(left+right)>>1;
            if(nums[mid]==target){
                return 0;
            }else if(target<nums[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
    }
}
