public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robHelper(nums, 0, nums.length - 1),
                robHelper(nums, 1, nums.length));
    }

    private int robHelper(int[] nums, int start, int end) {
        int[] array = new int[end - start + 1];
        array[0] = 0;
        array[1] = nums[start];
        for (int i = 2; i < array.length; i++) {
            array[i] = Math.max(array[i - 2] + nums[i - 1 + start], array[i - 1]);
        }
        return array[array.length - 1];
    }
}
