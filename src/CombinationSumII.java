import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSumII {
    List<List<Integer>> result=new ArrayList<>();
    int len=0;
    int[] candidates={};


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length==0){
            return result;
        }
        Arrays.sort(candidates);
        this.len=candidates.length;
        this.candidates=candidates;
        find(target,0,new Stack<>());
        return result;


    }

    public void find(int res, int start, Stack<Integer> pre){
        if(res==0){
            result.add(new ArrayList<>(pre));
            return;
        }
        for (int i = start; i < len && res - candidates[i] >= 0; i++) {
            if(i>start&&candidates[i]==candidates[i-1]) {
                continue;
            }
            pre.add(candidates[i]);
            find(res - candidates[i], i + 1, pre);
            pre.pop();
        }
    }
}
