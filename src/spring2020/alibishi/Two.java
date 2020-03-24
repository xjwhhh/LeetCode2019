package spring2020.alibishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Two {

    private  static int max;

    private static int[] saveLen;

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        String[] array=new String[n];
        for(int i=0;i<n;i++){
            String a=String.valueOf(scanner.nextLine());
            array[i]=a;
        }
        if(n==0){
            return;
        }
        if(n==1){
            System.out.println(array[0]);
        }
        saveLen=new int[n];
        Arrays.sort(array);
        ArrayList<String> arrayList=new ArrayList<>();
        backtrace(array,0,arrayList,0);
        System.out.println(max);
    }


    /**
     * 回溯
     * @param array
     * @param start
     * @param arrayList
     * @param len
     */
    private static int backtrace(String[] array,int start,ArrayList<String> arrayList,int len){
        if(start==array.length-1){
            String temp = arrayList.get(arrayList.size() - 1);
            if (array[start].charAt(0) >= temp.charAt(temp.length() - 1)) {
                arrayList.add(array[start]);
                saveLen[start]=array[start].length();
                return array[start].length();
            }else{
                return 0;
            }
        }

        int nowMax=0;
        for(int i=start;i<array.length;i++){
            if(arrayList.isEmpty()){
                arrayList.add(array[i]);
                int newLen=len+array[i].length();
                nowMax=array[i].length();
                max = Math.max(max, newLen);
                if(i+1<array.length&&saveLen[i+1]!=0){
//                    max+=saveLen[i+1];
                    nowMax+=saveLen[i+1];
                }else {
//                    max+=backtrace(array, i + 1, arrayList, newLen);
                    nowMax+=backtrace(array, i + 1, arrayList, newLen);
                }
                saveLen[start]=nowMax;
            }else {
                String temp = arrayList.get(arrayList.size() - 1);
                if (array[i].charAt(0) >= temp.charAt(temp.length() - 1)) {
                    arrayList.add(array[i]);
                    int newLen=len+array[i].length();
                    nowMax=array[i].length();
//                    max = Math.max(max, newLen);
                    if(i+1<array.length&&saveLen[i+1]!=0){
//                        max+=saveLen[i+1];
                        nowMax+=saveLen[i+1];
                    }else {
//                        max+=backtrace(array, i + 1, arrayList, newLen);
                        nowMax+=backtrace(array, i + 1, arrayList, newLen);
                    }
                }
                saveLen[start]=nowMax;
                max=Math.max(max,nowMax);
            }
            saveLen[start]=0;

        }
        if(!arrayList.isEmpty()) {
            arrayList.remove(arrayList.size() - 1);
        }
        return nowMax;
    }
}
