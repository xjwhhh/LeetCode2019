package homework.one;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 最大值减去最小值小于或等于num的子数组数量
 * @author chaplinJ
 *
 */
public class Main1 {
//
//    public static int getNum(int[] arr,int num){
//        if(arr == null || arr.length == 0){
//            return 0;
//        }
//        int res = 0;
//
//        int i = 0;
//        int j = 0;
//        Deque<Integer> qmax = new LinkedList<>();
//        Deque<Integer> qmin = new LinkedList<>();
//        while(i < arr.length){
//            while( j < arr.length){
//
//                //维护窗口最大值
//                while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
//                    qmax.pollLast();
//                }
//                qmax.addLast(j);
//                //维护窗口最小值
//                while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]){
//                    qmin.pollLast();
//                }
//                qmin.addLast(j);
//                if(arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num){
//                    break;
//                }
//                j++;
//            }
//            res += j - i;
//            if(qmax.peekFirst() == i){
//                qmax.poll();
//            }
//            if(qmin.peekFirst() == i){
//                qmin.poll();
//            }
//            i++;
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        int a[] = {3 ,6, 4, 3, 2};
//        int result = getNum(a, 2);
//        System.out.println(result);
//    }


//    public static int getNum(int[] arr,int num){
//        int ans=0;
//        int i=0;
//        int j=0;
//        LinkedList<Integer> linkedList1=new LinkedList<Integer>();
//        LinkedList<Integer> linkedList2=new LinkedList<Integer>();
//        while(i<arr.length){
//            while(j<arr.length){
//                while(!linkedList1.isEmpty()&&arr[linkedList1.peekLast()]<arr[j])
//                    linkedList1.removeLast();
//                linkedList1.addLast(j);
//                while(!linkedList2.isEmpty()&&arr[linkedList2.peekLast()]>arr[j])
//                    linkedList2.removeLast();
//                linkedList2.addLast(j);
//                if((arr[linkedList1.peekFirst()]-arr[linkedList2.peekFirst()])>num){
//                    break;
//                }
//                j++;
//            }
//            ans+=j-i;
//            if(linkedList1.peekFirst()==i)
//                linkedList1.removeFirst();
//            if(linkedList2.peekFirst()==i)
//                linkedList2.removeFirst();
//            i++;
//        }
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(getNum(new int[]{2,3,1,6,4}, 2));
//        System.out.println(getNum(new int[]{3,6,4,3,2}, 2));
//    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String arrayString=scan.nextLine();
            String[] array=arrayString.split(" ");
            int n=Integer.parseInt(scan.nextLine());
            helper(array,n);
        }
    }
    private static void helper(String[] array,int n){
        int count=0;
        for(int i=0;i<array.length;i++){
            int min=Integer.parseInt(array[i]);
            int max=Integer.parseInt(array[i]);
            for(int j=i+1;j<array.length;j++){
                int temp=Integer.parseInt(array[j]);
                if(temp<min){
                    min=temp;
                }
                if(temp>max){
                    max=temp;
                }
                if(max-min>n){
                    count+=(array.length-j);
                    break;
                }

            }
        }
        System.out.println(count);

    }

}
