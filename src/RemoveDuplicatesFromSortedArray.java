public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int temp=nums[0]-1;
        for(int i=0;i<nums.length;){
            int j=i+1;

            while(j<nums.length&&nums[j]==nums[i]){
                nums[j]=temp;
                j++;
            }
            i=j;
        }
        int start=0;
        while(start<nums.length&&nums[start]!=temp){
            start++;
        }
        for(int i=start;i<nums.length;i++){
            int j=i+1;
            while(j<nums.length&&nums[j]==temp){
                j++;
            }
            if(j<nums.length) {
                nums[i] = nums[j];
                nums[j] = temp;
                start++;
            }else{
                break;
            }

        }
        return start+1;

    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


}
