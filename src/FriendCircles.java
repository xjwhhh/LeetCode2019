import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-07 14:33
 * @Email xjwhhh233@outlook.com
 */
public class FriendCircles {
    public int findCircleNum(int[][] M) {
        if(M==null||M.length==0||M[0].length==0){
            return 0;
        }
        int[] visited=new int[M.length];
        int count=0;

        for(int i=0;i<M.length;i++){
            if(visited[i]==0){
                count++;
                dfs(M,visited,i);
            }
        }
        return count;


    }

    private void dfs(int[][]M,int[] visited,int i){
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public int findCircleNum1(int[][] M) {
        if(M==null||M.length==0||M[0].length==0){
            return 0;
        }
        int[] visited=new int[M.length];
        int count=0;
        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<M.length;i++){
            if(visited[i]==0){
                queue.add(i);
                visited[i]=0;
                while(!queue.isEmpty()){
                    int s=queue.poll();
                    for(int j=0;j<M.length;j++ ){
                        if(M[s][j]==1&&visited[j]==0){
                            queue.add(j);
                            visited[j]=0;
                        }
                    }
                }
                count++;

            }
        }
        return count;


    }
}
