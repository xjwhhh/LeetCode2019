public class Sqrtx {
    public int mySqrt(int x) {
        int left=0;
        int right=x;
        while(left<right){
            int mid=(left+right+1)>>1;
            if(mid*mid>x){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;

    }
}
