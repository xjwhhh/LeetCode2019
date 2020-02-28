package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 14:52
 * @Email xjwhhh233@outlook.com
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null){
            return new int[0];
        }
        int row=matrix.length;
        if(row==0){
            return new int[0];
        }
        int column=matrix[0].length;
        int[] result=new int[row*column];
        int left=0;
        int right=column-1;
        int up=0;
        int down=row-1;
        int index=0;
        System.out.println(row);
        System.out.println(column);
        while(left<=right&&up<=down){
            for(int i=left;i<=right;i++){
                result[index]=matrix[up][i];
                index++;
            }
            for(int i=up+1;i<=down;i++){
                result[index]=matrix[i][right];
                index++;
            }
            if(up!=down) {
                for (int i = right - 1; i >= left; i--) {
                    result[index] = matrix[down][i];
                    index++;
                }
            }
            if(left!=right) {
                for (int i = down - 1; i > up; i--) {
                    result[index] = matrix[i][left];
                    index++;
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        return result;


    }
}
