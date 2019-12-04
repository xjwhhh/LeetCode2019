package OJ2019.homework.three;

import java.util.*;

public class Main11 {
    public static ArrayList<String> array= new ArrayList<String>();
    public static int min = Integer.MAX_VALUE;
    public static void  main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int cas = Integer.parseInt(scanner.nextLine());
        while (cas>0){
            int n = Integer.parseInt(scanner.nextLine());
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = i+1;
            }
            int[][] list = new int[n+1][n+1];
            String[] strlist = scanner.nextLine().split(",");
            for(String str :strlist){
                String[] templist = str.split(" ");
                list[Integer.parseInt(templist[0])][Integer.parseInt(templist[1])] = Integer.parseInt(templist[2]);
            }
            nextPer(arr,0,0,list);
            StringBuilder res = new StringBuilder();
            Collections.sort(array, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String[] list1 = o1.split(" ");
                    String[] list2 = o2.split(" ");
                    int temp = 1;
                    for(int i =0;i<list1.length;i++){
                        if(Integer.parseInt(list1[i])>Integer.parseInt(list2[i])){
                            temp=-1;
                            break;
                        }
                        if(Integer.parseInt(list1[i])<Integer.parseInt(list2[i])){
                            temp=1;
                            break;
                        }
                    }
                    return temp;
                }
            });


            for(String string:array){
                res.append(string+",");
            }
            System.out.println(res.substring(0,res.length()-1));
            array.clear();
            min=Integer.MAX_VALUE;
            cas--;
        }
    }
    private static void nextPer(int[] arr,int start,int count,int[][] list){
        if(start==arr.length-1){
            count+=list[arr[start]][start+1];
            if(count<min){
                array.clear();
                StringBuilder stringBuilder = new StringBuilder();
                for(int i=0;i<arr.length;i++){
                    if(i!=arr.length-1)
                        stringBuilder.append(arr[i]+" ");
                    else stringBuilder.append(arr[i]);
                }
                array.add(stringBuilder.toString());
                min = count;
            }
            else if(count==min){
                StringBuilder stringBuilder = new StringBuilder();
                for(int i=0;i<arr.length;i++){
                    if(i!=arr.length-1)
                        stringBuilder.append(arr[i]+" ");
                    else stringBuilder.append(arr[i]);
                }
                array.add(stringBuilder.toString());


            }
        }
        else {
            for(int i =start;i<arr.length;i++){
                int temp =arr[start];
                arr[start] = arr[i];
                arr[i] =temp;
                int tempcount =count + list[arr[start]][start+1];
                nextPer(arr,start+1,tempcount,list);
                arr[i] = arr[start];
                arr[start] = temp;
            }
        }
    }
}
