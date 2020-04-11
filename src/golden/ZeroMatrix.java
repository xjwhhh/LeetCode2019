package golden;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author JiaWei Xu
 * @Date 2020-04-11 20:27
 * @Email xjwhhh233@outlook.com
 */
public class ZeroMatrix {
    public void setZeroes(int[][] matrix) {
//        boolean[][] memory=new boolean[matrix.length][matrix[0].length];
        HashSet<Integer> row=new HashSet<>();
        HashSet<Integer> column=new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    row.add(i);
                    column.add(j);
                }
            }
        }
        Iterator<Integer> rowInteger=row.iterator();
        while(rowInteger.hasNext()){
            int i=rowInteger.next();
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j]=0;
            }
        }
        Iterator<Integer> colInteger=column.iterator();
        while(colInteger.hasNext()){
            int i=colInteger.next();
            for(int j=0;j<matrix.length;j++){
                matrix[j][i]=0;
            }
        }


    }
}
