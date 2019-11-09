public class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]!=0){
                    int a=10001;
                    int b=10001;
                    if(i>0){
                        a=matrix[i-1][j]+1;
                    }
                    if(j>0){
                        b=matrix[i][j-1]+1;
                    }
                    matrix[i][j]=Math.min(a,b);

                }
            }
        }

        for(int i=matrix.length-1;i>=0;i--){
            for(int j=matrix[0].length-1;j>=0;j--){
                if(matrix[i][j]!=0){
                    if(i<matrix.length-1){
                        matrix[i][j]=Math.min(matrix[i][j],matrix[i+1][j]+1);
                    }
                    if(j<matrix[0].length-1){
                        matrix[i][j]=Math.min(matrix[i][j+1]+1,matrix[i][j]);
                    }
                }
            }
        }

        return matrix;



    }
}
