package spring2020.kuaishoubishi;

import java.util.*;
/**
 * @Author JiaWei Xu
 * @Date 2020-03-22 18:58
 * @Email xjwhhh233@outlook.com
 */
public class Four {

    private static int n;
    private static int m;
    private static int a;
    private static int b;

    private static int[][] board;
    private static boolean[][] memo;

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        ArrayList<String> arrayList=new ArrayList<>();
        String[] array=scanner.nextLine().split(" ");
        n=Integer.parseInt(array[0]);
        m=Integer.parseInt(array[1]);
        a=Integer.parseInt(array[2]);
        b=Integer.parseInt(array[3]);
        board=new int[n][m];
        for(int i=0;i<n;i++){
            String[] temp=scanner.nextLine().split(" ");
            for(int j=0;j<m;j++){
                board[i][j]=Integer.parseInt(temp[j]);
            }
        }
        memo=new boolean[n][m];
        helper();
    }

    private static void helper(){
        while(true){
            int[] index=findMin();
            if(index[0]==-1&&index[1]==-1){
                break;
            }else{
                StringBuilder stringBuilder=new StringBuilder();
                for(int i=0;i<index.length;i++){
                    stringBuilder.append(index[i]).append(" ");
                }
                System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));
            }
        }

    }

    private static int[] findMin(){
        int[] result={-1,-1,-1};
        int minCost=Integer.MAX_VALUE;
        boolean heng=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
//                System.out.println(i);
//                System.out.println(j);
                int costH=checkHeng(i,j);
//                System.out.println("h"+costH);
                int costZ=checkZong(i,j);
//                System.out.println("z"+costZ);

                if(costH!=Integer.MAX_VALUE||costZ!=Integer.MAX_VALUE){
                    if(costH<costZ){
                        if(minCost>costH){
                            minCost=costH;
                            heng=true;
                            result[0]=i;
                            result[1]=j;
                        }
                    }else{
                        if(minCost>costZ){
                            minCost=costZ;
                            heng=false;
                            result[0]=i;
                            result[1]=j;
                        }
                    }
                }
//                System.out.println(minCost);
            }
        }
        if(minCost!=Integer.MAX_VALUE){
            if(heng){
                for(int k=result[0];k<result[0]+a;k++){
                    for(int t=result[1];t<result[1]+b;t++){
                        memo[k][t]=true;
                    }
                }
            }else{
                for(int k=result[0];k<result[0]+b;k++){
                    for(int t=result[1];t<result[1]+a;t++){
                        memo[k][t]=true;
                    }
                }
            }
            result[0]++;
            result[1]++;
            result[2]=minCost;
//            System.out.println(result[0]+","+result[1]);
//            System.out.println(heng);
            return result;
        }
        return result;
    }

    private static int checkZong(int i,int j){
        //已被使用
        if(memo[i][j]){
            return Integer.MAX_VALUE;
        }
        boolean canUse=true;
        if(i+b<=n&&j+a<=m){
            for(int k=i;k<i+b;k++){
                for(int t=j;t<j+a;t++){
                    if(memo[k][j]){
                        canUse=false;
                        break;
                    }
                }
            }
        }else{
            canUse=false;
        }
        int zong=Integer.MAX_VALUE;
        if(canUse){
            zong=0;
            int min=Integer.MAX_VALUE;
            for(int k=i;k<i+b;k++){
                for(int t=j;t<j+a;t++){
                    min=Math.min(min,board[k][t]);
                }
            }
            for(int k=i;k<i+b;k++){
                for(int t=j;t<j+a;t++){
                    zong+=board[k][t]-min;
                }
            }
        }
        return zong;
    }

    private static int checkHeng(int i,int j){
        //已被使用
        if(memo[i][j]){
            return Integer.MAX_VALUE;
        }
        boolean canUse=true;
        //横向
        if(i+a<=n&&j+b<=m){
            for(int k=i;k<i+a;k++){
                for(int t=j;t<j+b;t++){
                    if(memo[k][j]){
                        canUse=false;
                        break;
                    }
                }
            }
        }else{
            canUse=false;
        }
        int heng=Integer.MAX_VALUE;
        if(canUse){
            heng=0;
            int min=Integer.MAX_VALUE;
            for(int k=i;k<i+a;k++){
                for(int t=j;t<j+b;t++){
                    min=Math.min(min,board[k][t]);
                }
            }
            for(int k=i;k<i+a;k++){
                for(int t=j;t<j+b;t++){
                    heng+=board[k][t]-min;
                }
            }
        }
        return heng;
    }
}
