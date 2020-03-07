/**
 * @Author JiaWei Xu
 * @Date 2020-03-07 13:07
 * @Email xjwhhh233@outlook.com
 */
public class MaxAreaOfIsland {

    int[][] grid;
    int row;
    int column;
    int max=0;

    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        this.grid=grid;
        this.row=grid.length;
        this.column=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(this.grid[i][j]==1){
                    System.out.println("i:"+i);
                    System.out.println("j:"+j);
                    max=Math.max(max,dfs(i,j));
                }
            }
        }
        return max;

    }

    private int dfs(int r,int c){
        int count=0;
        if(r<0||r>=row||c<0||c>=column||grid[r][c]==0){
            return count;
        }
        grid[r][c]=0;
        count+=dfs(r-1,c);
        count+=dfs(r+1,c);
        count+=dfs(r,c-1);
        count+=dfs(r,c+1);
        System.out.println(count);
        return count;
    }
}
