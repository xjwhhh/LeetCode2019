package spring2020.baidu;


import java.util.*;
/**
 * @Author JiaWei Xu
 * @Date 2020-03-29 20:05
 * @Email xjwhhh233@outlook.com
 */
public class Three {
    private static int n;
    private static int[] weight;
    private static HashMap<Integer,List<Integer>> board;
    private static int[] road;
    private static int max=Integer.MIN_VALUE;
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        n=Integer.parseInt(scanner.nextLine());
        String[] numStr=scanner.nextLine().split(" ");
        weight=new int [n+1];
        if(weight.length==0){
            System.out.println(0);
        }else{
            for(int i=1;i<=n;i++){
                weight[i]=Integer.parseInt(numStr[i-1]);
            }
            board=new HashMap<>();
            road=new int[n+1];
            Arrays.fill(road,-1);
            for(int i=0;i<n-1;i++){
                String[] r=scanner.nextLine().split(" ");
                int from=Integer.parseInt(r[0]);
                int to=Integer.parseInt(r[1]);
                List temp1=board.getOrDefault(from,new ArrayList<Integer>());
                temp1.add(to);
                board.put(from,temp1);
                List temp2=board.getOrDefault(to,new ArrayList<Integer>());
                temp2.add(from);
                board.put(to,temp2);
            }
        }
        helper();
        System.out.println(max);
    }

    private static void helper(){
        for(int i=1;i<weight.length;i++){
            dfs(i);
        }
    }

    private static int dfs(int index){
        if(road[index]!=-1){
            max=Math.max(road[index],max);
            return road[index];
        }
        List<Integer> to=board.getOrDefault(index,new ArrayList<>());
        for(int i=0;i<to.size();i++){
            int toIndex=to.get(i);
            //可到达
            if(weight[toIndex]>weight[index]){
                if(road[toIndex]!=-1){
                    int count=1+road[toIndex];
                    max=Math.max(count,max);
                    road[index]=max;
                    return max;
                }else{
                    int count=1+dfs(toIndex);
                    max=Math.max(count,max);
                    road[index]=max;
                    return max;
                }
            }
        }
        road[index]=1;
        return 1;
    }
}
