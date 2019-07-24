public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num = nums1.length + nums2.length;

        int bmid=0;
        if(num%2==1){
            bmid=num/2;
        }else{
            bmid=num/2-1;
        }

        int index1 = 0;
        int index2 = 0;
        int q = 0;
//        int flag=0;
        while (q < bmid) {
            if (nums1[index1] >= nums2[index2]) {
                index2++;
                q++;
//                flag=2;
            } else {
                index1++;
                q++;
//                flag=1;
            }
        }
//        if(flag==1){
//            index1--;
//        }else if(flag==2){
//            index2--;
//        }
        if (num % 2 == 1) {

            if (nums1[index1] >= nums2[index2]) {
                return nums2[index2];
            } else {
                return nums1[index1];
            }
        } else {
            int a = 0;

            if (nums1[index1] >= nums2[index2]) {
                a = nums2[index2];
                index2++;
            } else {
                a = nums1[index1];
                index1++;
            }
            if (nums1[index1] >= nums2[index2]) {
                return (a + nums2[index2]) / 2;

            } else {
                return (a + nums1[index1]) / 2;

            }

        }


    }

}
