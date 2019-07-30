public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int point=-1;
        if(right==-1){
            return new int[]{-1,-1};
        }
        if(right==0){
            if(nums[0]==target){
                return new int[]{0,0};
            }else{
                return new int[]{-1,-1};
            }
        }
        while(left<right){
            int mid=(left+right)>>1;
            if(nums[mid]==target){
                point=mid;
                break;
            } else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        if(point==-1){
            return new int[]{-1,-1};
        }else{
            int i=point;
            int j=point;
            while(i>=1&&nums[i]==target){
                i--;
            }
            i++;
            if(i==1&&nums[0]==target){
                i--;
            }
            while(j<nums.length-1&&nums[j]==target){
                j++;
            }
            j--;
            if(j==nums.length-2&&nums[nums.length-1]==target){
                j++;
            }
            return new int[]{i,j};
        }


    }
}
