package OJ2019.homework.two;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            String arrayString = scan.nextLine();
            String[] arrayStr = arrayString.split(" ");
            int[] array = new int[arrayStr.length];
            for (int j = 0; j < array.length; j++) {
                array[j] = Integer.parseInt(arrayStr[j]);
            }
            quickSort1(array,0,array.length-1);
            print(array);


        }
    }

    private static void quickSort(int[] array,int low,int high){
        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(array, low, high);

            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(array, low, index - 1);
            quickSort(array, index + 1, high);
        }


    }

    private static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }

    private static void print(int[] array){
        StringBuilder res=new StringBuilder();
        for(int j=0;j<array.length-1;j++){
            res.append(array[j]);
            res.append(" ");
        }
        if(array.length-1>=0) {
            res.append(array[array.length - 1]);
        }
        System.out.println(res);
    }

    //非递归
    static void quickSort1(int[] s,int left,int right){
        LinkedHashMap<Integer,Integer> lhp=new LinkedHashMap<>();
        //将0,n放入LinkedHashMap
        lhp.put(left,right);
        while(!lhp.isEmpty()){      //只要有需要排序的段
            //读取left，right
            Iterator<Map.Entry<Integer,Integer>> it=lhp.entrySet().iterator();
            left=it.next().getKey();
            right=lhp.get(left);
            //并从LinkedHashMap中删除
            lhp.remove(left,right);
            if(left>=right)continue;
            int i=left,j=right,temp=s[right];
            while(i<j){         //遍历排序一遍
                while(s[i]<=temp&&i<j)i++;
                if(i<j)s[j--]=s[i];
                while(s[j]>=temp&&i<j)j--;
                if(i<j)s[i++]=s[j];
            }
            s[i]=temp;
            lhp.put(left,i-1);
            lhp.put(i+1,right);
        }
    }


}
