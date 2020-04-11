package spring2020.zhaohang;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-27 19:30
 * @Email xjwhhh233@outlook.com
 */
public class Two {

    static class Wood{
        int length;
        int weight;
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int T=Integer.parseInt(scanner.nextLine());
        for(int i=0;i<T;i++) {
            int n = Integer.parseInt(scanner.nextLine());
            Wood[] array=new Wood[n];
            String[] length=scanner.nextLine().split(" ");
            String[] weight=scanner.nextLine().split(" ");
            if(n==0){
                System.out.println(0);
                return;
            }
            for(int j=0;j<n;j++){
                Wood wood=new Wood();
                wood.length=Integer.parseInt(length[j]);
                wood.weight=Integer.parseInt(weight[j]);
                array[j]=wood;
            }

            int count1=lengthSort(array);
            int count2=weightSort(array);
//            System.out.println(count1);
//            System.out.println(count2);
            System.out.println(Math.min(count1,count2));

        }

    }

    private static int lengthSort(Wood[] array){
        PriorityQueue<Wood> priorityQueueLength=new PriorityQueue<>(new Comparator<Wood>() {
            @Override
            public int compare(Wood o1, Wood o2) {
                if(o1.length!=o2.length) {
                    return o1.length - o2.length;
                }else{
                    return o1.weight-o2.weight;
                }
            }
        });
        priorityQueueLength.addAll(Arrays.asList(array));
        int count=1;
        int preWoodWeight=priorityQueueLength.poll().weight;
//        System.out.println(preWood.length+","+preWood.weight);
        while(!priorityQueueLength.isEmpty()){
            Wood currWood=priorityQueueLength.poll();
//            System.out.println(currWood.length+","+currWood.weight);
            if(currWood.weight<preWoodWeight){
                count++;
            }
            preWoodWeight=currWood.weight;
        }
        return count;
    }

    private static int weightSort(Wood[] array){
        PriorityQueue<Wood> priorityQueueWeight=new PriorityQueue<>(new Comparator<Wood>() {
            @Override
            public int compare(Wood o1, Wood o2) {
                if(o1.weight!=o2.weight) {
                    return o1.weight - o2.weight;
                }else{
                    return o1.length-o2.length;
                }
            }
        });
        priorityQueueWeight.addAll(Arrays.asList(array));
        int count=1;
        int preWoodLength=priorityQueueWeight.poll().length;
//        System.out.println(preWood.weight+","+preWood.length);
        while(!priorityQueueWeight.isEmpty()){
            Wood currWood=priorityQueueWeight.poll();
//            System.out.println(currWood.weight+","+currWood.length);
            if(currWood.length<preWoodLength){
                count++;
            }
            preWoodLength=currWood.length;
        }
        return count;
    }
}
