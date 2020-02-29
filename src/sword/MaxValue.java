package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 16:44
 * @Email xjwhhh233@outlook.com
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int row=grid.length;
        int column=grid[0].length;
        int[][] dp=new int[row][column];
        dp[0][0]=grid[0][0];
        for(int i=1;i<column;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for(int i=1;i<row;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<column;j++){
                dp[i][j]=grid[i][j]+Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[row-1][column-1];
    }

}
