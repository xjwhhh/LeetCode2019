import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IncreasingSubsequences {
    static List<List<Integer>> result=new ArrayList<>();
    public static List<List<Integer>> findSubsequences(int[] nums) {
//        for(int i=0;i< nums.length;i++){
            backtrace(nums,new ArrayList<>(),0);
//        }


        return result;
    }

    private static void backtrace(int[] nums,List<Integer> list,int start){


        if(start>=nums.length){
            if(list.size()>=2){
                result.add(new ArrayList<>(list));
            }
            return;
        }

        if(list.size()==0||nums[start]>=list.get(list.size()-1)){
            list.add(nums[start]);
            backtrace(nums,list,start+1);
            list.remove(list.size()-1);
        }

        if (start > 0 && !list.isEmpty() && nums[start] == list.get(list.size() - 1)) {
            return;
        }
        // 不把第 index 个元素加进 list 中
        backtrace(nums, list, start + 1);




    }

    public static void main(String[] args){
        int[] a={4,6,7,7};
        findSubsequences(a);

    }
}
