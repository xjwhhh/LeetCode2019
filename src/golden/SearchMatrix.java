package golden;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-03 12:44
 * @Email xjwhhh233@outlook.com
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int i=0;
        int j=matrix[0].length-1;
        while(i<=matrix.length-1&&j>=0){
            if(matrix[i][j]>target){
                j--;
            }else if(matrix[i][j]<target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
