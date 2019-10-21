public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row=obstacleGrid.length;
        int col=obstacleGrid[0].length;
        int[][] dp=new int[row][col];

        if(obstacleGrid[0][0]==1){
            return 0;
        }

        dp[0][0]=1;
        for(int i=1;i<row;i++){
            if(obstacleGrid[i][0]==1) {
                dp[i][0]=0;
            }else{
                dp[i][0]=dp[i-1][0];
            }
        }

        for(int j=1;j<col;j++){
            if(obstacleGrid[0][j]==1){
                dp[0][j]=0;
            }else{
                dp[0][j]=dp[0][j-1];
            }
        }

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }

        return dp[row-1][col-1];



    }
}
