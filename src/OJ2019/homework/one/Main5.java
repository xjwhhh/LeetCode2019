package OJ2019.homework.one;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num=scan.nextInt();
        for(int i=0;i<num;i++){
            String arrayString=scan.nextLine();
            arrayString=scan.nextLine();
            String[] array=arrayString.split(" ");
            int start=scan.nextInt();
            int end=scan.nextInt();
            int k=scan.nextInt();
            int[] A=new int[end-start+1];
            for(int j=start-1;j<=end-1;j++){
                A[j-start+1]=Integer.parseInt(array[j]);
            }
            System.out.println(QuickSelected(k-1,0,A.length-1,A));
        }
    }

    private static int Partition(int[] A, int left, int right){
        int pivot=A[right];//选取最末尾的值作为基准
        int tail=left-1;//指向小于基准的数组的最后一个元素
        for(int i=left;i<right;i++){
            if(A[i]<=pivot){
                swap(A,++tail,i);
            }
        }
        swap(A,tail+1,right);//此时tail+1指向第一个大于基准的元素，交换位置，基准在中间
        return tail+1;//返回基准的索引
    }


    private static int QuickSelected(int k, int left, int right, int[] A){
        if(A.length == 0){
            return 0;
        }
        while(true){
            int index=Partition(A,left,right);
            if(index==k){
                return A[index];
            }else if(index > k){
                right=index-1;
            }else{
                left=index+1;
            }
        }
    }
    private static void swap(int[] A, int a, int b){
        int temp=A[a];
        A[a]=A[b];
        A[b]=temp;
    }
}

