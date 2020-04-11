package spring2020.baidu;

import java.math.BigInteger;
import java.util.*;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-29 19:34
 * @Email xjwhhh233@outlook.com
 */
public class Two {

    private static int n;
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        n=Integer.parseInt(scanner.nextLine());
        String[] numStr=scanner.nextLine().split(" ");
        Long[] num=new Long[numStr.length];
        if(num.length==0){
            System.out.println(0);
        }else{
            for(int i=0;i<numStr.length;i++){
                num[i]=Long.parseLong(numStr[i]);
            }
            helper(num);

        }
    }
//
//    private static void helper(Long[] num){
//        Long count=0L;
////        PriorityQueue<Long> priorityQueue=new PriorityQueue<>(new Comparator<Long>() {
////            @Override
////            public int compare(Long o1, Long o2) {
////                return o2.compareTo(o1);
////            }
////        });
////        priorityQueue.addAll(Arrays.asList(num));
//////        while(!priorityQueue.isEmpty()){
//////            System.out.println(priorityQueue.poll());
//////        }
////        while(!priorityQueue.isEmpty()){
////            BigInteger temp=priorityQueue.poll();
//////            System.out.println(temp);
//////            System.out.println(temp.compareTo(new BigInteger(String.valueOf(n))));
////
////            if(temp.compareTo(new BigInteger(String.valueOf(n)))!=-1){
//////                Iterator<BigInteger> integerIterator=priorityQueue.iterator();
//////                while(integerIterator.hasNext()){
//////                    BigInteger bigTemp=integerIterator.next().
//////                    integerIterator.next()
//////                }
////                int k=priorityQueue.size();
//////                System.out.println("开始增益");
////                List<BigInteger> list=new ArrayList<>();
////                for(int i=0;i<k;i++){
////                    BigInteger bigTemp=priorityQueue.poll();
//////                    System.out.println(bigTemp);
////                    list.add(bigTemp.add(one));
////                }
////                priorityQueue.addAll(list);
////                priorityQueue.add(temp.subtract(new BigInteger(String.valueOf(n))));
////                count=count.add(one);
////            }else{
////                break;
////            }
////        }
//        System.out.println(count);
//    }


    private static void helper(Long[] num){
        Long count=0L;
        Arrays.sort(num,Comparator.reverseOrder());
        while(num[0]>=n){
            num[0]-=(n+1);
            if(num[0]<num[1]) {
                Arrays.sort(num);
            }
            for(int i=0;i<num.length;i++){
                num[i]++;
            }
            count++;
        }
        System.out.println(count);
    }
}
