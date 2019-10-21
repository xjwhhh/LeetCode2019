public class NumArray {
//    int[] nums;
//    int[][] result;
//
//    public NumArray(int[] nums) {
//        this.nums = nums;
//        int len=this.nums.length;
//        if(len>0) {
//            result = new int[len][len];
//
//            result[0][0] = this.nums[0];
//            for (int j = 1; j < len; j++) {
//                result[0][j] = result[0][j - 1] + this.nums[j];
//            }
//            for (int i = 1; i < len; i++) {
//                for (int j = i; j < len; j++) {
//                    result[i][j] = result[i][j - 1] + this.nums[j];
//                }
//            }
//        }
//
//    }
//
//    public int sumRange(int i, int j) {
//        return result[i][j];
//    }

    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

}
