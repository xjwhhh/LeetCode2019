public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        for(int i=1;i<A.length;i++){
            if(A[i]<A[i-1]){
                return i-1;
            }
        }
        return 0;

    }
}
