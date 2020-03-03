package golden;

import java.util.Arrays;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-03 10:53
 * @Email xjwhhh233@outlook.com
 */
public class Search {
    public int search(int[] arr, int target) {
        int len = arr.length, low = 0, high = len - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (arr[mid] > arr[high]) low = mid + 1;
            else if (arr[mid] < arr[high]) high = mid;
            else --high;
        }
        int idx = Arrays.binarySearch(arr, 0, low, target);
        if (idx >= 0) {
            while (idx > 0 && arr[idx - 1] == target)
                --idx;
            return idx;
        }
        idx = Arrays.binarySearch(arr, low, len, target);
        if (idx >= 0) {
            while (idx > 0 && arr[idx - 1] == target)
                --idx;
            return idx;
        }
        return -1;



    }

//    private int result=Integer.MAX_VALUE;
//    private int target;
//    public int search(int[] arr, int target) {
//        if(arr==null||arr.length==0){
//            return -1;
//        }
//        this.target=target;
//        helper(arr,0,arr.length-1);
//        return result==Integer.MAX_VALUE?-1:result;
//
//    }
//
//    private void helper(int[] arr,int left,int right){
//        if(left>right){
////            if(target==arr[left]){
////                result=Math.min(result,left);
////            }
//            return;
//        }
//        int mid=(left+right)>>1;
//        if(arr[left]==target){
//            result=Math.min(result,left);
//            return;
//        }
//        if(arr[right]==target){
//            result=Math.min(result,right);
//            return;
//        }
//        if(arr[mid]==target){
//            result=Math.min(result,mid);
//            return;
//        }
//
//        if(arr[left]>arr[right]) {
//            if (arr[left] < arr[mid] && arr[left] < target && arr[mid] > target) {
//                helper(arr, left, mid - 1);
//            }
//            if (arr[left] > arr[mid] && (arr[left] < target || arr[mid] > target)) {
//                helper(arr, left, mid - 1);
//            }
//            if (arr[mid] < arr[right] && arr[mid] < target && arr[right] > target) {
//                // System.out.println(mid);
//                // System.out.println(right);
//                helper(arr, mid + 1, right);
//            }
//            if (arr[mid] > arr[right] && (arr[mid] < target || arr[right] > target)) {
//                helper(arr, mid + 1, right);
//            }
//        }else{
//            helper(arr, left, mid - 1);
//            helper(arr, mid + 1, right);
//        }
//    }
}
