public class MedianOfTwoSortedArrays {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int num = nums1.length + nums2.length;
//
//        int bmid=0;
//        if(num%2==1){
//            bmid=num/2;
//        }else{
//            bmid=num/2-1;
//        }
//
//        int index1 = 0;
//        int index2 = 0;
//        int q = 0;
////        int flag=0;
//        while (q < bmid) {
//            if(index1< nums1.length&&index2<nums2.length) {
//                if (nums1[index1] >= nums2[index2]) {
//                    index2++;
//                    q++;
////                flag=2;
//                } else {
//                    index1++;
//                    q++;
////                flag=1;
//                }
//            }else if(index1>=nums1.length&&index2<nums2.length){
//                index2++;
//                q++;
//            }else if(index1< nums1.length&&index2>=nums2.length){
//                index1++;
//                q++;
//            }
//        }
////        if(flag==1){
////            index1--;
////        }else if(flag==2){
////            index2--;
////        }
//        if (num % 2 == 1) {
//            if (index1 < nums1.length && index2 < nums2.length) {
//                if (nums1[index1] >= nums2[index2]) {
//                    return nums2[index2];
//                } else {
//                    return nums1[index1];
//                }
//            } else {
//                int a = 0;
//                if (nums1[index1] >= nums2[index2]) {
//                    a = nums2[index2];
//                    index2++;
//                } else {
//                    a = nums1[index1];
//                    index1++;
//                }
//                if (nums1[index1] >= nums2[index2]) {
//                    return (a + nums2[index2]) / 2;
//
//                } else {
//                    return (a + nums1[index1]) / 2;
//
//                }
//
//            }
//
//        }else if(index1>=nums1.length&&index2<nums2.length){
//            if(num%2==1) {
//                return nums2[index2];
//            }else{
//                return (nums2[index2]+nums2[index2+1])/2;
//            }
//        }else if(index1< nums1.length&&index2>=nums2.length){
//            return nums1[index1];
//        }
//
//
//    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) { // to ensure m<=n
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

}
