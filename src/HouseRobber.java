public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int[] array=new int[nums.length+1];
        int temp=0;
        array[0]=0;
        array[1]=nums[0];
        for(int i=2;i<array.length;i++){
            array[i]=Math.max(array[i-2]+nums[i-1],array[i-1]);
        }

        return array[array.length-1];




    }
}
