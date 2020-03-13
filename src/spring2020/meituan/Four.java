package spring2020.meituan;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-12 19:09
 * @Email xjwhhh233@outlook.com
 */
public class Four{
    static HashMap<Integer,Integer> prod=new HashMap<>();
    static int[][] road;
    static int n;
    static int k;
    static int m;
    static int[][] visited;
    static int[][] mark;

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
         n=scanner.nextInt();
         m=scanner.nextInt();
         k=scanner.nextInt();
        for(int i=0;i<n;i++){
            prod.put(i+1,scanner.nextInt());
        }
        road=new int[n+1][n+1];
        visited=new int[n+1][n+1];
        mark=new int[n+1][k+1];
        for(int i=0;i<mark.length;i++){
            for(int j=0;j<mark[0].length;j++){
                mark[i][j]=-1;
            }
        }
        for(int i=0;i<n;i++){
            int u=scanner.nextInt();
            int v=scanner.nextInt();
            road[u][v]=1;
        }
        reLoad();
        helper();
    }

    private static void reLoad(){
        for(int i=0;i<road.length;i++){
            for(int j=0;j<road[0].length;j++){
                if(road[i][j]==1){
                    road[j][i]=1;
                }
            }
        }
    }

    private static void helper(){
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=1;i<n+1;i++){
            int count=0;
            for(int j=1;j<=k;j++){
                int temp=dfs(i,j);
//                System.out.println(temp);
                if(temp!=Integer.MAX_VALUE){
                    count+=temp;
                }
            }
            stringBuilder.append(count).append(" ");
        }
        String result=stringBuilder.substring(0,stringBuilder.length()-1);
        System.out.println(result);
    }

    //寻找最短的路径
    private static int dfs(int i,int prodType){
        if(i<=0||i>=n+1){
            return -1;
        }
        if(prod.get(i)==prodType){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for(int j=1;j<=n;j++){
            if(road[i][j]==1&&visited[i][j]==0){
                visited[i][j]=1;
                int temp=0;
                if(mark[j][prodType]!=-1){
                    temp=1+mark[j][prodType];

                }else{
                    temp=1+dfs(j,prodType);
                }
                if(temp>0){
                    min=Math.min(min,temp);
                    if(mark[i][prodType]!=-1){
                        mark[i][prodType]=Math.min(mark[i][prodType],min);
                    }
                }

                visited[i][j]=0;
            }
        }
        return min;
    }


}
