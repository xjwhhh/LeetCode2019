/**
 * @Author JiaWei Xu
 * @Date 2020-03-07 14:18
 * @Email xjwhhh233@outlook.com
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        if(target<matrix[0][0]||target>matrix[matrix.length-1][matrix[0].length-1]){
            return false;
        }
        int row=0;
        for(int i=0;i<matrix.length;i++){
            if(target<matrix[i][0]){
                row=i-1;
                break;
            }else if(target==matrix[i][0]){
                return true;
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            if(target==matrix[row][i]){
                return true;
            }else if(target<matrix[row][i]){
                return false;
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            if(target==matrix[matrix.length-1][i]){
                return true;
            }else if(target<matrix[matrix.length-1][i]){
                return false;
            }
        }

        return false;

    }

}
