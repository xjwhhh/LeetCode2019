/**
 * @Author JiaWei Xu
 * @Date 2020-03-05 10:36
 * @Email xjwhhh233@outlook.com
 */
public class NumberOfIslands {

    char[][] grid;
    int row;
    int column;

    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        this.grid=grid;
        this.row=grid.length;
        this.column=grid[0].length;
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(this.grid[i][j]=='1') {
                    count++;
                    dfs( i, j);
                }
            }
        }
        return count;
    }

    private void dfs( int r, int c){
        if(r<0||r>=row||c<0||c>=column||grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        dfs(r-1,c);
        dfs(r+1,c);
        dfs(r,c-1);
        dfs(r,c+1);
    }
}
