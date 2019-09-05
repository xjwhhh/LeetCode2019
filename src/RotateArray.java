public class RotateArray {
    //wrong
//    public void rotate(int[] nums, int k) {
//        if(k==0||nums.length==0){
//            return;
//        }
//        int len=nums.length;
//        k=k%len;
//        if(len%k!=0) {
//
//            int count = 1;
//            int temp = nums[0];
//            int index = 0;
//            while (count <= len) {
//                int newIndex = (index + k) % len;
//                int newTemp = nums[newIndex];
//                nums[newIndex] = temp;
//                temp = newTemp;
//                index = newIndex;
//                count++;
//            }
//        }else{
//            for(int i=0;i<k;i++) {
//                int count = 1;
//                int temp = nums[i];
//                int index = i;
//                while (count <= len/k) {
//                    int newIndex = (index + k) % len;
//                    int newTemp = nums[newIndex];
//                    nums[newIndex] = temp;
//                    temp = newTemp;
//                    index = newIndex;
//                    count++;
//                }
//            }
//        }
//
//
//
//
//    }


    public void rotate1(int[] nums, int k) {

        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }


    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
