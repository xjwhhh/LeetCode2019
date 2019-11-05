public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);


    }

    private int search(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, left, mid);
        } else {
            return search(nums, mid + 1, right);
        }

    }
}
