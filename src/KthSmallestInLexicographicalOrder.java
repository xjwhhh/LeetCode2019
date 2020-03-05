import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-04 18:37
 * @Email xjwhhh233@outlook.com
 */
public class KthSmallestInLexicographicalOrder {
    //超时
    public static  int findKthNumber(int n, int k) {
        PriorityQueue<String> priorityQueue=new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i=1;i<=n;i++){
            priorityQueue.add(String.valueOf(i));
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        return Integer.valueOf(priorityQueue.poll());

    }

    public static void main(String[] args){
        System.out.println(findKthNumber(2,2));
    }

    public int findKthNumber1(int n, int k) {
        int cur=1;//第一字典序小的(就是1)
        int prefix=1;// 前缀从1开始
        while(cur<k) {
            int tmp=getCount(n,prefix); //当前prefix峰的值
            if(tmp+cur>k) {// 找到了
                prefix*=10; //往下层遍历
                cur++;//一直遍历到第K个推出循环
            }else {
                prefix++;//去下个峰头(前缀)遍历
                cur+=tmp;//跨过了一个峰(前缀)，把指针指向下一前缀的起点
            }
        }//退出循环时 cur==k 正好找到
        return prefix;
    }



    private int getCount(int n,int prefix){
        long curr=prefix;
        long next=curr+1;
        int count=0;
        while(curr<=n) {
            count+=Math.min(n+1,next)-curr;//下一峰头减去此峰头
            // 如果说刚刚prefix是1，next是2，那么现在分别变成10和20
            // 1为前缀的子节点增加10个，十叉树增加一层, 变成了两层

            // 如果说现在prefix是10，next是20，那么现在分别变成100和200，
            // 1为前缀的子节点增加100个，十叉树又增加了一层，变成了三层
            curr*=10;
            next*=10; //往下层走
        }
        return count;

    }
}
