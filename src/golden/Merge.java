package golden;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-03 10:27
 * @Email xjwhhh233@outlook.com
 */
public class Merge {
    public void merge(int[] A, int m, int[] B, int n) {
        int i=m-1;
        int j=n-1;
        int index=m+n-1;
        while(i>=0&&j>=0){
            if(A[i]<B[j]){
                A[index--]=B[j];
                j--;
            }else{
                A[index--]=A[i];
                i--;
            }
        }
        if(i>=0){
            for(int t=i;t>=0;t--){
                A[index--]=A[t];
            }
        }
        if(j>=0){
            for(int t=j;t>=0;t--){
                A[index--]=B[t];
            }
        }


    }
}
