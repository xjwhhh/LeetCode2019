package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 11:06
 * @Email xjwhhh233@outlook.com
 */
public class MovingCount {

    boolean[][] visited;
    int m;
    int n;
    int k;

    public int movingCount(int m, int n, int k) {
        visited=new boolean[m][n];
        this.m=m;
        this.n=n;
        this.k=k;
        return dfs(0,0,0,0);
    }

    private int dfs(int i,int j,int si,int sj){
        if(!reachable(i,j,si,sj)){
            return 0;
        }
        visited[i][j]=true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);

    }

    private boolean reachable(int i,int j,int si,int sj){
        if(i < 0 || i >= m || j < 0 || j >= n || k < si + sj || visited[i][j]) {
            return false;
        }
        return true;
    }
}
