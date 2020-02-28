package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-27 17:28
 * @Email xjwhhh233@outlook.com
 */
public class MinArray {
    public int minArray(int[] numbers) {
        if(numbers==null||numbers.length==0){
            return 0;
        }
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]>numbers[i+1]){
                return numbers[i+1];
            }
        }
        return numbers[0];

    }
    //todo 二分法

    public int minArray1(int[] numbers) {
        if(numbers==null||numbers.length==0){
            return 0;
        }
        int left=0;
        int right=numbers.length-1;
        return helper(numbers,left,right);


    }

    private int helper(int[] numbers,int left,int right){
        if(left==right){
            return numbers[left];
        }
        int middle=(right-left)/2+left;
        if(numbers[middle]<numbers[right]){
            right=middle;
        }else if(numbers[middle]>numbers[right]){
            left=middle+1;
        }else{
            right--;
        }
        return helper(numbers,left,right);
    }
}
