package lesson.five;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
//            String temp=scan.nextLine();
//            String come = scan.nextLine();
//            String go = scan.nextLine();
//            int[] comArray=trans(come.split(" "));
//            int[] goArray=trans(go.split(" "));
            int N=scan.nextInt();
//            System.out.println(scan.nextInt());
//            System.out.println(scan.nextLine());
//            int N=6;
            int[] idArray=new int[N];
            int[] deadArray=new int[N];
            int[] profitArray=new int[N];
            for(int j=0;j<N;j++){
                idArray[j]=scan.nextInt();
                deadArray[j]=scan.nextInt();
                profitArray[j]=scan.nextInt();
            }
            helper(idArray,deadArray,profitArray);
        }
    }

    private static void helper(int[] id, int[] dead, int[] profitArray){
        int maxDead=findMax(dead);
        ArrayList<Integer> profits=new ArrayList<>();
        int num=0;
        int result=0;
        HashMap<Integer,ArrayList<Integer>> hashMap=new HashMap<>();
        for(int i=0;i<dead.length;i++){
            int ddl=dead[i];
            int profit=profitArray[i];
            if(hashMap.containsKey(ddl)){
                ArrayList<Integer> temp=hashMap.get(ddl);
                temp.add(profit);
                hashMap.put(ddl,temp);
            }else{
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(profit);
                hashMap.put(ddl,temp);
            }
        }
        for(int ddl=maxDead;ddl>0;ddl--){
            if(hashMap.containsKey(ddl)){
                profits.addAll(hashMap.get(ddl));
                int maxProfit=findListMax(profits);
                num++;
                result+=maxProfit;
                profits.remove(new Integer(maxProfit));
            }
        }
        System.out.print(num+" ");
        System.out.println(result);
    }

    private static int findListMax(ArrayList<Integer> array){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<array.size();i++){
            if(max<array.get(i)){
                max=array.get(i);
            }
        }
        return max;
    }

    private static int findMax(int[] array){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(max<array[i]){
                max=array[i];
            }
        }
        return max;
    }
}
