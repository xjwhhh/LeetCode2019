import java.util.HashMap;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int a=0;
        int b=numbers.length-1;
        while(a<b){
            if(numbers[a]+numbers[b]==target){
                return new int[]{a+1,b+1};
            }else if(numbers[a]+numbers[b]<target){
                a++;
            }else if(numbers[a]+numbers[b]>target){
                b--;
            }
        }
        return null;
    }
}
